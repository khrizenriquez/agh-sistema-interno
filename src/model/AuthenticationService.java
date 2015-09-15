/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author khriz
 */
public class AuthenticationService extends Connection {
    public void login () {}
    public void logout () {}
    
    public boolean matchCredentials (String username, String password) {
        String user = this.trimValues(username);
        String pass = this.trimValues(password);
        
        

        return true;
    }
    public String trimValues (String value) {
        String tmpValue = value.trim().replaceAll("^\\s*$","");

        return tmpValue;
    }
    protected void matchUser () {}
    protected boolean macthPassword (String password, String hashPassword) {
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
