package Entidad;

public class DetallePasaje {
    private Pasaje pasaje;
    private VentaPasaje ventaPasaje;
    private int cantidad;

    public VentaPasaje getVentaPasaje() {
        return ventaPasaje;
    }

    public void setVentaPasaje(VentaPasaje ventaPasaje) {
        this.ventaPasaje = ventaPasaje;
    }

    public Pasaje getPasaje() {
        return pasaje;
    }

    public void setPasaje(Pasaje pasaje) {
        this.pasaje = pasaje;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
