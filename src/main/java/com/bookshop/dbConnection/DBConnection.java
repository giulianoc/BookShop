/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.dbConnection;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author giuliano
 */
public class DBConnection {
    public Connection conn = null;
    public Statement stmt = null;
    public PreparedStatement pstmt = null;

    String dbName = "BookShop";
    String host = "localhost";
    String username = "root";
    String password = "";

    public Connection getConnection() throws Exception, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + dbName, username, password);
            stmt = conn.createStatement();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void removeConnection() throws SQLException {
        conn.close();
    }    
}
