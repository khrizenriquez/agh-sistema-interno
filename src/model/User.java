/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.security.MessageDigest;
import java.util.ArrayList;

/**
 * @author Duku
 */
public class User extends Connection {
    private String tableName = "user";

    public boolean setUser (String userName, String password, String createdAt, 
            String updatedAt, int userTypeId, int userStatus) {
        return true;
    }
    /*
        Función con parametro de userStatus por defecto
    */
    public boolean setUser (String userName, String password, String createdAt, 
            String updatedAt, int userTypeId) {
        return this.setUser(userName, password, createdAt, updatedAt, userTypeId, 1);
    }
    public void getUser (int id) {}
    
    protected String setUserPassword (String pass) {
        String newPassword = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(pass.getBytes());
            newPassword = new String(messageDigest.digest());
        } catch (Exception ex) {
            
        }
        
        return newPassword;
    }
    protected String getUserPassword (int id) {
        return "";
    }
    
    protected void matchUse () {}
    protected void macthPassword () {}
    
    protected void updateUser (int id, ArrayList params) {}
    
    protected boolean setUserType () {
        return true;
    }
    protected int getUserType () {
        return 1;
    }
}
