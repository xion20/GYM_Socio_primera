package GYM;

public class Infantil extends Socio {
	Normal socio_adulto;
	
	public Infantil (String nya, int dni, int id ) {
		super(nya, dni, id);
		this.socio_id = 300;
		this.socio_adulto = null;
	}
	
	protected void setCuota_m (int cuota_m) {
		this.cuota_mensual = 500;		
	}
	
	protected void setSocio_Adl (Normal socio_ad) {
		this.socio_adulto = socio_ad;
	}
	
	private boolean sin_socio () {
		boolean flag = false;
		if (this.socio_adulto == null ) {
			flag = true;
		}
		return flag;
	}

	protected void calq_total() {
		if (sin_socio()) {
			this.cuota_total = this.cuota_mensual + this.cursos.total(); 
		} else {
			double temp = (this.cuota_mensual + cursos.total())* 0.15 ;
			this.cuota_total = (int) ((this.cuota_mensual + cursos.total()) - temp);
		}
	}
	

}
