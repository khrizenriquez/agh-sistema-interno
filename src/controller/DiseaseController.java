
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

/**
 *
 * @author jonathanhernandez
 */
public class DiseaseController implements Initializable {
private StartClass escenarioPrincipal;
@Override
    public void initialize(URL location, ResourceBundle resources) {}
    public void setEscenarioPrincipal(StartClass escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
     public void back(){
       try{
        escenarioPrincipal.ventanaMenu();
       }
       catch(Exception e){
           e.printStackTrace();
       }
   }
}
