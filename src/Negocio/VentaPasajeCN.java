package Negocio;

import Datos.*;
import Entidad.*;

import java.util.List;

public class VentaPasajeCN {
    
    private static VentaPasajeCN instancia;
    public static VentaPasajeCN getInstancia(){
        if(instancia == null)
            instancia = new VentaPasajeCN();
        return instancia;
    }
    
    public int crearVentaPasaje(VentaPasaje ventaPasaje) throws Exception{
        Pasaje pasaje = ventaPasaje.getPasaje();
        pasaje.setEstado(Pasaje.ESTADO_NO_DISPONIBLE);
        int registros_afectados = VentaPasajeDAO.getInstancia().ingresar(ventaPasaje);
        return registros_afectados;
    }
    
    public Pasajero buscarPasajero(String dni) throws Exception{
        Pasajero  pasajero = PasajeroDAO.getInstancia().buscarPorDni(dni);
        return pasajero;
    }
    
    public List<VentaPasaje> listadoVentas() throws Exception{
        List<VentaPasaje> ventas = VentaPasajeDAO.getInstancia().listado();
        return ventas;
    }
}
