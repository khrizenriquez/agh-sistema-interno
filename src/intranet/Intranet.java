/*
*/
package intranet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;
import java.sql.*;
import model.User;

/**
 * @author Duku
 */
public class Intranet extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        //stage.setScene(scene);
        //stage.setResizable(false);
        //stage.show();
        User c = new User();
        System.out.print("CLAVE: " + c.setUserPassword("12345678"));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
