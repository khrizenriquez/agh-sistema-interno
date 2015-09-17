

/**
 *
 * @author jonathanhernandez
 */
package system;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

// Se importan las clases necesarias para que funcione metodo cambiarEscena
import javafx.fxml.FXMLLoader;
import java.io.InputStream;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.layout.AnchorPane;

import static javafx.application.Application.launch;
import javafx.stage.StageStyle;
import controller.StartController;
import java.io.IOException;

public class Principal extends Application {
    private final String RUTAVISTAS ="/src/view/";
    private Stage escenarioPrincipal;
    public void ventanaMenu()throws IOException{
        //obtener el controlador creado en tiempo de ejecucion
        System.out.println(RUTAVISTAS+"Start.fxml----------------");
        StartController inicio = (StartController)cambiarEscena("/view/Start.fxml",600,800);
        
        inicio.setEscenarioPrincipal(this);
        
    }
//    public void ventanaContacto() throws IOException {
//        ContactoController contacto = 
//                (ContactoController)cambiarEscena(RUTAVISTAS+ "ContactoView.fxml",400,634);
//                contacto.setEscenarioPrincipal(this);
//    }
//    public void ventanaEmpleado() throws IOException {
//        EmpleadoController empleado = 
//                (EmpleadoController)cambiarEscena(RUTAVISTAS+ "EmpleadoView.fxml",400,634);
//                empleado.setEscenarioPrincipal(this);
//    }
    @Override
    public void start(Stage escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
        try{
        //EL 400 Y 634 TIENEN QUE CONINCIDIR CON LA VISTA ASI COMO EL NOMBRE, aqui jala el escenario
        //cambiarEscena(RUTAVISTAS+ "MenuView.fxml",400,634); 
            ventanaMenu();
            //ventanaEmpleado();
            //ventanaContacto();
        }catch(IOException e){
            e.printStackTrace(); // imprime la escepcion y responde a 3 preguntas porque se provoco donde y posible solucion
        }
        this.escenarioPrincipal.setTitle("Saludo"); //titulo del escenario
        this.escenarioPrincipal.initStyle(StageStyle.UNDECORATED); //el escenario no se decorara
        this.escenarioPrincipal.show(); // muestra el escenario
    }
    public Initializable cambiarEscena(String nombreEscena, int alto, int ancho)throws IOException {
        //1 carga de archivo fisico
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Principal.class.getResourceAsStream(nombreEscena);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Principal.class.getResource(nombreEscena));
        //fin de carga archivo fisico
        //recuperar archorpane de la ventana
        AnchorPane page;
        try {
            // arecupera el anchor pane
            page = (AnchorPane) loader.load(in);
        } finally {
            // cierra la referencia al archivo
            in.close();
        }
        // 2 pitar la escena
        Scene nuevaEscena = new Scene(page, ancho, alto);
        escenarioPrincipal.setScene(nuevaEscena);
        escenarioPrincipal.sizeToScene();
        // 3 Obtener el controlador
        return (Initializable) loader.getController();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
