package aplicacion.entidades;

public class Gasolinera {
	
	//--------------------------ATRIBUTOS, GETTERS Y SETTERS, OBJETOS TIPO GASOLINA------------------------------------
	
	
		//Mi objeto gasolinera en uno no esta vacio mientras que en el otro lo tengo que declarar vacio 
		public Gasolinera(String dni, String fecha, String matricula, double litos,double importe) 
		{
			super();
			this.dni = dni;
			this.fecha = fecha;
			this.matricula = matricula;
			this.litos = litos;
			this.importe = importe;
		}
		public Gasolinera() 
		{
			super();
			
		}
		//Los atributos de mi gasolinera
		private String dni;
		private String fecha;
		private String matricula;
		private double litos;
		private double importe;
		private int identificador = 0;
		private int contador;
		private boolean facturaONormal;
		//Los getters y los setters de los atributos
		public int getIdentificador() {
			return identificador;
		}
		public void setIdentificador(int identificador) {
			this.identificador = identificador;
		}
		public String getDni() {
			return dni;
		}
		public void setDni(String dni) {
			this.dni = dni;
		}
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) 
		{
			this.fecha = fecha;
		}
		public String getMatricula() {
			return matricula;
		}
		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}
		public double getLitos() {
			return litos;
		}
		public void setLitos(double litos) {
			this.litos = litos;
		}
		public double getImporte() {
			return importe;
		}
		public void setImporte(double importe) {
			this.importe = importe;
		}
		public boolean isFacturaONormal() {
			return facturaONormal;
		}
		public void setFacturaONormal(boolean facturaONormal) {
			this.facturaONormal = facturaONormal;
		}
		public String toString() {
			return "Repostaje [id=" + identificador + ", litros=" + litos + ", importe=" + importe + ", fchRepostaje=" + fecha
					+ ", dni=" + dni + ", matricula=" + matricula + "]";
		}

}
