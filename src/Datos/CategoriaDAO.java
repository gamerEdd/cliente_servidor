package Datos;


import Contratos.*;
import Entidad.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO implements ICategoriaDAO{
    
    Connection conexion;
    
    private static CategoriaDAO instancia;
    public static CategoriaDAO getInstancia(){
        if(instancia == null)
            instancia = new CategoriaDAO();
        return instancia;
    }

    @Override
    public int ingresar(Categoria categoria) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        PreparedStatement sentencia = null;
        String sentenciaSQL = "insert into categoria(categoriaid,nombre,descripcion) "
                + " values(?,?,?)";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, categoria.getCategoriaid());
            sentencia.setString(2, categoria.getNombre());
            sentencia.setString(3, categoria.getDescripcion());
            return sentencia.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
        }
    }

    @Override
    public List<Categoria> buscar() throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        List<Categoria> categorias=  new ArrayList<>();
        Categoria categoria = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select categoriaid,nombre,descripcion "
                + " from categoria";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                categoria = new Categoria();
                categoria.setCategoriaid(resultado.getString("categoriaid"));
                categoria.setNombre(resultado.getString("nombre"));
                categoria.setDescripcion(resultado.getString("descripcion"));
                categorias.add(categoria);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return categorias;
    }

    @Override
    public Categoria buscar(String nombre) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        Categoria categoria = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select categoriaid,nombre,descripcion "
                + " from categoria where nombre = '" + nombre + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                categoria = new Categoria();
                categoria.setCategoriaid(resultado.getString("categoriaid"));
                categoria.setNombre(resultado.getString("nombre"));
                categoria.setDescripcion(resultado.getString("descripcion"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return categoria;
    }
    
    @Override
    public Categoria buscarPorCodigo(String id) throws SQLException {
        conexion = Conexion.getInstancia().miConexion();
        Categoria categoria = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String sentenciaSQL = "select categoriaid,nombre,descripcion "
                + " from categoria where categoriaid = '" + id + "'";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();
            if(resultado.next()){
                categoria = new Categoria();
                categoria.setCategoriaid(resultado.getString("categoriaid"));
                categoria.setNombre(resultado.getString("nombre"));
                categoria.setDescripcion(resultado.getString("descripcion"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            conexion.close();
            sentencia.close();
            resultado.close();
        }
        return categoria;
    }

 
    
}
