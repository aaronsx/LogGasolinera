package aplicacion.servicios;


import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import aplicacion.entidades.Gasolinera;
import Utils.Mensajes;

public class ImpGaso implements IntGaso {
	
	Mensajes mensajes=new Mensajes();
	@Override
	public void gasolinera(boolean ok, List<Gasolinera> bd,File archivo) {
		//Creamos un objeto gasoVacio para poder devolver el tipo de obeto y poder añadirlo a la base de datos
		Gasolinera gasoVacio = new Gasolinera();
		
		 Scanner pedir = new Scanner(System.in);
		 int taman=0;
		 //Construccion de la fecha y hora en este momento
		 try {
			 
		
		 String dateTime = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm:ss a")
                 .format(LocalDateTime.now());
		 taman=bd.size();
		 
		 //Pedimos los litros
		 System.out.println("Introduce los litros:");
		
		 //Implementamos los litros en la base de datos
		 gasoVacio.setLitos(pedir.nextDouble());
		 
		 //Pedimos el importe
		 System.out.println("Introduce el importe:");
		 
		 //Implementamos el importe en la base de datos
		 gasoVacio.setImporte(pedir.nextDouble());
		//añadir una id 
		 gasoVacio.setIdentificador(calculoIdGaso(bd));
		 //Implementamos la fecha y hora en la base de datos
		 gasoVacio.setFecha(dateTime);
		//Saber si es factura
		gasoVacio.setFacturaONormal(ok);		    
		 //If si la persona introduce la 2 opcion pasa y si no pues va por el else
		if(ok)
		{
			System.out.println("Introduce tu dni:");
			//Implementamos el dni
			gasoVacio.setDni(pedir.next());
			System.out.println("Introduce tu matricula:");
			//Implementamos la matricula
			gasoVacio.setMatricula(pedir.next());
			
		}
		else
		{
			//En este caso solo entra cuando la persona ha elegido la 1 opcion y no se le tiene que pedir ni el dni ni la matricula
			
			//Guardamos dni como si fuera nulo
			gasoVacio.setDni(null);
			//Guardamos matricula como si fuera nula 
			gasoVacio.setMatricula(null);
			
		}
	}catch(InputMismatchException e){
			 
			 AbrirFichero(archivo,mensajes.getFormatoERR());
		 }catch(Exception e) {
				System.out.println("Se produjo un error"+e.getMessage());
			}
		bd.add(gasoVacio);
		if(bd.size()>taman)
			AbrirFichero(archivo,mensajes.getAgregarRepos());
		else
			AbrirFichero(archivo,mensajes.getAgregarReposERR());
	}
	@Override
	public void borrarRepostaje(List<Gasolinera> bd,File archivo) {
		 try {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dime el id del repostaje a borrar: ");
		int idBorrar = entrada.nextInt();				
		for(Gasolinera alumno: bd) {
			if(alumno.getIdentificador() == idBorrar) {
				if(bd.remove(alumno))
					AbrirFichero(archivo,mensajes.getEliminarRepostaje());
				else
					AbrirFichero(archivo,mensajes.getEliminarRepostajeERR());
			}			
		}		
}catch(InputMismatchException e){
			 
			 AbrirFichero(archivo,mensajes.getFormatoERR());
		 }catch(Exception e) {
				System.out.println("Se produjo un error"+e.getMessage());
			}
			
	}

