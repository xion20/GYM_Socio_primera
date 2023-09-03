package GYM;

public class Jubilado extends Socio {
	public Jubilado (String nya, int dni, int id) {
		super(nya, dni, id);
		this.socio_id = 200;
	}
	
	protected void setCuota_m (int cuota_m) {
		this.cuota_mensual = 800;	
	}

	protected void calq_total() {
		double temp = (this.cuota_mensual + cursos.total())* 0.20 ;
		this.cuota_total = (int) ((this.cuota_mensual + cursos.total()) - temp);		
	}
	

}
