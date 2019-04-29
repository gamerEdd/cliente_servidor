package Entidad;

public class Bus {
    private String busid;
    private int capacidad;
    private String matricula;
    private String estado;
    private Categoria categoria;
    private Chofer chofer;
    private TerminalOrigen terminalOrigen;
    private TerminalDestino terminalDestino;
    
    public static String ESTADO_EN_RUTA = "EN RUTA";
    public static String ESTADO_DISPONIBLE = "DISPONIBLE";
    public static String ESTADO_LLENANDO = "LLENANDO";

    public String getBusid() {
        return busid;
    }

    public void setBusid(String busid) {
        this.busid = busid;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

//    public int getAsiento() {
//        return asiento;
//    }
//
//    public void setAsiento(int asiento) {
//        this.asiento = asiento;
//    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public TerminalOrigen getTerminalOrigen() {
        return terminalOrigen;
    }

    public void setTerminalOrigen(TerminalOrigen terminalOrigen) {
        this.terminalOrigen = terminalOrigen;
    }

    public TerminalDestino getTerminalDestino() {
        return terminalDestino;
    }

    public void setTerminalDestino(TerminalDestino terminalDestino) {
        this.terminalDestino = terminalDestino;
    }
   
}
