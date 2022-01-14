package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import modelo.CategoriaEnum;
import modelo.Cliente;

public class ArchivoServicio extends Exportador {

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) throws FileNotFoundException {
		// TODO Auto-generated method stub

	}

	public ArrayList<Cliente> cargarDatos(String path) throws FileNotFoundException
	{
		File archivo = new File(String.format("%s/DBClientes.csv", path));
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		if (archivo.exists()) {			
			try {
				FileReader fr = new FileReader(archivo);
				BufferedReader lector = new BufferedReader(fr);
				String data = lector.readLine();
				while (data != null) {					
					String[] datos = data.split(",");
					Cliente c = new Cliente(datos[0], datos[1], datos[2], datos[3], 
							CategoriaEnum.valueOf(datos[4]));
					clientes.add(c);
					data = lector.readLine();
				}	
				System.out.println("Datos cargados correctamente en la lista");
				lector.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		else
		{
			System.out.println("El archivo no se encuentra en esa ruta.");
		}
		
		return clientes;
	}
}