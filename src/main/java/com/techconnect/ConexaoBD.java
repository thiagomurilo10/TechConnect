/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author thiag
 */
public class ConexaoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/techconnect";
    private static final String USUARIO = "root";
    private static final String SENHA = "Thiago0505"; // Coloque a senha de seu banco de dados

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
