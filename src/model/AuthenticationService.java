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
public class AuthenticationService {
    public void login () {}
    public void logout () {}
    
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
