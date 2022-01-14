package servicio;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.CategoriaEnum;
import modelo.Cliente;
import vista.Menu;

public class ClienteServicio {

	Scanner scanner = new Scanner(System.in);
	Cliente cliente = new Cliente();
    ArrayList<Cliente> lista = Menu.listaClientes;

    public ClienteServicio() {
    	super();
    }
	
	public ArrayList<Cliente> getLista() {
		return lista;
	}


	public void setLista(ArrayList<Cliente> lista) {
		this.lista = lista;
	}


	public void editarCliente(String rut, String opcion) {
		switch (opcion) {
		case "1":
			for (Cliente cliente : lista) {
				if (cliente.getRunCliente().equals(rut)) {
//					
//					Recordar encontrar uso al Stream dentro de este programa.
//					Stream<Cliente> resultado = lista.stream().filter(c -> cliente.getRunCliente().equals(rut));
	
					System.out.println("-----Actualizando estado del Cliente----");
					System.out.println("El nombre del cliente actual es: " + cliente.getNombreCliente());
					System.out.println("El estado actual es: " + cliente.getNombreCategoria());
					System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo");
					System.out.println("2.-Si desea mantener/cambiar el estado del cliente a Activo");
					System.out.println("Ingrese opcion: ");
					int opc = scanner.nextInt();
					System.out.println("----------------------------------------");
					if (opc == 1) {
						cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
					}
					 else if (opc == 2) {
						cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
						}
					}
			}
			break;
			
		case "2":
			for (Cliente cliente : lista) {
				if (cliente.getRunCliente().equals(rut)) {
					System.out.println("----Actualizando datos del Cliente-----");
					System.out.printf("1.-El RUN del Cliente es:  %s \n\r", cliente.getRunCliente());
					System.out.printf("2.-El Nombre del Cliente es:  %s \n\r", cliente.getNombreCliente());
					System.out.printf("3.-El Apellido del Cliente es:  %s \n\r", cliente.getApellidoCliente());
					System.out.printf("4.-Los años como Cliente son:  %s  años \n\r", cliente.getAniosCliente());
					System.out.println("Ingrese la opción a editar de los datos del cliente:");
					String opcionEditar = scanner.nextLine();
					switch (opcionEditar) {
					case "1":
						System.out.printf("1.-Ingrese el nuevo RUN del Cliente:");
						String datoPorCambiar = scanner.nextLine();
						cliente.setRunCliente(datoPorCambiar);
						break;
					case "2":
						System.out.printf("2.-Ingrese el nuevo Nombre del Cliente:");
						datoPorCambiar = scanner.nextLine();
						cliente.setNombreCliente(datoPorCambiar);
						break;
					case "3":
						System.out.printf("3.-Ingrese el nuevo Apellido del Cliente:");
						datoPorCambiar = scanner.nextLine();
						cliente.setApellidoCliente(datoPorCambiar);
						;
						break;
					case "4":
						System.out.printf("4.-Ingrese los nuevos años como Cliente:");
						datoPorCambiar = scanner.nextLine();
						cliente.setAniosCliente(datoPorCambiar);
						;
						break;
					}
				} else {
					System.out.println("No existe un cliente con ese RUN \n");
				}
			}
			break;
			
		default:
			System.out.println("Opción no valida");
			
		}
		
		
	}


	
}
