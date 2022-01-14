package modelo;

import java.util.ArrayList;

public class Cliente {
	
	//ATRIBUTOS
	public ArrayList<Cliente>listaCliente = new ArrayList<Cliente>();
	public String runCliente;
	public String nombreCliente;
	public String apellidoCliente;
	public String aniosCliente;
	public CategoriaEnum nombreCategoria;
	
	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum nombreCategoria) {
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.nombreCategoria = nombreCategoria;
	}

	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente) {
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
	}

	public Cliente(ArrayList<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public Cliente() {
	}
	

	public ArrayList<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(ArrayList<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public String getRunCliente() {
		return runCliente;
	}

	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getAniosCliente() {
		return aniosCliente;
	}

	public void setAniosCliente(String aniosCliente) {
		this.aniosCliente = aniosCliente;
	}

	public CategoriaEnum getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	@Override
	public String toString() {
		return "Cliente: \n"
				+ "RUN del Cliente: " + runCliente + "\nNombre del Cliente: " + nombreCliente + "\nApellido del Cliente: "
				+ apellidoCliente + "\nAños como Cliente: " + aniosCliente + "\nCategoría del Cliente: " + nombreCategoria;
	}
	
	
	
	
}
