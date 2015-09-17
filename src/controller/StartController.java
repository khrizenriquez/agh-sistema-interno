/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import system.Principal;
import javax.swing.JOptionPane;

public class StartController implements Initializable{
     private Principal escenarioPrincipal;
        @FXML private Button btnNuevo;
     
     public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    } 
    
     @Override
    public void initialize(URL location, ResourceBundle resources) {
        }
    
   

     public void decirHola(){
         JOptionPane.showMessageDialog(null, "Hola");
     }
}
