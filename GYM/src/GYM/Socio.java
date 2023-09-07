package GYM;
import GYM_util.clsListaOrdLinkedCursos;
import java.util.Scanner;

public abstract class Socio extends Persona {
	String id;
	int cuota_mensual;
	clsListaOrdLinkedCursos cursos;
	int cuota_total;
	static Scanner reader = new Scanner(System.in);
	
	public Socio () { }
	
	public Socio (String nya, int dni) {
		super(nya, dni);
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
	
	protected void agregar_curso (String id, int cuota) {
		this.cursos.inserta (id,cuota);
		System.out.println ("Se ha agregado a " + this.nya + " al curso.");
	}
	
	public void getDatos () {
		System.out.println (this.nya);
		System.out.println (this.dni);
	}
	
	public String [] getCursos () {
		String [] temp = this.cursos.getIds();
		return temp;
	}
	
	public String getId() {
		return this.id;
	}
	
	
}

