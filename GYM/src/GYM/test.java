package GYM;

public class test {

	public static void main(String[] args) {
		Normal soc1 = new Normal ("David Del Castillo", 45261409);
		Infantil soc2 = new Infantil ("Alejandro Ruiz", 53261409);
		Jubilado soc3 = new Jubilado ("Raul Chavarría", 11261409);
		
		Curso curs1 = new Curso ("00001","Lun, Mie, Vie","Taekwondo",10,300);
		Curso curs2 = new Curso ("00001","Mar, Juev","Boxeo",2,100);
		
		Main.agregar (soc1,curs1);
		Main.agregar (soc2,curs2);
		Main.agregar (soc3,curs2);
		Main.agregar (soc1,curs1);
		
		curs2.mostrarSocios ();
		curs1.mostrarSocios ();
		
		
		soc1.mostrarTotal ();
		soc2.mostrarTotal ();
		soc3.mostrarTotal ();
		
		

	}

}
