package Negocio;

import Datos.*;
import Entidad.*;

import java.util.List;

public class ChoferCN {
    
    private static ChoferCN instancia;
    public static ChoferCN getInstancia(){
        if(instancia == null)
            instancia = new ChoferCN();
        return instancia;
    }
    
    public int crearChofer(Chofer chofer) throws Exception{
        int registros_afectados = ChoferDAO.getInstancia().ingresar(chofer);
        return registros_afectados;
    }
    
    public int modificarChofer(Chofer chofer) throws Exception{
        int registros_afectados = ChoferDAO.getInstancia().modificar(chofer);
        return registros_afectados;
    }
    
    public int eliminarChofer(Chofer chofer) throws Exception{
        int registros_afectados = ChoferDAO.getInstancia().eliminar(chofer);
        return registros_afectados;
    }
 
    public List<Chofer> buscarChoferes(String nombre) throws Exception{
        List<Chofer> choferes = ChoferDAO.getInstancia().buscar(nombre);
        return choferes;
    }
    
    public Chofer buscarChofer(String codigo) throws Exception{
        Chofer chofer = ChoferDAO.getInstancia().buscarPorCodigo(codigo);
        return chofer;
    }
}
