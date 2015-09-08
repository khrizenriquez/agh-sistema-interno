/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    
    public String setUserPassword (String pass) {
        //  Source: http://www.codigofantasma.com/blog/implementar-encriptacion-md5-y-sha-en-java/
        String newPassword = this.getStringMessageDigest(pass);

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
