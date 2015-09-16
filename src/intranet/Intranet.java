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
        //http://www.jc-mouse.net/base-de-datos/sqlitejava-conexion
        
        String controller   = "org.sqlite.JDBC";
        String databaseName = "agh-sistema-interno.sqlite";
        String path         = "jdbc:sqlite:src/configurations/" + databaseName;
        Statement statement = null;
        Connection conn = null;
        try {
            Class.forName(controller);
            conn = (Connection) DriverManager.getConnection(path);
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
        
        String query = "SELECT * FROM user where user = 'khrizenriquez' and password = '12345678';";
        ResultSet resultSet = (ResultSet) conn.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM persona ; ");
        while (resultSet.next()) {
            System.out.println(resultSet.getRow());
        }
        //PreparedStatement st = conn.prepareStatement(query);
        /*
         PreparedStatement pstm = connection.prepareStatement(q);
        pstm.execute();
        pstm.close();
        */
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
