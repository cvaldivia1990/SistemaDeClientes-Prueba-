package vista;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

public class Menu{

	public static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	ClienteServicio clienteServicio = new ClienteServicio();
	ArchivoServicio archivoServicio = new ArchivoServicio();
	ExportadorCsv exportadorCsv = new ExportadorCsv();
	ExportadorTxt exportadorTxt = new ExportadorTxt();
	Scanner scanner = new Scanner(System.in);
	Utilidad util = new Utilidad();
	

	
	public void iniciarMenu() {
		String opcionIniciarMenu = "";
		while (opcionIniciarMenu != "6") {
			
			System.out.println(	"Bienvenido a Pastelería Bon Bon Jovi \n"
								+"1. Listar Clientes \n"
								+"2. Agregar Cliente\n"
								+"3. Editar Cliente\n"
								+"4. Cargar Datos\n"
								+"5. Exportar Datos\n"
								+"6. Salir\n");
			
			System.out.println("Ingrese una opción: ");
			
			opcionIniciarMenu = scanner.nextLine();
			
			switch (opcionIniciarMenu) {
			case "1":
				listarCliente();
				break;
			case "2":
				agregarCliente();
				break;
			case "3":
				editarCliente(null);
				util.limpiarPantallaMenor();
				break;
			case "4":
				importarDatos();
				break;
			case "5":
				exportarDatos();
				break;
			case "6":
				terminarPrograma();
				break;
			}
		};
	}



	

	private void exportarDatos() {
		System.out.println("---------Exportar Datos-----------");
		System.out.println("Seleccione el formato a exportar:");
		System.out.println("1.-Formato csv");
		System.out.println("2.-Formato txt");
		System.out.println("Ingrese una opción para exportar:");
		String op = scanner.nextLine();
		System.out.println("----------------------------------");

		switch (op) {
		case "1":
			System.out.println("---------Exportar Datos-----------");
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
			String ruta = scanner.nextLine();
			try {
				exportadorCsv.exportar(ruta, clienteServicio.getLista());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case "2":
			System.out.println("---------Exportar Datos-----------");
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.txt:");
			String ruta1 = scanner.nextLine();
			try {
				exportadorTxt.exportar(ruta1, clienteServicio.getLista());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			break;
		}
		
	}

	private void importarDatos() {
			System.out.println("---------Cargar Datos-----------");
			System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
			String ruta = scanner.nextLine();
			try {
				ArrayList<Cliente> clientes = archivoServicio.cargarDatos(ruta);
				listaClientes.addAll(clientes);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	public void listarCliente() {
		listaClientes.forEach(c -> System.out.println("-------------Datos del Cliente-------------\n"
				+ (c.toString() + "\n-------------------------------------------")));
	}

	private void agregarCliente() {
		
		//Si creo el obj nuevoCliente fuera del metodo todos los objetos que se liste en listaClientes seran iguales.
		
		Cliente nuevoCliente = new Cliente();
		System.out.println("Ingresar rut:");
		nuevoCliente.setRunCliente(scanner.nextLine());
		System.out.println("Ingresar nombre:");
		nuevoCliente.setNombreCliente(scanner.nextLine());
		System.out.println("Ingresar apellido:");
		nuevoCliente.setApellidoCliente(scanner.nextLine());
		System.out.println("Ingresar años como cliente:");
		nuevoCliente.setAniosCliente(scanner.nextLine());
		nuevoCliente.setNombreCategoria(CategoriaEnum.ACTIVO);
		listaClientes.add(nuevoCliente);		
	}
	
	public void editarCliente(Cliente runCliente) {
		System.out.println("-------------Editar Cliente-------------");
		System.out.println("Seleccione qué desea hacer:");
		System.out.println("1.-Cambiar el estado del Cliente");
		System.out.println("2.-Editar los datos ingresados del Cliente");
		System.out.println("Ingrese opcion:");
		String opcion = scanner.nextLine();
		System.out.println("----------------------------------------");
		switch (opcion) {
		case "1":
			System.out.println("Ingrese RUN del Cliente a editar:");
			String rut = scanner.nextLine();
			clienteServicio.editarCliente(rut, opcion);
			break;
		case "2":
			System.out.println("Ingrese RUN del Cliente a editar:");
			rut = scanner.nextLine();
			clienteServicio.editarCliente(rut, opcion);
			break;
		}
	}
	

	private void terminarPrograma() {
		util.limpiarPantalla();
		System.out.println("Gracias por usar nuestro programa, hasta luego :)");
		util.esperar();
		System.exit(0);
		
	}
	
	
	
	
	
	
}
