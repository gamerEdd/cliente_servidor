
package Entidad;

public class TerminalDestino {
    private String terminaldestinoid;
    private String nombre;
    private String direccion;
    private String email;
    private String telefono;
    private CiudadDestino ciudadDestino;

    public String getTerminaldestinoid() {
        return terminaldestinoid;
    }

    public void setTerminaldestinoid(String terminaldestinoid) {
        this.terminaldestinoid = terminaldestinoid;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public CiudadDestino getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(CiudadDestino ciudad) {
        this.ciudadDestino = ciudad;
    }
    
}
