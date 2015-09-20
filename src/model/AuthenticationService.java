/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.User;
import org.json.simple.JSONObject;
/**
 *
 * @author khriz
 */
public class AuthenticationService extends Conexion {

    public AuthenticationService() throws ClassNotFoundException {
    }
  
    public void login (String user, String pass) throws ClassNotFoundException {
        boolean response = this.matchCredentials(user, pass);
        
        if (!response) {
            
        }
        
        //Crear la sesión
    }
    public void logout () {
        //  Mato la sesión actual y muestro la escena de login
    }
    
    public boolean matchCredentials (String username, String password) throws ClassNotFoundException {
        User u = new User();
        
        String user = this.trimValues(username);
        String pass = u.setUserPassword(this.trimValues(password));
        
        JSONObject response = new JSONObject();
        response = u.getUserByPassword(user, pass);
        
        if (response.get("Data") == null) return false;

        return true;
    }
    public String trimValues (String value) {
        String tmpValue = value.trim().replaceAll("^\\s*$","");

        return tmpValue;
    }
    protected void matchUser () {}
    protected boolean macthPassword (String password, String hashPassword) throws ClassNotFoundException {
        String tmpPass = "";
        User u = new User();
        tmpPass = u.setUserPassword(password);

        return (tmpPass.equals(hashPassword)) ? true : false;
    }
    
    public boolean isAdmin (int userId) {
        return true;
    }
    public boolean isNormal (int userId) {
        return true;
    }
    public boolean isLogged (int userId) {
        return true;
    }
}
