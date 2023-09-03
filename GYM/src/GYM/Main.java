package GYM;
import java.util.Scanner;
import GYM_util.clsListaLinkedList;

public class Main {
	static clsListaLinkedList socios = new clsListaLinkedList();
	static clsListaLinkedList cursos = new clsListaLinkedList();
	static Scanner reader=new Scanner(System.in);
	int cont = 0;
	
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
				while(opcion < 1||opcion > 8) {
					System.out.println("Opcion invalida, ingrese un numero entre 1 y 8");
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
		System.out.println("  8. Salir del GYM");
	}
	
	public static boolean iniciarMenu() {
		boolean response = true;
		printMenu();
		switch(opcionUsuario()) {
		case 1:
			addSocio();
			break;
		case 2:
			socio_a_curso ();
			break;
		case 3:
			Socio x = seleccionarSocio();
			x.getCursos();
			break;
		case 4:
			Curso y = seleccionarCurso ();
			y.mostrarSocios ();
			break;
		case 5:
			Socio x1 = seleccionarSocio();
			x1.mostrarTotal();
			break;
		case 6:
			cursos.muestraCurs();
			break;
		case 7:
			socios.muestraSoc();
			break;
		case 8:
			response=false;
			break;
		}
		return response;
	}
	
	static Socio seleccionarSocio () {
		Socio x;
		socios.muestraSoc();
		System.out.println("Ingrese el numero de socio: ");
		int op = reader.nextInt();
		x = socios.darSocio (op);
		return x;
	}
	
	static Curso seleccionarCurso () {
		Curso y;
		cursos.muestraCurs();
		System.out.println("Ingrese el numero de curso: ");
		int op = reader.nextInt();
		y = cursos.darCurso (op);
		return y;
	}
	
	static void addSocio () {
		System.out.println ("Ingrese el nombre del usuario: ");
		String nya = reader.next();
		System.out.println ("Ingrese el dni del usuario: ");
		int dni = reader.nextInt();
		System.out.println("Ingrese el tipo de socio: 1 = Normal, 2 = Jubilado, 3 = infantil");
		int op = reader.nextInt();
		switch (op) {
		case 1:
			Normal soc = new Normal (nya,dni);
			socios.insertaTope(soc);
			System.out.println("Se ha agregado al socio.");
			break;
		case 2:
			Jubilado jub = new Jubilado (nya,dni);
			socios.insertaTope(jub);
			System.out.println("Se ha agregado al socio.");
			break;
		case 3:
			Infantil inf = new Infantil (nya,dni);
			socios.insertaTope(inf);
			System.out.println("Se ha agregado al socio.");
			break;
		}
	}
	
	static void agregar (Socio socio, Curso curso) {
		if (curso.cursoLleno()) {
			System.out.println ("error, curso lleno");
		}else { 
			if (!curso.ya_esta (socio)) {
				System.out.println ("El socio ya esta en el curso.");
			} else {
				socio.agregar_curso (curso);
				curso.inscribir (socio);
			}
		}
	}
	
	static void socio_a_curso () {
		Curso y = seleccionarCurso ();
		Socio x = seleccionarSocio();
		agregar (x,y);
	}

	public static void main(String[] args) {
		Curso curs1 = new Curso ("00001","Lun, Mie, Vie","Taekwondo",10,300);
		Curso curs2 = new Curso ("00001","Mar, Juev","Boxeo",2,100);
		Curso curs3 = new Curso ("00001","Mar, Juev","Boxeo",2,100);
		
		cursos.insertaTope(curs1);
		cursos.insertaTope(curs2);
		cursos.insertaTope(curs3);
		while(iniciarMenu());
		


	}

}
