package Contratos;


import Entidad.Bus;
import java.sql.SQLException;

public interface IBusDAO {
    
    public int ingresar(Bus bus) throws SQLException;
    
    public Bus buscar(String codigo) throws SQLException;
    
}
