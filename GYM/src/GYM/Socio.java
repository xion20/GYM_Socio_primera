package GYM;
import GYM_util.clsListaOrdLinkedCursos;
import java.util.Scanner;

public abstract class Socio extends Persona {
	int socio_id;
	int cuota_mensual;
	clsListaOrdLinkedCursos cursos;
	int cuota_total;
	static Scanner reader = new Scanner(System.in);
	
	public Socio () { }
	
	public Socio (String nya, int dni, int id) {
		super(nya, dni);
		this.socio_id = id;
		this.cuota_mensual = 0;
		this.cursos = new clsListaOrdLinkedCursos();
	}
	
	protected abstract void setCuota_m (int cuota_m);
	
	protected abstract void calq_total () ;
	
	public int getCuota_Total () {
		return this.cuota_total;
	}
	
	public int getTotal () {
		this.calq_total();
		return this.cuota_total;
	}
	
	public void mostrarTotal () {
		this.calq_total();
		System.out.println (this.cuota_total);
	}
	
	protected void agregar_curso (Curso curso) {
		this.cursos.inserta (curso);
		System.out.println ("Se ha agregado a " + this.nya + " a " + curso.getNombre());
	}
	
	public void getDatos () {
		System.out.println (this.nya);
		System.out.println (this.dni);
	}
	
	public void getCursos () {
		this.cursos.muestra();
	}
	
	
}
