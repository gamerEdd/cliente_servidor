package Entidad;

import java.sql.Date;

public class VentaPasaje {
    private String ventapasajeid;
    private Date fecha;
    private int asiento;
    private double precio;
    private Pasajero pasajero;
    private Pasaje pasaje;

    public VentaPasaje() {
    }
    
    public String getVentapasajeid() {
        return ventapasajeid;
    }

    public void setVentapasajeid(String ventapasajeid) {
        this.ventapasajeid = ventapasajeid;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Pasaje getPasaje() {
        return pasaje;
    }

    public void setPasaje(Pasaje pasaje) {
        this.pasaje = pasaje;
    }
    
}
