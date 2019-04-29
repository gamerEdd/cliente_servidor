package Datos;


import Contratos.*;
import Entidad.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusDAO implements IBusDAO{
    
    Connection conexion;
    
    private static BusDAO instancia;
    public static BusDAO getInstancia(){
        if(instancia == null)
            instancia = new BusDAO();
        return instancia;
    }

    @Override
    public int ingresar(Bus bus) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "insert into bus(busid,capacidad,matricula,estado,"
                + " choferid,categoriaid,terminaldestinoid,terminalorigenid) "
                + " values(?,?,?,?,?,?,?,?)";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, bus.getBusid());
            sentencia.setInt(2, bus.getCapacidad());
            sentencia.setString(3, bus.getMatricula());
            sentencia.setString(4, bus.getEstado());
            sentencia.setString(5, bus.getChofer().getChoferid());
            sentencia.setString(6, bus.getCategoria().getCategoriaid());
            sentencia.setString(7, bus.getTerminalDestino().getTerminaldestinoid());
            sentencia.setString(8, bus.getTerminalOrigen().getTerminalorigenid());
            return sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }    
    
    @Override
    public Bus buscar(String codigo) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        Bus bus = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select * "
                + " from bus as b "
                + " inner join categoria as cat on b.categoriaid = cat.categoriaid "
                + " inner join terminaldestino as td on b.terminaldestinoid = td.terminaldestinoid "
                + " inner join terminalorigen as origen on b.terminalorigenid = origen.terminalorigenid "
                + " where b.busid = '" + codigo + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                bus = new Bus();
                bus.setBusid(resultado.getString("busid"));
                bus.setCapacidad(resultado.getInt("capacidad"));
                bus.setMatricula(resultado.getString("matricula"));
                bus.setEstado(resultado.getString("estado"));
                String categoriaid = resultado.getString("categoriaid");
                Categoria categoria = CategoriaDAO.getInstancia().buscarPorCodigo(categoriaid);
                bus.setCategoria(categoria);
                String terminadestinoid = resultado.getString("terminaldestinoid");
                TerminalDestino terminalDestino = TerminalDestinoDAO.getInstancia().buscarPorCodigo(terminadestinoid);
                bus.setTerminalDestino(terminalDestino);
                String terminaorigenid = resultado.getString("terminalorigenid");
                TerminalOrigen terminalOrigen = TerminalOrigenDAO.getInstancia().buscarPorCodigo(terminaorigenid);
                bus.setTerminalOrigen(terminalOrigen);

            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return bus;
    }

   
}
