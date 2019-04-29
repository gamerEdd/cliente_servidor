
package Entidad;

public class TerminalOrigen {
    private String terminalorigenid;
    private String nombre;
    private String direccion;
    private String email;
    private String telefono;
    private CiudadOrigen ciudadOrigen;

    public String getTerminalorigenid() {
        return terminalorigenid;
    }

    public void setTerminalorigenid(String terminalorigenid) {
        this.terminalorigenid = terminalorigenid;
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

    public CiudadOrigen getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(CiudadOrigen ciudad) {
        this.ciudadOrigen = ciudad;
    }
    
    
    
    
}
