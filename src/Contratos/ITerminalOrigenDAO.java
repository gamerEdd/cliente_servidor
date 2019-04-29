package Contratos;


import Entidad.TerminalOrigen;
import java.sql.SQLException;
import java.util.List;

public interface ITerminalOrigenDAO {
    
    public int ingresar(TerminalOrigen terminal) throws SQLException;
    
    public List<TerminalOrigen> buscar() throws SQLException;
    
    public TerminalOrigen buscar(String nombre) throws SQLException;
    
    public TerminalOrigen buscarPorCodigo(String id) throws SQLException;
}
