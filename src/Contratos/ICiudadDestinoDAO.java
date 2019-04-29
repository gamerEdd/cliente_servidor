package Contratos;


import Entidad.CiudadDestino;
import java.sql.SQLException;
import java.util.List;

public interface ICiudadDestinoDAO {
    
    public int ingresar(CiudadDestino ciudad) throws SQLException;
    
    public List<CiudadDestino> listado() throws SQLException;
    
    public CiudadDestino buscar(String ciudadid) throws SQLException;
    
    public CiudadDestino buscarPorNombre(String nombre) throws SQLException;
    
}
