package Entidad;

import java.sql.Date;

public class Pasaje {
    private String pasajeid;
    private String horasalida;
    private Date fechasalida;
    private int asiento;
    private String estado;
    private Bus bus;
    
    public final static String ESTADO_LIBRE = "DISPONIBLE";
    public final static String ESTADO_NO_DISPONIBLE= "NO_DISPONIBLE";
    
    public String getPasajeid() {
        return pasajeid;
    }

    public void setPasajeid(String pasajeid) {
        this.pasajeid = pasajeid;
    }

    public String getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(String horasalida) {
        this.horasalida = horasalida;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
