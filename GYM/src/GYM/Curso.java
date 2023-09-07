package GYM;
import GYM_util.clsListaArr;

public class Curso {
	String curso_id;
	String descripcion;
	String nombre;
	int cupo_max;
	int precio;
	clsListaArr inscriptos;

	public Curso (int id, String descripcion, String nombre, int cupo_max, int precio) {
		this.curso_id = "C" + id;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.cupo_max = cupo_max;
		this.precio = precio;	
		this.inscriptos = new clsListaArr (cupo_max);
	}
	
	public String getCodigo () {
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
	
	void inscribir (String id) {
		this.inscriptos.insertarU (id);  
	}
	
	boolean ya_esta (String id) {
		boolean flag = false ;
		if (!inscriptos.esta(id)) { flag = true ;}
		return flag;
	}
	
	boolean cursoLleno () {
		return inscriptos.lleno();
	}

	public String getNombre() {
		return this.nombre;
	}
	
	protected String[] mostrarSocios () {
		String [] temp = this.inscriptos.getIds();
		return temp;
	}

}

