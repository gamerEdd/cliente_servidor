package Negocio;


import Datos.BusDAO;
import Datos.CategoriaDAO;
import Datos.ChoferDAO;
import Datos.TerminalDestinoDAO;
import Datos.TerminalOrigenDAO;
import Entidad.Bus;
import Entidad.Categoria;
import Entidad.Chofer;
import Entidad.TerminalDestino;
import Entidad.TerminalOrigen;
import java.util.List;

public class BusCN {
    
    private static BusCN instancia;
    public static BusCN getInstancia(){
        if(instancia == null)
            instancia = new BusCN();
        return instancia;
    }
    
    public int crearBus(Bus bus) throws Exception{
        int registros_afectados = BusDAO.getInstancia().ingresar(bus);
        return registros_afectados;
    }
    
    public Chofer buscarChofer(String dni) throws Exception{
        Chofer chofer = ChoferDAO.getInstancia().buscarPorDni(dni);
        return chofer;
    }
    
    public List<TerminalOrigen> terminalOrigenes() throws Exception{
        List<TerminalOrigen> terminalOrigenes = TerminalOrigenDAO.getInstancia().buscar();
        return terminalOrigenes;
    }
    
    public List<TerminalDestino> terminalDestinos() throws Exception{
        List<TerminalDestino> terminalDestinos = TerminalDestinoDAO.getInstancia().buscar();
        return terminalDestinos;
    }
    
    public List<Categoria> categorias() throws Exception{
        List<Categoria> categorias = CategoriaDAO.getInstancia().buscar();
        return categorias;
    }
    
    public Categoria buscarCategoria(String nombre) throws Exception{
        Categoria categoria = CategoriaDAO.getInstancia().buscar(nombre);
        return categoria;
    }
    
    public TerminalOrigen buscarTerminalOrigen(String nombre) throws Exception{
        TerminalOrigen terminalOrigen = TerminalOrigenDAO.getInstancia().buscar(nombre);
        return terminalOrigen;
    }
    
    public TerminalDestino buscarTerminalDestino(String nombre) throws Exception{
        TerminalDestino terminalDestino = TerminalDestinoDAO.getInstancia().buscar(nombre);
        return terminalDestino;
    }
    
    public Bus buscar(String codigo) throws Exception{
        Bus bus = BusDAO.getInstancia().buscar(codigo);
        return bus;
    }
}
