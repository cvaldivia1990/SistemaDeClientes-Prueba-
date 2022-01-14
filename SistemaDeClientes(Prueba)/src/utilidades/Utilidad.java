package utilidades;

public class Utilidad {

	public void limpiarPantalla() {
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
		System.out.println();
		System.out.flush();
		System.out.println();
	}
	
	public void limpiarPantallaMenor() {
		for (int i = 0; i < 5; i++) {
			System.out.println();
		}
		System.out.flush();
		System.out.println();
	}

	public void esperar() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printLine(String mensaje) {
		System.out.println(mensaje);
	}

}