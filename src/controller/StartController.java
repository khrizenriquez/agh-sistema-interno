
package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import system.StartClass;

public class StartController implements Initializable{
    private StartClass escenarioPrincipal;
        @FXML private Button btnNuevo;
     
    public void setEscenarioPrincipal(StartClass escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    } 
    
     @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    public void windowPatient() throws IOException{
        try{
          escenarioPrincipal.openWindowPatient();
        }
        catch(Exception e){
            e.printStackTrace();
        }        
    }
    public void windowDisease()throws IOException{
        try{
          escenarioPrincipal.openWindowDisease();
        }
        catch(Exception e){
            e.printStackTrace();
        }  
    }
    public void exit(){
        System.exit(0);
    }
 }
   

    

