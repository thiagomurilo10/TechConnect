/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techconnect.DAO;

import com.techconnect.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 824145766
 */
public class admDAO {
    public boolean validarLogin(String login, String senha) {
        try (Connection conn = ConexaoBD.getConnection();
            PreparedStatement ps = conn.prepareStatement("{call sp_SelecionaPessoaTblAdm(?, ?)}")) {
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
