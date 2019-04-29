package Datos;


import Contratos.*;
import Entidad.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaPasajeDAO implements IVentaPasajeDAO{
    
    Connection conexion;
    private static VentaPasajeDAO instancia;
    public static VentaPasajeDAO getInstancia(){
        if(instancia == null)
            instancia = new VentaPasajeDAO();
        return instancia;
    }

    @Override
    public int ingresar(VentaPasaje ventaPasaje) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        int registros_afectados;
        PreparedStatement sentencia = null;
        String sentenciaSQL = "insert into ventapasaje(ventapasajeid,fecha,asiento,precio,dni,"
                + " pasajeid) values(?,?,?,?,?,?)";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, ventaPasaje.getVentapasajeid());
            sentencia.setDate(2, ventaPasaje.getFecha());
            sentencia.setInt(3, ventaPasaje.getAsiento());
            sentencia.setDouble(4, ventaPasaje.getPrecio());
            sentencia.setString(5, ventaPasaje.getPasajero().getDni());
            sentencia.setString(6, ventaPasaje.getPasaje().getPasajeid());
            registros_afectados = sentencia.executeUpdate();
            if(registros_afectados == 1)
                PasajeDAO.getInstancia().modificarEstado(ventaPasaje.getPasaje());
            return registros_afectados;
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }    

    @Override
    public List<VentaPasaje> listado() throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        List<VentaPasaje> ventas = new ArrayList<>();
        VentaPasaje venta = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select ventapasajeid,fecha,asiento,precio,"
                + " pasajeid from ventapasaje ";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                venta = new VentaPasaje();
                venta.setVentapasajeid(resultado.getString("ventapasajeid"));
                venta.setFecha(resultado.getDate("fecha"));
                venta.setAsiento(resultado.getInt("asiento"));
                venta.setPrecio(resultado.getDouble("precio"));
//                String idpasajero = resultado.getString("pasajeroid");
//                Pasajero pasajero = PasajeroDAO.getInstancia().buscarPorCodigo(idpasajero);
//                venta.setPasajero(pasajero);
                String idpasaje = resultado.getString("pasajeid");
                Pasaje pasaje = PasajeDAO.getInstancia().buscarPorCodigo(idpasaje);
                venta.setPasaje(pasaje);
                ventas.add(venta);
            }
        } catch (Exception e) {
            throw e;
        }
        return ventas;
    }

    
    
}
