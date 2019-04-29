package Contratos;


import Entidad.TerminalDestino;
import java.sql.SQLException;
import java.util.List;

public interface ITerminalDestinoDAO {
    
    public int ingresar(TerminalDestino destino) throws SQLException;
    
    public List<TerminalDestino> buscar() throws SQLException;
    
    public TerminalDestino buscar(String nombre) throws SQLException;
    
    public TerminalDestino buscarPorCodigo(String id) throws SQLException;
}
