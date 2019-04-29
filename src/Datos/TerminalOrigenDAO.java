package Datos;


import Contratos.*;
import Entidad.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TerminalOrigenDAO implements ITerminalOrigenDAO{
    
    Connection conexion;
    
    private static TerminalOrigenDAO instancia;
    public static TerminalOrigenDAO getInstancia(){
        if(instancia == null)
            instancia = new TerminalOrigenDAO();
        return instancia;
    }

    @Override
    public int ingresar(TerminalOrigen terminalOrigen) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "insert into terminalorigen(terminalorigenid,nombre,direccion,email,"
                + " telefono,ciudadorigenid) values(?,?,?,?,?,?)";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, terminalOrigen.getTerminalorigenid());
            sentencia.setString(2, terminalOrigen.getNombre());
            sentencia.setString(3, terminalOrigen.getDireccion());
            sentencia.setString(4, terminalOrigen.getEmail());
            sentencia.setString(5, terminalOrigen.getTelefono());
            sentencia.setString(6, terminalOrigen.getCiudadOrigen().getCiudadid());
            return sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }
    
    @Override
    public List<TerminalOrigen> buscar() throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        List<TerminalOrigen> origenes = new ArrayList<>();
        TerminalOrigen terminal = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select terminalorigenid,nombre,direccion,email,"
                + " telefono,ciudadorigenid from terminalorigen ";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                terminal = new TerminalOrigen();
                terminal.setTerminalorigenid(resultado.getString("terminalorigenid"));
                terminal.setNombre(resultado.getString("nombre"));
                terminal.setDireccion(resultado.getString("direccion"));
                terminal.setEmail(resultado.getString("email"));
                terminal.setTelefono(resultado.getString("telefono"));
                String ciudadid = resultado.getString("ciudadorigenid");
                CiudadOrigen ciudadOrigen = CiudadOrigenDAO.getInstancia().buscar(ciudadid);
                terminal.setCiudadOrigen(ciudadOrigen);
                origenes.add(terminal);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return origenes;
    }
    
    @Override
    public TerminalOrigen buscar(String nombreCiudad) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        TerminalOrigen terminalOrigen = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select t.terminalorigenid,t.nombre,t.direccion,t.email,"
                + " t.telefono,c.ciudadorigenid,c.nombre,c.codigopostal,c.provincia "
                + " from terminalorigen as t "
                + " inner join ciudadorigen as c on t.ciudadorigenid = c.ciudadorigenid "
                + " where c.nombre = '" + nombreCiudad + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                terminalOrigen = new TerminalOrigen();
                terminalOrigen.setTerminalorigenid(resultado.getString("terminalorigenid"));
                terminalOrigen.setNombre(resultado.getString("nombre"));
                terminalOrigen.setDireccion(resultado.getString("direccion"));
                terminalOrigen.setEmail(resultado.getString("email"));
                terminalOrigen.setTelefono(resultado.getString("telefono"));
                String ciudadid = resultado.getString("ciudadorigenid");
                CiudadOrigen ciudadOrigen = CiudadOrigenDAO.getInstancia().buscar(ciudadid);
                terminalOrigen.setCiudadOrigen(ciudadOrigen);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return terminalOrigen;
    }
    
    @Override
    public TerminalOrigen buscarPorCodigo(String id) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        TerminalOrigen terminalOrigen = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select t.terminalorigenid,t.nombre,t.direccion,t.email,"
                + " t.telefono,c.ciudadorigenid,c.nombre,c.codigopostal,c.provincia "
                + " from terminalorigen as t "
                + " inner join ciudadorigen as c on t.ciudadorigenid = c.ciudadorigenid "
                + " where t.terminalorigenid = '" + id + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                terminalOrigen = new TerminalOrigen();
                terminalOrigen.setTerminalorigenid(resultado.getString("terminalorigenid"));
                terminalOrigen.setNombre(resultado.getString("nombre"));
                terminalOrigen.setDireccion(resultado.getString("direccion"));
                terminalOrigen.setEmail(resultado.getString("email"));
                terminalOrigen.setTelefono(resultado.getString("telefono"));
                String ciudadid = resultado.getString("ciudadorigenid");
                CiudadOrigen ciudadOrigen = CiudadOrigenDAO.getInstancia().buscar(ciudadid);
                terminalOrigen.setCiudadOrigen(ciudadOrigen);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return terminalOrigen;
    }

  
}
