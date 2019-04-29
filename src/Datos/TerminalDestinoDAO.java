package Datos;


import Contratos.*;
import Entidad.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TerminalDestinoDAO implements ITerminalDestinoDAO{
    
    Connection conexion;
    
    private static TerminalDestinoDAO instancia;
    public static TerminalDestinoDAO getInstancia(){
        if(instancia == null)
            instancia = new TerminalDestinoDAO();
        return instancia;
    }

    @Override
    public int ingresar(TerminalDestino destino) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "insert into terminaldestino(terminaldestinoid,nombre,direccion,email,"
                + " telefono,ciudaddestinoid) "
                + " values(?,?,?,?,?,?)";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, destino.getTerminaldestinoid());
            sentencia.setString(2, destino.getNombre());
            sentencia.setString(3, destino.getDireccion());
            sentencia.setString(4, destino.getEmail());
            sentencia.setString(5, destino.getTelefono());
            sentencia.setString(6, destino.getCiudadDestino().getCiudadDestinoid());
            return sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }
    
    @Override
    public List<TerminalDestino> buscar() throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        List<TerminalDestino> destinos = new ArrayList<>();
        TerminalDestino terminalDestino = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select terminaldestinoid,nombre,direccion,email,"
                + " telefono,ciudaddestinoid from terminaldestino ";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                terminalDestino = new TerminalDestino();
                terminalDestino.setTerminaldestinoid(resultado.getString("terminaldestinoid"));
                terminalDestino.setNombre(resultado.getString("nombre"));
                terminalDestino.setDireccion(resultado.getString("direccion"));
                terminalDestino.setEmail(resultado.getString("email"));
                terminalDestino.setTelefono(resultado.getString("telefono"));
                String ciudadid = resultado.getString("ciudaddestinoid");
                CiudadDestino ciudadDestino = CiudadDestinoDAO.getInstancia().buscar(ciudadid);
                terminalDestino.setCiudadDestino(ciudadDestino);
                destinos.add(terminalDestino);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return destinos;
    }

    @Override
    public TerminalDestino buscar(String nombre) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        TerminalDestino terminalDestino = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select t.terminaldestinoid,t.nombre,t.direccion,t.email,"
                + " t.telefono,c.ciudaddestinoid,c.nombre,c.codigopostal,c.provincia "
                + " from terminaldestino as t "
                + " inner join ciudaddestino as c on t.ciudaddestinoid = c.ciudaddestinoid "
                + " where c.nombre = '" + nombre + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                terminalDestino = new TerminalDestino();
                terminalDestino.setTerminaldestinoid(resultado.getString("terminaldestinoid"));
                terminalDestino.setNombre(resultado.getString("nombre"));
                terminalDestino.setDireccion(resultado.getString("direccion"));
                terminalDestino.setEmail(resultado.getString("email"));
                terminalDestino.setTelefono(resultado.getString("telefono"));
                String ciudadid = resultado.getString("ciudaddestinoid");
                CiudadDestino ciudadDestino = CiudadDestinoDAO.getInstancia().buscar(ciudadid);
                terminalDestino.setCiudadDestino(ciudadDestino);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return terminalDestino;
    }
    
    @Override
    public TerminalDestino buscarPorCodigo(String id) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        TerminalDestino terminalDestino = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select t.terminaldestinoid,t.nombre,t.direccion,t.email,"
                + " t.telefono,c.ciudaddestinoid,c.nombre,c.codigopostal,c.provincia "
                + " from terminaldestino as t "
                + " inner join ciudaddestino as c on t.ciudaddestinoid = c.ciudaddestinoid "
                + " where t.terminaldestinoid = '" + id + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                terminalDestino = new TerminalDestino();
                terminalDestino.setTerminaldestinoid(resultado.getString("terminaldestinoid"));
                terminalDestino.setNombre(resultado.getString("nombre"));
                terminalDestino.setDireccion(resultado.getString("direccion"));
                terminalDestino.setEmail(resultado.getString("email"));
                terminalDestino.setTelefono(resultado.getString("telefono"));
                String ciudadid = resultado.getString("ciudaddestinoid");
                CiudadDestino ciudadDestino = CiudadDestinoDAO.getInstancia().buscar(ciudadid);
                terminalDestino.setCiudadDestino(ciudadDestino);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return terminalDestino;
    }

    
}
