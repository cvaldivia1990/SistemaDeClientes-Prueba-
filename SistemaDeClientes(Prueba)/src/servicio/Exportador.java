package servicio;

import java.io.FileNotFoundException;
import java.util.List;

import modelo.Cliente;

public abstract class Exportador {

	public abstract void exportar(String path, List<Cliente> listaClientes) throws FileNotFoundException;

}
