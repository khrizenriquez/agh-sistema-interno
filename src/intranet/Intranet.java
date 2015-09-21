/*
*/
package intranet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;
import model.User;

/**
 * @author Duku
 */
public class Intranet extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.show();
        //http://www.jc-mouse.net/base-de-datos/sqlitejava-conexion
        
        User u = new User();
        //System.out.println(u.getUserPassword("khrizenriquez"));
        //System.out.println(u.getUserByPassword("khrizenriquez", "12345678"));
      //  System.out.print(u.getUserByPassword("khrizenriquez", "12345678"));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
