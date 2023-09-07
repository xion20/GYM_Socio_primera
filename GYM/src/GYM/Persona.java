package GYM;

public abstract class Persona {
	String nya;
	String direccion;
	String email;
	int edad;
	int dni;
	
	public Persona(String nombre, int edad, String direccion, String mail, int dni) {
		setNya(nombre);
		setEdad(edad);
		setDireccion(direccion);
		setCorreo(mail);
		setDni (dni);
	}
	
	public Persona (String nya, int dni) {
		this.nya = nya;
		this.dni = dni;
	}
	protected Persona() {
		setNya(" - ");
	}
	protected void setNya(String nombreyA) {
		this.nya=nombreyA;
	}
	protected void setEdad (int edad) {
		this.edad = edad;
	}
	
	protected void setDni (int dni) {
		this.dni = dni;
	}
	protected void setDireccion(String direccion) {
		this.direccion=direccion;
	}
	private boolean verificarCorreo(String correo) {
		boolean resultado=false;
		//obvio hay mas empresas, pero por poner algo xd
		String[] empresas_legales= {"yahoo","gmail","outlook","hotmail"};
		int i=0;
		while(i<empresas_legales.length && resultado==false) {
			//hay correos que terminan en la terminacion de un pais, pero weno ;V
			if(correo.endsWith("@"+empresas_legales[i]+".com")) {
				resultado=true;
			}
			i++;
		}
		return resultado;
	}
	protected void setCorreo(String correo) {
		if(verificarCorreo(correo)) {
			this.email=correo;
		}else {
			System.out.println("Error, email inv�lido.");
		}
	}
	protected String getNya() {
		return this.nya;
	}
	protected String getdireccion() {
		return this.direccion;
	}
	protected String getEmail() {
		return this.email;
	}
	
	protected int getDni() {
		return this.dni;
	}
	
	protected int getEdad () {
		return this.edad;
	}
	
	public void mostrarDatos() {
		System.out.println("Nombre y Apellido: "+ this.nya);
		System.out.println("DNI: "+ this.dni);
	}
	
	protected void mostrar() {
		System.out.println("Nombre y Apellido: "+nya);
		System.out.println("DNI "+ dni);
	}
}
