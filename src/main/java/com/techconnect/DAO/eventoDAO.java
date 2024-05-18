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
public class eventoDAO {
    public void cadastraEvento(String nome,String descricao,String dataInicio, String dataTermino) throws SQLException{
         try (Connection conn = ConexaoBD.getConnection();
            PreparedStatement ps = conn.prepareStatement("{call sp_CadastroEvento(?, ?, ?, ?)}")) {
            ps.setString(1, nome);
            ps.setString(2, descricao);
            ps.setString(3, dataInicio);
            ps.setString(4, dataTermino);
            ps.executeUpdate();           
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar evento: " + e.getMessage());
            throw e;
        }
    }
}
