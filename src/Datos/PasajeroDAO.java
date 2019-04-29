package Datos;


import Contratos.*;
import Entidad.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PasajeroDAO implements IPasajeroDAO{
    
    Connection conexion = null;
    private static PasajeroDAO instancia;
    public static PasajeroDAO getInstancia(){
        if(instancia == null)
            instancia = new PasajeroDAO();
        return instancia;
    }
    
    @Override
    public int ingresar(Pasajero pasajero) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "insert into Pasajero(dni,nombre,apellidoMaterno,"
                + " apellidoPaterno,fechaNacimiento,edad) values(?,?,?,?,?,?)";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, pasajero.getDni());
            sentencia.setString(2, pasajero.getNombre());
            sentencia.setString(3, pasajero.getApellidomaterno());
            sentencia.setString(4, pasajero.getApellidopaterno());
            sentencia.setDate(5, pasajero.getFechaNacimiento());
            sentencia.setInt(6, pasajero.getEdad());
            return sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }

    @Override
    public int modificar(Pasajero pasajero) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "update Pasajero set dni = ?, nombre = ?, apellidoMaterno = ?,"
                + " apellidoPaterno = ?, fechaNacimiento = ?, edad = ? "
                + " where dni = ?";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, pasajero.getDni());
            sentencia.setString(2, pasajero.getNombre());
            sentencia.setString(3, pasajero.getApellidomaterno());
            sentencia.setString(4, pasajero.getApellidopaterno());
            sentencia.setDate(5, pasajero.getFechaNacimiento());
            sentencia.setInt(6, pasajero.getEdad());
            sentencia.setString(7, pasajero.getDni());
            return sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }

    @Override
    public int eliminar(Pasajero pasajero) throws SQLException {
         conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "delete from Chofer where choferid = ?";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, pasajero.getDni());
            return sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }

    @Override
    public List<Pasajero> buscar(String nombre) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        List<Pasajero> pasajeros = new ArrayList<>();
        Pasajero pasajero;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select dni,nombre,apellidomaterno,"
                + " apellidopaterno,fechanacimiento,edad from pasajero "
                + " where dni like '%" + nombre + "%'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                pasajero = new Pasajero();
                pasajero.setDni(resultado.getString("dni"));
                pasajero.setNombre(resultado.getString("nombre"));
                pasajero.setApellidomaterno(resultado.getString("apellidomaterno"));
                pasajero.setApellidopaterno(resultado.getString("apellidopaterno"));
                pasajero.setFechaNacimiento(resultado.getDate("fechanacimiento"));
                pasajero.setEdad(resultado.getInt("edad"));
                pasajeros.add(pasajero);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return pasajeros;
    }

    @Override
    public Pasajero buscarPorCodigo(String pasajeroid) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        Pasajero pasajero = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select dni,nombre,apellidomaterno,"
                + " apellidopaterno,fechanacimiento,edad from pasajero "
                + " where pasajeroid = '" + pasajeroid + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                pasajero = new Pasajero();
                pasajero.setDni(resultado.getString("dni"));
                pasajero.setNombre(resultado.getString("nombre"));
                pasajero.setApellidomaterno(resultado.getString("apellidomaterno"));
                pasajero.setApellidopaterno(resultado.getString("apellidopaterno"));
                pasajero.setFechaNacimiento(resultado.getDate("fechanacimiento"));
                pasajero.setEdad(resultado.getInt("edad"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return pasajero;
    }

    @Override
    public Pasajero buscarPorDni(String dni) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        Pasajero pasajero = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select dni,nombre,apellidomaterno,"
                + " apellidopaterno,fechanacimiento,edad from pasajero "
                + " where dni = '" + dni + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                pasajero = new Pasajero();
                pasajero.setDni(resultado.getString("dni"));
                pasajero.setNombre(resultado.getString("nombre"));
                pasajero.setApellidomaterno(resultado.getString("apellidomaterno"));
                pasajero.setApellidopaterno(resultado.getString("apellidopaterno"));
                pasajero.setFechaNacimiento(resultado.getDate("fechanacimiento"));
                pasajero.setEdad(resultado.getInt("edad"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return pasajero;
    }
    

   
    
}
