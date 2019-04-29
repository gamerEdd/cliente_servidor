package Contratos;


import Entidad.Chofer;
import java.sql.SQLException;
import java.util.List;

public interface IChoferDAO {
    
    public int ingresar(Chofer chofer) throws SQLException;
    
    public int modificar(Chofer chofer) throws SQLException;
    
    public int eliminar(Chofer chofer) throws SQLException;
    
    public List<Chofer> buscar(String nombre) throws SQLException;
    
    public Chofer buscarPorCodigo(String choferid) throws SQLException;
    
    public Chofer buscarPorDni(String dni) throws SQLException;
    
}
