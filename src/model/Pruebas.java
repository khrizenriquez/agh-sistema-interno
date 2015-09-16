/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonathanhernandez
 */
public class Pruebas {
    public static void main(String args[]){
        try {
            User usuario= new User();
            usuario.getUserByPassword("krhizenriquez", "12345678");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error");
        }
    }
}
