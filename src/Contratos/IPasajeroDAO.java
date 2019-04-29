package Contratos;


import Entidad.Pasajero;
import java.sql.SQLException;
import java.util.List;

public interface IPasajeroDAO {
    
    public int ingresar(Pasajero pasajero) throws SQLException;
    
    public int modificar(Pasajero pasajero) throws SQLException;
    
    public int eliminar(Pasajero pasajero) throws SQLException;
    
    public List<Pasajero> buscar(String nombre) throws SQLException;    

    public Pasajero buscarPorCodigo(String choferid) throws SQLException;
    
    public Pasajero buscarPorDni(String dni) throws SQLException;
    
}