	@Override
	public void modificarrepostaje(List<Gasolinera> bd,File archivo) {
		Scanner modificar = new Scanner(System.in);
		boolean ok;
		int numero=0;
		 try {
		do 
		{
			ok=true;
			
			System.out.println("Introduce 1 para repostaje normal y 2 para repostaje con factura");
			numero=modificar.nextInt();
			switch (numero) 
			{
			//si es repostaje normal
			case 1:
				System.out.println("--------Repostajes Normales--------");
				for(Gasolinera gaso:bd)
				{

					
						//en caso de false va a mostrar solo los normales
						if(gaso.isFacturaONormal()==false)
						{
							System.out.println(gaso.toString());
							System.out.println("Introduce el dni");
							gaso.setDni(modificar.next());
							System.out.println("Introduce el importe");
							gaso.setImporte(modificar.nextInt());
							System.out.println("Introduce la matricula");
							gaso.setMatricula(modificar.next());
							System.out.println("Introduce el litros");
							gaso.setLitos(modificar.nextInt());
							if(gaso.getDni()!=null)
								gaso.setFacturaONormal(true);
						}
				}
				break;
			//si es repostaje con factura
			case 2:
				System.out.println("--------Repostajes con Factura--------");
				for(Gasolinera gaso:bd)
				{
						if(gaso.isFacturaONormal()==true)
						{
							System.out.println(gaso.toString());
							System.out.println("Introduce el dni");
							gaso.setDni(modificar.next());
							System.out.println("Introduce el importe");
							gaso.setImporte(modificar.nextInt());
							System.out.println("Introduce la matricula");
							gaso.setMatricula(modificar.next());
							System.out.println("Introduce el litros");
							gaso.setLitos(modificar.nextInt());
							if(gaso.getDni()==null)
								gaso.setFacturaONormal(false);
						}
				}
				break;
				default:
					ok=false;
			}	
			if(numero==1)
				AbrirFichero(archivo,mensajes.getModidificarRepostaje());
		else
				AbrirFichero(archivo,mensajes.getModidificarRepostajeERR());
			
			
		}while(!ok);
}catch(InputMismatchException e){
			 
			 AbrirFichero(archivo,mensajes.getFormatoERR());
		 }catch(Exception e) {
				System.out.println("Se produjo un error"+e.getMessage());
			}
	}
	private int calculoIdGaso(List<Gasolinera> listaAntigua) {
		int auxiliar = 0;
		for(int i = 0; i< listaAntigua.size(); i++) {
			int j = listaAntigua.get(i).getIdentificador();
			if(auxiliar<j) {
				auxiliar = j;
			}
		}
		return auxiliar + 1;
	}

	@Override
	public void mostrardatosgasolinera(List<Gasolinera> bd,File archivo) {
		//Un bucle forech para sacar todos los datos de la base de datos de gasolinera
		//Dentro del bloque recorre toda la lista bd con un atributo del tipo Gasolina que es el mismo que el de la base de datos
		Scanner modificar = new Scanner(System.in);
		boolean ok;
		int numero=0;
		 try {
		do 
		{
			ok=true;
			
			System.out.println("Introduce 1 para repostaje normal y 2 para repostaje con factura");
			numero=modificar.nextInt();
			switch (numero) 
			{
			//si es repostaje normal
			case 1:
				System.out.println("--------Repostajes Normales--------");
				for(Gasolinera gaso:bd)
				{

					
						//en caso de false va a mostrar solo los normales
						if(gaso.isFacturaONormal()==false)
							System.out.println(gaso.toString());
							
				}
				break;
			//si es repostaje con factura
			case 2:
				System.out.println("--------Repostajes con Factura--------");
				for(Gasolinera gaso:bd)
				{
						if(gaso.isFacturaONormal()==true)
							System.out.println(gaso.toString());
				}
				break;
				default:
					ok=false;
			}	
		
			if(numero==1)
				AbrirFichero(archivo,mensajes.getModidificarRepostaje());
		else
				AbrirFichero(archivo,mensajes.getModidificarRepostajeERR());
			
			
		}while(!ok);
}catch(InputMismatchException e){
			 
			 AbrirFichero(archivo,mensajes.getFormatoERR());
		 }catch(Exception e) {
				System.out.println("Se produjo un error"+e.getMessage());
			}
	}
	@Override
	public void AbrirFichero(File archivo,String mensaje) {

		//Creamos el fr para luego en el try controlar si se abre bien o no
		FileWriter fichero=null;
       
        try
        {
        	fichero = new FileWriter(archivo,true);


        } catch (Exception e) {
            e.printStackTrace();
        } 
        EscribirFichero(fichero,mensaje);
	}

	@Override
	public void EscribirFichero(FileWriter fichero, String mensaje) {
		
		   LocalDateTime fechaHoraActual = LocalDateTime.now();
        try
        {
      
        	PrintWriter pw= new PrintWriter(fichero,true);

            
                pw.println("================================================================================================");
                pw.println("["+fechaHoraActual+"] "+mensaje);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	CerrarFichero(fichero);
        }
		
	}

	@Override
	public void CerrarFichero(FileWriter fichero) {
		
		try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	}

}
