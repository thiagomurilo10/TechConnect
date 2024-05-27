/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techconnect.DAO;

import com.techconnect.ConexaoBD;
import com.techconnect.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 824145766
 */
public class UsuarioDAO {
    public boolean validarLogin(String login, String senha) {
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_Usuario WHERE login = ? AND senha = ?")) {
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Erro ao validar login do usuário: " + e.getMessage());
            return false;
        }
    }
    public boolean cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO tbl_Usuario (nomeUsuario, login, senha, idade, cpf, email, sexo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, Integer.parseInt(usuario.getIdade()));
            stmt.setString(5, usuario.getCpf());
            stmt.setString(6, usuario.getEmail());
            stmt.setString(7, usuario.getSexo());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
            return false;
        }
    }
}


