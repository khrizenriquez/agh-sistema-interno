/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author Duku
 */
public class User extends Connection {
    private String tableName = "user";
    private String userName, password, createdAt, updatedAt;
    private int userTypeId, userStatus;

    public boolean setUser (String userName, String password, String createdAt, 
            String updatedAt, int userTypeId, int userStatus) {
        this.userName = userName;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userTypeId = userTypeId;
        this.userStatus = userStatus;

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
    
    public String setUserPassword (String password) {
        this.password = password;
        //  Source: http://www.codigofantasma.com/blog/implementar-encriptacion-md5-y-sha-en-java/
        String newPassword = this.getStringMessageDigest(this.password);

        return newPassword;
    }
    protected String getUserPassword (int id) {
        return "";
    }
    
    private static String toHexadecimal (byte[] digest) {
        String hash = "";
        for(byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);
        }
        return hash;
    }
    
    public static String getStringMessageDigest (String message) {
        String algorithm    = "SHA-512";
        byte[] digest       = null;
        byte[] buffer       = message.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException ex) {
            return "";
        }
        return toHexadecimal(digest);
    }

    protected void updateUser (int id, ArrayList params) {}
    
    protected boolean setUserType () {
        return true;
    }
    
    public void getUserByPassword (String username, String password) {
        ResultSet result = null;
        try {
            PreparedStatement st = conn.prepareStatement("select * from user");
            result = st.executeQuery();
            while (result.next()) {
                System.out.print("ID: ");
                System.out.println(result.getInt("id"));
 
                System.out.print("Nombre: ");
                System.out.println(result.getString("username"));
 
                System.out.print("Apellidos: ");
                System.out.println(result.getString("password"));
 
                System.out.println("=======================");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }
    protected int getUserType () {
        return 1;
    }
}
