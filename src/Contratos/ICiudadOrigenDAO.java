package Contratos;


import Entidad.CiudadOrigen;
import java.sql.SQLException;
import java.util.List;

public interface ICiudadOrigenDAO {
    
    public int ingresar(CiudadOrigen ciudad) throws SQLException;
    
    public List<CiudadOrigen> listado() throws SQLException;
    
    public CiudadOrigen buscar(String ciudadid) throws SQLException;
    
    public CiudadOrigen buscarPorNombre(String nombre) throws SQLException;
    
}
