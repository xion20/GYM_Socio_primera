package GYM;

public class Normal extends Socio {

	public Normal(String nya, int dni, int id) {
		super(nya, dni, id);
		this.socio_id = 100;
	}
	
	protected void setCuota_m (int cuota_m) {
		this.cuota_mensual = 1000;	
	}
	
	protected void calq_total () {
		this.cuota_total = cuota_mensual + cursos.total();
	}

}
