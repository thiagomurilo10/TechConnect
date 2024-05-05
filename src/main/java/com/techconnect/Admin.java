/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author thiag
 */
public class Admin {
    private String login;
    private String senha;

    public Admin(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public boolean validarLogin() {
        try (Connection conn = ConexaoBD.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_Adm WHERE login = ? AND senha = ?")) {
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Erro ao validar login do administrador: " + e.getMessage());
            return false;
        }
    }
    
}
