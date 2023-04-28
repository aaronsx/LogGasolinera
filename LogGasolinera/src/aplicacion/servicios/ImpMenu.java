package aplicacion.servicios;

public class ImpMenu implements IntMenu {
	public void Menu() {
		System.out.println("<-----------Menu------------->");
		System.out.println("1. Repostaje normal");
		System.out.println("2. Repostaje factura");
		System.out.println("3. Eliminar un remostaje");
		System.out.println("4. Mostrar repostajes dividido");
		System.out.println("5. Modificar repostajes");
		System.out.println("0. Salir");
	}
}
