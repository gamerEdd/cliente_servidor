package Datos;


import Contratos.*;
import Entidad.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CiudadOrigenDAO implements ICiudadOrigenDAO{
    
    Connection conexion;
    
    private static CiudadOrigenDAO instancia;
    public static CiudadOrigenDAO getInstancia(){
        if(instancia == null)
            instancia = new CiudadOrigenDAO();
        return instancia;
    }

    @Override
    public int ingresar(CiudadOrigen ciudadOrigen) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "insert into ciudadorigen(ciudadorigenid,nombre,codigopostal,provincia) "
                + " values(?,?,?,?)";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, ciudadOrigen.getCiudadid());
            sentencia.setString(2, ciudadOrigen.getNombre());
            sentencia.setString(3, ciudadOrigen.getCodigoPostal());
            sentencia.setString(4, ciudadOrigen.getProvincia());
            return sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }
    
    @Override
    public List<CiudadOrigen> listado() throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        List<CiudadOrigen> ciudades = new ArrayList<>();
        CiudadOrigen ciudadOrigen = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select ciudadorigenid,nombre,codigopostal,provincia "
                + " from ciudadorigen ";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                ciudadOrigen = new CiudadOrigen();
                ciudadOrigen.setCiudadid(resultado.getString("ciudadorigenid"));
                ciudadOrigen.setNombre(resultado.getString("nombre"));
                ciudadOrigen.setCodigoPostal(resultado.getString("codigopostal"));
                ciudadOrigen.setProvincia(resultado.getString("provincia"));
                ciudades.add(ciudadOrigen);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return ciudades;
    }
    
    @Override
    public CiudadOrigen buscar(String ciudadid) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        CiudadOrigen ciudad = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select ciudadorigenid,nombre,codigopostal,provincia "
                + " from ciudadorigen where ciudadorigenid = '" + ciudadid + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                ciudad = new CiudadOrigen();
                ciudad.setCiudadid(resultado.getString("ciudadorigenid"));
                ciudad.setNombre(resultado.getString("nombre"));
                ciudad.setCodigoPostal(resultado.getString("codigopostal"));
                ciudad.setProvincia(resultado.getString("provincia"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return ciudad;
    }
    
    @Override
    public CiudadOrigen buscarPorNombre(String nombre) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        CiudadOrigen ciudadOrigen = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select ciudadorigenid,nombre,codigopostal,provincia "
                + " from ciudadorigen where nombre = '" + nombre + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                ciudadOrigen = new CiudadOrigen();
                ciudadOrigen.setCiudadid(resultado.getString("ciudadorigenid"));
                ciudadOrigen.setNombre(resultado.getString("nombre"));
                ciudadOrigen.setCodigoPostal(resultado.getString("codigopostal"));
                ciudadOrigen.setProvincia(resultado.getString("provincia"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return ciudadOrigen;
    }

 
    
}
