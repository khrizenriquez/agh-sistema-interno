package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    
    private String databaseName = "agh-sistema-interno.sqlite";
    private Connection conexion;
    private Statement sentencia;
    private static Conexion instancia;
    public static Conexion getInstancia() throws ClassNotFoundException{
        if(instancia == null){
            instancia= new Conexion();
        }
        return instancia;
    }
    public Conexion() throws ClassNotFoundException{
        try {
            Class.forName("org.sqlite.JDBC");    
            conexion = DriverManager.getConnection("jdbc:sqlite:src/configurations/" + databaseName);
            System.out.println("Conexión exitosa a la base de datos");
            sentencia = conexion.createStatement();
        }catch (SQLException e){
            e.printStackTrace();            
        }
    }
    public ResultSet hacerConsulta(String consulta ){
        ResultSet resultado = null;
        try{
            resultado= sentencia.executeQuery(consulta);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return resultado;
    }
}
