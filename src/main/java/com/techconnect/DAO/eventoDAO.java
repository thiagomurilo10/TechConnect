/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techconnect.DAO;

import com.techconnect.ConexaoBD;
import com.techconnect.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<Evento> buscarEventos(String ordem) {
        List<Evento> eventos = new ArrayList<>();
        String query = "SELECT * FROM tbl_Evento WHERE dataFinal >= CURDATE() ORDER BY " + ordem;

        try (Connection connection = ConexaoBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Evento evento = new Evento();
                evento.setId(rs.getInt("id"));
                evento.setNome(rs.getString("nomeEvento"));
                evento.setDescricao(rs.getString("descricao"));
                evento.setDataInicio(rs.getDate("dataInicio"));
                evento.setDataFinal(rs.getDate("dataFinal"));
                eventos.add(evento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventos;
    }

    public List<Evento> buscarEventosPorNome(String nome) {
        List<Evento> eventos = new ArrayList<>();
        String query = "SELECT * FROM tbl_Evento WHERE nomeEvento LIKE ? AND dataFinal >= CURDATE() ORDER BY nomeEvento";

        try (Connection connection = ConexaoBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Evento evento = new Evento();
                    evento.setId(rs.getInt("id"));
                    evento.setNome(rs.getString("nomeEvento"));
                    evento.setDescricao(rs.getString("descricao"));
                    evento.setDataInicio(rs.getDate("dataInicio"));
                    evento.setDataFinal(rs.getDate("dataFinal"));
                    eventos.add(evento);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventos;
    }

    public List<Evento> buscarEventosPorData(java.sql.Date data) {
        List<Evento> eventos = new ArrayList<>();
        String query = "SELECT * FROM tbl_Evento WHERE dataInicio >= ? AND dataFinal >= CURDATE() ORDER BY dataInicio";

        try (Connection connection = ConexaoBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setDate(1, data);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Evento evento = new Evento();
                    evento.setId(rs.getInt("id"));
                    evento.setNome(rs.getString("nomeEvento"));
                    evento.setDescricao(rs.getString("descricao"));
                    evento.setDataInicio(rs.getDate("dataInicio"));
                    evento.setDataFinal(rs.getDate("dataFinal"));
                    eventos.add(evento);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventos;
    }
}
