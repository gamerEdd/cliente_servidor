package Datos;


import Contratos.*;
import Entidad.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChoferDAO implements IChoferDAO{
    
    Connection conexion = null;
    private static ChoferDAO instancia;
    public static ChoferDAO getInstancia(){
        if(instancia == null)
            instancia = new ChoferDAO();
        return instancia;
    }
    
    @Override
    public int ingresar(Chofer chofer) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "insert into chofer(choferid,dni,nombre,apellidomaterno,"
                + " apellidopaterno,fechanacimiento,estadocivil) values(?,?,?,?,?,?,?)";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, chofer.getChoferid());
            sentencia.setString(2, chofer.getDni());
            sentencia.setString(3, chofer.getNombre());
            sentencia.setString(4, chofer.getApellidomaterno());
            sentencia.setString(5, chofer.getApellidopaterno());
            sentencia.setDate(6, chofer.getFechanacimiento());
            sentencia.setString(7, chofer.getEstadocivil());
            return sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }

    @Override
    public int modificar(Chofer chofer) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "update chofer set dni = ?, nombre = ?, apellidomaterno = ?,"
                + " apellidopaterno = ?, fechanacimiento = ?, estadocivil = ? "
                + " where choferid = ?";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, chofer.getDni());
            sentencia.setString(2, chofer.getNombre());
            sentencia.setString(3, chofer.getApellidomaterno());
            sentencia.setString(4, chofer.getApellidopaterno());
            sentencia.setDate(5, chofer.getFechanacimiento());
            sentencia.setString(6, chofer.getEstadocivil());
            sentencia.setString(7, chofer.getChoferid());
            return sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }

    @Override
    public int eliminar(Chofer chofer) throws SQLException {
         conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "delete from chofer where choferid = ?";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, chofer.getChoferid());
            return sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }

    @Override
    public List<Chofer> buscar(String nombre) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        List<Chofer> choferes = new ArrayList<>();
        Chofer chofer;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select choferid,dni,nombre,apellidomaterno,"
                + " apellidopaterno,fechanacimiento,estadocivil from chofer "
                + " where nombre like '%" + nombre + "%'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                chofer = new Chofer();
                chofer.setChoferid(resultado.getString("choferid"));
                chofer.setDni(resultado.getString("dni"));
                chofer.setNombre(resultado.getString("nombre"));
                chofer.setApellidomaterno(resultado.getString("apellidomaterno"));
                chofer.setApellidopaterno(resultado.getString("apellidopaterno"));
                chofer.setFechanacimiento(resultado.getDate("fechanacimiento"));
                chofer.setEstadocivil(resultado.getString("estadocivil"));
                choferes.add(chofer);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return choferes;
    }

    @Override
    public Chofer buscarPorCodigo(String choferid) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        Chofer chofer = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select choferid,dni,nombre,apellidomaterno,"
                + " apellidopaterno,fechanacimiento,estadocivil from chofer "
                + " where choferid = '" + choferid + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                chofer = new Chofer();
                chofer.setChoferid(resultado.getString("choferid"));
                chofer.setDni(resultado.getString("dni"));
                chofer.setNombre(resultado.getString("nombre"));
                chofer.setApellidomaterno(resultado.getString("apellidomaterno"));
                chofer.setApellidopaterno(resultado.getString("apellidopaterno"));
                chofer.setFechanacimiento(resultado.getDate("fechanacimiento"));
                chofer.setEstadocivil(resultado.getString("estadocivil"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return chofer;
    }

    @Override
    public Chofer buscarPorDni(String dni) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        Chofer chofer = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select choferid,dni,nombre,apellidomaterno,"
                + " apellidopaterno,fechanacimiento,estadocivil from chofer "
                + " where dni = '" + dni + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                chofer = new Chofer();
                chofer.setChoferid(resultado.getString("choferid"));
                chofer.setDni(resultado.getString("dni"));
                chofer.setNombre(resultado.getString("nombre"));
                chofer.setApellidomaterno(resultado.getString("apellidomaterno"));
                chofer.setApellidopaterno(resultado.getString("apellidopaterno"));
                chofer.setFechanacimiento(resultado.getDate("fechanacimiento"));
                chofer.setEstadocivil(resultado.getString("estadocivil"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return chofer;
    }

   
    
    
    
}
