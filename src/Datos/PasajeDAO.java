package Datos;


import Contratos.*;
import Entidad.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PasajeDAO implements IPasajeDAO{
    
    Connection conexion;
    
    private static PasajeDAO instancia;
    public static PasajeDAO getInstancia(){
        if(instancia == null)
            instancia = new PasajeDAO();
        return instancia;
    }

    @Override
    public int ingresar(Pasaje pasaje) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "insert into pasaje(pasajeid,horasalida,fechasalida,estado,busid) "
                + " values(?,?,?,?,?)";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, pasaje.getPasajeid());
            sentencia.setString(2, pasaje.getHorasalida());
            sentencia.setDate(3, pasaje.getFechasalida());
            sentencia.setString(4, pasaje.getEstado());
            sentencia.setString(5, pasaje.getBus().getBusid());
            return sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }   
    
    @Override
    public List<Pasaje> buscar(String estado) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        List<Pasaje> pasajeros = new ArrayList<>();
        Pasaje pasaje;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select * "
                + " from pasaje as p "
                + " inner join bus as b on p.busid = b.busid "
                + " where p.estado = '" + estado + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                pasaje = new Pasaje();
                pasaje.setPasajeid(resultado.getString("pasajeid"));
                pasaje.setHorasalida(resultado.getString("horasalida"));
                pasaje.setFechasalida(resultado.getDate("fechasalida"));
                pasaje.setEstado(resultado.getString("estado"));
                String busid = resultado.getString("busid");
                Bus bus = BusDAO.getInstancia().buscar(busid);
                pasaje.setBus(bus);
                pasajeros.add(pasaje);
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
    public int modificarEstado(Pasaje pasaje) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "update pasaje set estado = ? "
                + "where pasajeid = ? ";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(2, pasaje.getPasajeid());
            sentencia.setString(1, pasaje.getEstado());
            return sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }   
    
    @Override
    public Pasaje buscarPorCodigo(String pasajeid) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        Pasaje pasaje = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select * "
                + " from pasaje as p "
                + " inner join bus as b on p.busid = b.busid "
                + " where p.pasajeid = '" + pasajeid + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                pasaje = new Pasaje();
                pasaje.setPasajeid(resultado.getString("pasajeid"));
                pasaje.setHorasalida(resultado.getString("horasalida"));
                pasaje.setFechasalida(resultado.getDate("fechasalida"));
                pasaje.setEstado(resultado.getString("estado"));
                String busid = resultado.getString("busid");
                Bus bus = BusDAO.getInstancia().buscar(busid);
                pasaje.setBus(bus);

            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return pasaje;
    }

   
}
