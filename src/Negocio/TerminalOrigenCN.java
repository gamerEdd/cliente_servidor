package Negocio;

import Datos.*;
import Entidad.*;

import java.util.List;

public class TerminalOrigenCN {
    
    private static TerminalOrigenCN instancia;
    public static TerminalOrigenCN getInstancia(){
        if(instancia == null)
            instancia = new TerminalOrigenCN();
        return instancia;
    }
    
    public int crearTerminalOrigen(TerminalOrigen terminalOrigen) throws Exception{
        int registros_afectados = TerminalOrigenDAO.getInstancia().ingresar(terminalOrigen);
        return registros_afectados;
    }
    
    public List<CiudadOrigen> listaCiudadesOrigen() throws Exception{
        List<CiudadOrigen> ciudades = CiudadOrigenDAO.getInstancia().listado();
        return ciudades;
    }
    
    public CiudadOrigen buscarCiudad(String nombre) throws Exception{
        CiudadOrigen ciudadOrigen = CiudadOrigenDAO.getInstancia().buscarPorNombre(nombre);
        return ciudadOrigen;
    }
    
}
