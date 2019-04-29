package Contratos;

import Entidad.VentaPasaje;
import java.sql.SQLException;
import java.util.List;

public interface IVentaPasajeDAO {
    
    public int ingresar(VentaPasaje ventaPasaje) throws SQLException;
        
    public List<VentaPasaje> listado() throws SQLException;
}
