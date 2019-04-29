package Contratos;


import Entidad.Categoria;
import java.sql.SQLException;
import java.util.List;

public interface ICategoriaDAO {
    
    public int ingresar(Categoria categoria) throws SQLException;
    
    public List<Categoria> buscar() throws SQLException;
    
    public Categoria buscar(String nombre) throws SQLException;
    
    public Categoria buscarPorCodigo(String id) throws SQLException;
}
