package vista;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;
import utilidades.Utilidad;

public class Menu{

	public static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	ClienteServicio clienteServicio = new ClienteServicio();
	Scanner scanner = new Scanner(System.in);
	String opcion;
	Utilidad util = new Utilidad();

	
	public void iniciarMenu() {
		do {
			System.out.println("Bienvenido a Pastelería Bon Bon Jovi");
			System.out.println("1. Listar Clientes");
			System.out.println("2. Agregar Cliente");
			System.out.println("3. Editar Cliente");
			System.out.println("4. Cargar Datos");
			System.out.println("5. Exportar Datos");
			System.out.println("6. Salir");
			System.out.println("Ingrese una opción: ");
			opcion = scanner.nextLine();

			switch (opcion) {
			case "1":
				listarCliente();
				break;
			case "2":
				agregarCliente();
				break;
			case "3":
				editarCliente(null);
				break;
//			case "4":
//				importarDatos();
//				break;
//			case "5":
//				exportarDatos();
//				break;
			case "6":
				terminarPrograma();
				break;
			}
		} while (opcion != "6");
	}



	

//METODOS



	public void listarCliente() {
		listaClientes.forEach(c -> System.out.println("-------------Datos del Cliente-------------\n"
				+ (c.toString() + "\n-------------------------------------------")));
	}

	private void agregarCliente() {
		
		//Si creo el obj nuevoCliente fuera del metodo todos los objetos que se liste en listaClientes seran iguales.
		
		Cliente nuevoCliente = new Cliente();
		System.out.println("Ingresar rut:");
		nuevoCliente.setRunCliente(scanner.next());
		System.out.println("Ingresar nombre:");
		nuevoCliente.setNombreCliente(scanner.next());
		System.out.println("Ingresar apellido:");
		nuevoCliente.setApellidoCliente(scanner.next());
		System.out.println("Ingresar años como cliente:");
		nuevoCliente.setAniosCliente(scanner.next());
		nuevoCliente.setNombreCategoria(CategoriaEnum.ACTIVO);
		listaClientes.add(nuevoCliente);		
	}
	
	public  void editarCliente(Cliente runCliente) {
		System.out.println("-------------Editar Cliente-------------");
		System.out.println("Seleccione qué desea hacer:");
		System.out.println("1.-Cambiar el estado del Cliente");
		System.out.println("2.-Editar los datos ingresados del Cliente");
		System.out.println("Ingrese opcion:");
		opcion = scanner.nextLine();
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
		default:
			System.out.println("La opción no es válida");
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
