/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import configurations.Generals;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import org.json.simple.*;
/**
 * @author Duku
 */
public class User extends Conexion {
    
    private String tableName = "user";
    private String userName = null, password = null, createdAt = null, updatedAt = null;
    private int userTypeId = 0, userStatus = 0;
    private ResultSet rs = null;
    
   public User() throws ClassNotFoundException {}

    public User setUser (String userName, String password, String createdAt, 
            String updatedAt, int userTypeId, int userStatus) {
        this.userName   = userName;
        this.password   = password;
        this.createdAt  = createdAt;
        this.updatedAt  = updatedAt;
        this.userTypeId = userTypeId;
        this.userStatus = userStatus;

        return this;
    }
    public User setUser (String userName, String password, String createdAt, 
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

    protected void updateUser (int id, JSONObject params) {}
    
    protected boolean setUserType () {
        return true;
    }
    

    public JSONObject getUserByPassword (String username, String password) {
        JSONObject result = new JSONObject();
        String rawQuery = "SELECT * FROM " + tableName + " where "+ tableName +".user_name = '" 
                    + username + 
                    "' and "+ tableName +".password = '" 
                    + this.setUserPassword(password) + "'";
        try {
            rs = Conexion.getInstance().doQuery(rawQuery);
            result.put("Result", "OK");

            int count = 0;
            JSONArray tmpArrayData = new JSONArray();
            JSONObject tmpObjectData = new JSONObject();
            while (rs.next()) {
                tmpObjectData.put("username",   rs.getString("user_name"));
                tmpObjectData.put("password",   rs.getString("password"));
                tmpObjectData.put("createdAt",  rs.getString("created_at"));
                tmpObjectData.put("updatedAt",  rs.getString("updated_at"));
                tmpObjectData.put("status",     rs.getString("status"));
                tmpArrayData.add(tmpObjectData);
                count++;
            }
            
            if (count == 0) 
                result.put("Data", null);
            else
                result.put("Data", tmpArrayData);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            result.put("Result", "ERROR");
            result.put("Data", null);
            return result;
        }
    }
    
    /*
    *Obteneindo los valores de la bd, en base a un campo
    */
    public String getUserType (String user) {
        Generals generalInstance = new Generals();
        JSONObject returnData = new JSONObject();
        String fieldName = "user_type";

        System.out.println(user);
        returnData = generalInstance.genericQuery(tableName, fieldName, user);

        if (!returnData.get("Result").equals("OK")) {
            return null;
        }

        JSONObject tmp = (JSONObject) returnData.get("Data");

        return tmp.get(fieldName).toString();
    }
    public String getUserType () {
        String user = (this.userName == null) ? "" : this.userName;
        
        return this.getUserType(user);
    }
    
    public String getUserPassword (String user) {
        Generals generalInstance = new Generals();
        JSONObject returnData = new JSONObject();
        String fieldName = "password";

        System.out.println(user);
        returnData = generalInstance.genericQuery(tableName, fieldName, user);

        if (!returnData.get("Result").equals("OK")) {
            return null;
        }

        JSONObject tmp = (JSONObject) returnData.get("Data");

        return tmp.get(fieldName).toString();
    }
    public String getUserPassword () {
        String user = (this.userName == null) ? "" : this.userName;
        
        return this.getUserPassword(user);
    }
    
    public String getUserName (String user) {
        Generals generalInstance = new Generals();
        JSONObject returnData = new JSONObject();
        String fieldName = "user_name";

        System.out.println(user);
        returnData = generalInstance.genericQuery(tableName, fieldName, user);

        if (!returnData.get("Result").equals("OK")) {
            return null;
        }

        JSONObject tmp = (JSONObject) returnData.get("Data");

        return tmp.get(fieldName).toString();
    }
    public String getUserName () {
        String user = (this.userName == null) ? "" : this.userName;
        
        return this.getUserPassword(user);
    }
}
