package Entidad;

public class CiudadDestino {
    private String ciudaddestinoid;
    private String nombre;
    private String codigoPostal;
    private String provincia;

    public String getCiudadDestinoid() {
        return ciudaddestinoid;
    }

    public void setCiudadDestinoid(String ciudadid) {
        this.ciudaddestinoid = ciudadid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
        
}
