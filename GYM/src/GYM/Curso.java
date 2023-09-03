package GYM;
import GYM_util.clsListaArr;

public class Curso {
	int curso_id;
	String descripcion;
	String nombre;
	int cupo_max;
	int precio;
	clsListaArr inscriptos;

	public Curso (int id, String descripcion, String nombre, int cupo_max, int precio) {
		this.curso_id = id;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.cupo_max = cupo_max;
		this.precio = precio;	
		this.inscriptos = new clsListaArr (cupo_max);
	}
	
	public int getCodigo () {
		return this.curso_id;
	}
	
	public int getPrecio () {
		return this.precio;
	}
	
	public void muestra () {
		System.out.println ("Codigo: " + curso_id);
		System.out.println ("Nombre: " + nombre);
		System.out.println ("Descripción: " + descripcion);
		System.out.println ("Cupo Maximo: " + cupo_max);
		System.out.println ("Precio: " + precio);
	}
	
	void inscribir (Socio socio) {
		this.inscriptos.insertarU (socio);  
	}
	
	boolean ya_esta (Socio socio) {
		boolean flag = false ;
		if (!inscriptos.esta(socio)) { flag = true ;}
		return flag;
	}
	
	boolean cursoLleno () {
		return inscriptos.lleno();
	}

	public String getNombre() {
		return this.nombre;
	}
	
	protected void mostrarSocios () {
		this.inscriptos.MostrarLst();
	}

}
