package Negocio;

import Datos.*;
import Entidad.*;

import java.util.List;

public class PasajeroCN {
    
    private static PasajeroCN instancia;
    public static PasajeroCN getInstancia(){
        if(instancia == null)
            instancia = new PasajeroCN();
        return instancia;
    }
    
    public int crearPasajero(Pasajero pasajero) throws Exception{
        int registros_afectados = PasajeroDAO.getInstancia().ingresar(pasajero);
        return registros_afectados;
    }
    
    public int modificarPasajero(Pasajero pasajero) throws Exception{
        int registros_afectados = PasajeroDAO.getInstancia().modificar(pasajero);
        return registros_afectados;
    }
    
    public int eliminarPasajero(Pasajero pasajero) throws Exception{
        int registros_afectados = PasajeroDAO.getInstancia().eliminar(pasajero);
        return registros_afectados;
    }
 
    public List<Pasajero> buscarPasajeros(String nombre) throws Exception{
        List<Pasajero> pasajeros = PasajeroDAO.getInstancia().buscar(nombre);
        return pasajeros;
    }
    
    public Pasajero buscarPasajero(String codigo) throws Exception{
        Pasajero pasajero = PasajeroDAO.getInstancia().buscarPorCodigo(codigo);
        return pasajero;
    }
    
}
