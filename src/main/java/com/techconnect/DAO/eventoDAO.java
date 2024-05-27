/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techconnect.DAO;

import com.techconnect.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 824145766
 */
public class EventoDAO {
    public void cadastraEvento(String nome,String descricao,java.sql.Date dataInicio, java.sql.Date dataTermino) throws SQLException{
         try (Connection conn = ConexaoBD.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO tbl_Evento (nomeEvento, descricao, dataInicio, dataFinal) VALUES (?, ?, ?, ?)")) {
            ps.setString(1, nome);
            ps.setString(2, descricao);
            ps.setDate(3, dataInicio);
            ps.setDate(4, dataTermino);
            ps.executeUpdate();           
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar evento: " + e.getMessage());
            throw e;
        }
    }
}
