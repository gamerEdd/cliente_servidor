package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    public static final String url = "jdbc:mysql://localhost:3306/basetransporte" + "?useTimezone=true&serverTimezone=UTC";
    public static final String user = "root";
    public static final String passs = "edd1234";
private static Conexion instancia;
      public static Conexion getInstancia(){
        if(instancia == null)
            instancia = new Conexion();
        return instancia;
    }
    public Connection miConexion() throws SQLException{
             Connection conn = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error cargar el driver.");
        }
        
        try {
            String url1 = url;
            conn = DriverManager.getConnection(url1,"root","edd1234");   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error "+ e);
        }
        
        return conn;
    } 
    
    
//    public  Connection getConnection() {
//        Connection conn = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = (Connection) DriverManager.getConnection(url, user, passs);
//            //JOptionPane.showMessageDialog(null, "exito");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return conn;
//    }

}
