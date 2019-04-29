package Negocio;

import Datos.*;
import Entidad.*;

import java.util.List;

public class PasajeCN {
    
    private static PasajeCN instancia;
    public static PasajeCN getInstancia(){
        if(instancia == null)
            instancia = new PasajeCN();
        return instancia;
    }
    
    public int crearPasaje(Pasaje pasaje) throws Exception{
        int registros_afectados = PasajeDAO.getInstancia().ingresar(pasaje);
        return registros_afectados;
    }
    
    public List<Pasaje> buscarPasajes(String estado) throws Exception{
        List<Pasaje> pasajes = PasajeDAO.getInstancia().buscar(estado);
        return pasajes;
    }
}
