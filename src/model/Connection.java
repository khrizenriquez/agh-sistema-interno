/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

/**
 *
 * @author khriz
 */
public class Connection {
    
    Connection conn             = null;
    private String controller   = "org.sqlite.JDBC";
    private String databaseName = "agh-sistema-interno.sqlite";
    private String path         = "jdbc:sqlite:src/configurations/" + databaseName;
    public Connection startConnection () {
        try {
            Class.forName(controller);
            conn = (Connection) DriverManager.getConnection(path);

            return conn;
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
            return null;
        }
    }
    
    public Connection closeConnection () {
        return conn = null;
    }
}
