package Contratos;


import Entidad.Pasaje;
import java.sql.SQLException;
import java.util.List;

public interface IPasajeDAO {
    
    public int ingresar(Pasaje pasaje) throws SQLException;
    
    public List<Pasaje> buscar(String estado) throws SQLException;
    
    public int modificarEstado(Pasaje pasaje) throws SQLException;
    
    public Pasaje buscarPorCodigo(String pasajeid) throws SQLException;
    
}
