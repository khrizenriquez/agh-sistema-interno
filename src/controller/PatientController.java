package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javax.swing.JOptionPane;
import system.StartClass;
/**
 *
 * @author jonathanhernandez
 */
public class PatientController implements Initializable {
   private StartClass escenarioPrincipal;
    @Override
        public void initialize(URL location, ResourceBundle resources) {
    }
   public void setEscenarioPrincipal(StartClass escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
   }
   public void backToMenu(){
       try{
        escenarioPrincipal.ventanaMenu();
       }
       catch(Exception e){
           e.printStackTrace();
       }
   }
    
}
