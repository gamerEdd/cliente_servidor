package Negocio;

import Datos.*;
import Entidad.*;


public class CiudadDestinoCN {
    
    private static CiudadDestinoCN instancia;
    public static CiudadDestinoCN getInstancia(){
        if(instancia == null)
            instancia = new CiudadDestinoCN();
        return instancia;
    }
    
    public int crearCiudad(CiudadDestino ciudadDestino) throws Exception{
        int registros_afectados = CiudadDestinoDAO.getInstancia().ingresar(ciudadDestino);
        return registros_afectados;
    }
    
}
