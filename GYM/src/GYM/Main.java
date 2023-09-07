package GYM;
import java.util.Scanner;

public class Main {
	static Scanner reader=new Scanner(System.in);
	
	private static boolean esInt(String ingreso) {
		boolean response;
		try {
			Integer.parseInt(ingreso);
			response=true;
		}catch(NumberFormatException nfe){
			response=false;
		}
		return response;
	}
	
	public static int opcionUsuario() {
		reader.reset();
		int opcion = 0;
		String ingreso;
		System.out.print("Ingrese la opcion que desee ejecutar: ");
		ingreso = reader.next();
		boolean elegido = false;
		while(!elegido) {
			if(esInt(ingreso)) {
				opcion=Integer.parseInt(ingreso);
				while(opcion < 1||opcion > 10) {
					System.out.println("Opcion invalida, ingrese un numero entre 1 y 10");
					printMenu();
					System.out.print("Ingrese la opcion que desee ejecutar: ");
					ingreso=reader.next();
				}
				elegido=true;
			}else {
				System.out.println("Opcion invalida, ingrese un numero");
				printMenu();
				System.out.print("Ingrese la opcion que desee ejecutar: ");
				ingreso=reader.next();
			}
		}
		return opcion;
	} 
	
	public static void printMenu() {
		System.out.println("==========Bienvenido a BLACK (GYM FOR BEASTS) ==========");
		System.out.println("  1. Agregar un socio");
		System.out.println("  2. Agregar a un socio a un curso");
		System.out.println("  3. Consultar los cursos de un socio");
		System.out.println("  4. Consultar los socios de un curso");
		System.out.println("  5. Calcular mensualidad de un socio");
		System.out.println("  6. Mostrar cursos disponibles");
		System.out.println("  7. Mostrar socios actuales");
		System.out.println("  8. Agregar un Normal a un Infantil");
		System.out.println("  9. Dar Normal de infantil");
		System.out.println("  10. Salir del GYM");
	}
	static Movimiento mov = new Movimiento ();
	
	public static boolean iniciarMenu() {
		boolean response = true;
		printMenu();
		switch(opcionUsuario()) {
		case 1:
			mov.addSocio();
			break;
		case 2:
			mov.socio_a_curso ();
			break;
		case 3:
			mov.get_Curso_Socio();
			break;
		case 4:
			mov.get_Socio_Curso ();
			break;
		case 5:
			mov.CalqMens();
			break;
		case 6:
			mov.muestraCursos();
			break;
		case 7:
			mov.MuestrSoc();
			break;
		case 8:
			mov.NormldeInf();
			break;
		case 9:
			mov.DarAdltInf ();
			break;
		case 10:
			response=false;
			break;
	}
		return response;
	}

	public static void main(String[] args) {
		Curso curs1 = new Curso (0,"Lun, Mie, Vie","Taekwondo",10,300);
		Curso curs2 = new Curso (1,"Mar, Juev","Boxeo",2,100);
		Curso curs3 = new Curso (2,"Mar, Juev","Boxeo",2,100);
		
		mov.addCurso (curs1);
		mov.addCurso (curs2);
		mov.addCurso (curs3);
		
		while(iniciarMenu());
		


	}

}
