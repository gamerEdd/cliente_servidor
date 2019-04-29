package Negocio;

import Datos.*;
import Entidad.*;




public class CategoriaCN {
    
    private static CategoriaCN instancia;
    public static CategoriaCN getInstancia(){
        if(instancia == null)
            instancia = new CategoriaCN();
        return instancia;
    }
    
    public int crearCategoria(Categoria categoria) throws Exception{
        int registros_afectados = CategoriaDAO.getInstancia().ingresar(categoria);
        return registros_afectados;
    }
    
}
