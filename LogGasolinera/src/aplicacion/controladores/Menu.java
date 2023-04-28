package aplicacion.controladores;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import aplicacion.entidades.Gasolinera;
import aplicacion.servicios.ImpGaso;
import aplicacion.servicios.ImpMenu;
import aplicacion.servicios.IntGaso;
import aplicacion.servicios.IntMenu;
import Utils.Mensajes;
public class Menu {

	public static void main(String[] args) {
		//Creamos un objeto de tipo Gasolineria para tener el mismo tipo que en Gasolineria.java y poder llamar metodos de esa clase
		//Creamos un objeto de tipo Gasolineria para tener el mismo tipo que en Gasolineria.java y poder llamar metodos de esa clase
				IntGaso gaso=new ImpGaso();
				IntMenu menugaso=new ImpMenu();
				Mensajes mensajes=new Mensajes();
				//La base de datos del tipo Gasolineria 
				List<Gasolinera> listgasolinera=new ArrayList<>();
					
				Boolean cerrarMenu = false;
				 File archivo = new File ("C:\\Users\\Sturt\\OneDrive\\Escritorio\\Mio\\Logs.txt");
				 		
				
				int opcion;
				try {
				while(!cerrarMenu) 
				{	
					Scanner preguntar = new Scanner(System.in);	
					//Mostramos el menú
					menugaso.Menu();
					System.out.println("Introduza la opción deseada: ");
					opcion = preguntar.nextInt();
					System.out.println("[INFO] - Has seleccionado la opcion " + opcion);
					
					switch (opcion) 
					{			
						case 1:
							
							gaso.gasolinera(false, listgasolinera,archivo);
							break;
						case 2:
							gaso.gasolinera(true, listgasolinera,archivo);
							
							break;
						
						case 3:
							gaso.borrarRepostaje(listgasolinera,archivo);
							break;
						case 4:
							gaso.mostrardatosgasolinera(listgasolinera,archivo);
							break;
						case 5:
							gaso.modificarrepostaje(listgasolinera,archivo);
							break;
						case 0:
							cerrarMenu = true;
							break;
						default:
							
					}
				
					
				}	
				}catch(InputMismatchException e){
					 
					 gaso.AbrirFichero(archivo,mensajes.getFormatoERR());
				 }catch(Exception e) {
						System.out.println("Se produjo un error"+e.getMessage());
					}
	
	}
	
}
