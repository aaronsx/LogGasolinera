package aplicacion.servicios;



import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import aplicacion.entidades.Gasolinera;

public interface IntGaso {
	/**
	 * Método abrir un fichero
	 * @param db Arraylista actual,file para abrir el fichero
	 * @return nada 
	 */
	public void gasolinera(boolean ok, List<Gasolinera>bd,File archivo);
	/**
	 * Método abrir un fichero
	 * @param db Arraylista actual,file para abrir el fichero
	 * @return nada 
	 */
	public void modificarrepostaje(List<Gasolinera>bd,File archivo);
	/**
	 * Método abrir un fichero
	 * @param db Arraylista actual,file para abrir el fichero
	 * @return nada 
	 */
	public void borrarRepostaje(List<Gasolinera> bd,File archivo);
	/**
	 * Método abrir un fichero
	 * @param db Arraylista actual,file para abrir el fichero
	 * @return nada 
	 */
	public void mostrardatosgasolinera(List<Gasolinera>bd,File archivo);
	/**
	 * Método abrir un fichero
	 * @param db Arraylista actual,file para abrir el fichero
	 * @return nada 
	 */
	public void AbrirFichero(File archivo, String mensaje);
	/**
	 * Método escribir un fichero
	 * @param db Arraylista actual,fileReader para leer el fichero
	 * @return nada
	 */
	public void EscribirFichero(FileWriter fichero, String mensaje);
	/**
	 * Método cierrar un fichero
	 * @param file para cerrar el fichero
	 * @return 
	 */
	public void CerrarFichero(FileWriter fichero);
	
}
