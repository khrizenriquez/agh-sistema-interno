/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import configurations.GeneralVariables;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.*;
import java.util.Date;

/**
 * @author Duku
 */
public class User extends Connection {
    private String tableName = "user";

    public void setUser (String username, String password, Date createdAt, Date updatedAt, int userTypeId) {}
    
    public void getUser (int id) {}
    
    public String getActualDate () {
        Date date = new Date();

        return GeneralVariables.dateFormat.format(date);
    }
}
