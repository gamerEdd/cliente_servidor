package Datos;


import Contratos.*;
import Entidad.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CiudadDestinoDAO implements ICiudadDestinoDAO{
    
    Connection conexion;
    
    private static CiudadDestinoDAO instancia;
    public static CiudadDestinoDAO getInstancia(){
        if(instancia == null)
            instancia = new CiudadDestinoDAO();
        return instancia;
    }

    @Override
    public int ingresar(CiudadDestino ciuadad) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "insert into ciudaddestino(ciudaddestinoid,nombre,codigopostal,provincia) "
                + " values(?,?,?,?)";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, ciuadad.getCiudadDestinoid());
            sentencia.setString(2, ciuadad.getNombre());
            sentencia.setString(3, ciuadad.getCodigoPostal());
            sentencia.setString(4, ciuadad.getProvincia());
            return sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }
    
    @Override
    public List<CiudadDestino> listado() throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        List<CiudadDestino> ciudades = new ArrayList<>();
        CiudadDestino ciudadDestino = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select ciudaddestinoid,nombre,codigopostal,provincia "
                + " from ciudaddestino ";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                ciudadDestino = new CiudadDestino();
                ciudadDestino.setCiudadDestinoid(resultado.getString("ciudaddestinoid"));
                ciudadDestino.setNombre(resultado.getString("nombre"));
                ciudadDestino.setCodigoPostal(resultado.getString("codigopostal"));
                ciudadDestino.setProvincia(resultado.getString("provincia"));
                ciudades.add(ciudadDestino);
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
    public CiudadDestino buscar(String ciudadid) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        CiudadDestino ciudadDestino = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select ciudaddestinoid,nombre,codigopostal,provincia "
                + " from ciudaddestino where ciudaddestinoid = '" + ciudadid + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                ciudadDestino = new CiudadDestino();
                ciudadDestino.setCiudadDestinoid(resultado.getString("ciudaddestinoid"));
                ciudadDestino.setNombre(resultado.getString("nombre"));
                ciudadDestino.setCodigoPostal(resultado.getString("codigopostal"));
                ciudadDestino.setProvincia(resultado.getString("provincia"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return ciudadDestino;
    }
    
    @Override
    public CiudadDestino buscarPorNombre(String nombre) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        CiudadDestino ciudadDestino = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select ciudaddestinoid,nombre,codigopostal,provincia "
                + " from ciudaddestino where nombre = '" + nombre + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                ciudadDestino = new CiudadDestino();
                ciudadDestino.setCiudadDestinoid(resultado.getString("ciudaddestinoid"));
                ciudadDestino.setNombre(resultado.getString("nombre"));
                ciudadDestino.setCodigoPostal(resultado.getString("codigopostal"));
                ciudadDestino.setProvincia(resultado.getString("provincia"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return ciudadDestino;
    }

    
    
}
