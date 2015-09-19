package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    
    private String databaseName = "agh-sistema-interno.sqlite";
    private Connection conexion;
    private Statement statement;
    private static Conexion instance;

    public static Conexion getInstance() throws ClassNotFoundException{
        if(instance == null){
            instance = new Conexion();
        }
        return instance;
    }
    public Conexion() throws ClassNotFoundException{
        try {
            Class.forName("org.sqlite.JDBC");    
            conexion = DriverManager.getConnection("jdbc:sqlite:src/configurations/" + databaseName);
            System.out.println("Conexión exitosa a la base de datos");
            statement = conexion.createStatement();
        }catch (SQLException e){
            e.printStackTrace();            
        }
    }
    public ResultSet doQuery (String query) {
        ResultSet result = null;
        try {
            result = statement.executeQuery(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
