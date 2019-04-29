package Negocio;

import Datos.*;
import Entidad.*;

import java.util.List;

public class TerminalDestinoCN {
    
    private static TerminalDestinoCN instancia;
    public static TerminalDestinoCN getInstancia(){
        if(instancia == null)
            instancia = new TerminalDestinoCN();
        return instancia;
    }
    
    public int crearTerminalDestino(TerminalDestino terminalDestino) throws Exception{
        int registros_afectados = TerminalDestinoDAO.getInstancia().ingresar(terminalDestino);
        return registros_afectados;
    }
    
    public List<CiudadDestino> listaCiudadesDestino() throws Exception{
        List<CiudadDestino> ciudades = CiudadDestinoDAO.getInstancia().listado();
        return ciudades;
    }
    
    public CiudadDestino buscarCiudad(String nombre) throws Exception{
        CiudadDestino ciudadDestino = CiudadDestinoDAO.getInstancia().buscarPorNombre(nombre);
        return ciudadDestino;
    }
    
}
