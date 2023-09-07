package GYM;
import java.util.Scanner;
import GYM_util.clsListaLinkedList;

public class Movimiento {
	clsListaLinkedList sociosN;
	clsListaLinkedList sociosJ;
	clsListaLinkedList sociosI;
	clsListaLinkedList cursos;
	Scanner reader=new Scanner(System.in);
	int cont = 0;
	int Cursos = 0;
	int x = 0; 
	int j = 0; 
	int k = 0;
	
	Movimiento () {
		sociosN = new clsListaLinkedList();
		sociosJ = new clsListaLinkedList();
		sociosI = new clsListaLinkedList();
		cursos = new clsListaLinkedList();
	}
	
	void addCurso (Curso curso) {
		cursos.inserta(curso);
	}
	
	int seleccionarSocio () {
		muestraSoc();
		System.out.println("Ingrese el numero de socio: ");
		int op = reader.nextInt();
		return op;
	}
	
	 Curso seleccionarCurso () {
		Curso y;
		cursos.muestraCurs();
		System.out.println("Ingrese el numero de curso: ");
		int op = reader.nextInt();
		y = cursos.darCurso (op);
		return y;
	}
	 
	 /*
	  * Case 1
	  */
	
	 void addSocio () {
		System.out.println ("Ingrese el nombre del usuario: ");
		String nya = reader.next();
		System.out.println ("Ingrese el dni del usuario: ");
		int dni = reader.nextInt();
		System.out.println("Ingrese el tipo de socio: 1 = Normal, 2 = Jubilado, 3 = infantil");
		int op = reader.nextInt();
		switch (op) {
		case 1:
			Normal soc = new Normal (nya,dni,cont);
			sociosN.inserta(soc);
			System.out.println("Se ha agregado al socio.");
			break;
		case 2:
			Jubilado jub = new Jubilado (nya,dni,cont);
			sociosJ.inserta(jub);
			System.out.println("Se ha agregado al socio.");
			break;
		case 3:
			Infantil inf = new Infantil (nya,dni,cont);
			sociosI.inserta(inf);
			System.out.println("Se ha agregado al socio.");
			break;
		}
	}
	
	 /*
	  * Case 2
	  */
	 
	void agregarN (Normal socio, Curso curso) {
		String id;
		int monto;
		if (curso.cursoLleno()) {
			System.out.println ("error, curso lleno");
		}else { 
			id = socio.getId();
			if (!curso.ya_esta (id)) {
				System.out.println ("El socio ya esta en el curso.");
			} else {
				curso.inscribir (id);
				id = curso.getCodigo();
				monto = curso.getPrecio();
				socio.agregar_curso (id,monto);	
			}
		}
	}
	
	void agregarJ (Jubilado socio, Curso curso) {
		String id;
		int monto;
		if (curso.cursoLleno()) {
			System.out.println ("error, curso lleno");
		}else { 
			id = socio.getId();
			if (!curso.ya_esta (id)) {
				System.out.println ("El socio ya esta en el curso.");
			} else {
				curso.inscribir (id);
				id = curso.getCodigo();
				monto = curso.getPrecio();
				socio.agregar_curso (id,monto);	
			}
		}
	}
	
	void agregarI (Infantil socio, Curso curso) {
		String id;
		int monto;
		if (curso.cursoLleno()) {
			System.out.println ("error, curso lleno");
		}else { 
			id = socio.getId();
			if (!curso.ya_esta (id)) {
				System.out.println ("El socio ya esta en el curso.");
			} else {
				curso.inscribir (id);
				id = curso.getCodigo();
				monto = curso.getPrecio();
				socio.agregar_curso (id,monto);	
			}
		}
	}
	
	 void socio_a_curso () {
		Curso y = seleccionarCurso ();
		int op = seleccionarSocio();
		if (op <= j) {
			Normal soc = sociosN.darSocioN(op);
			agregarN(soc,y);
		}else if (op <= k) {
			Jubilado soc = sociosJ.darSocioJ(op - k + 1);
			agregarJ(soc,y);
		}else if (op <= x) {
			Infantil soc = sociosI.darSocioI(op - x + 1);
			agregarI(soc,y);
		}
		x = 0;
	}
	 
	 /*
	  * Case 3
	  */
	 
	 void get_Curso_Socio () {
		 int op = seleccionarSocio();
		 if (op <= j) {
			Normal soc = sociosN.darSocioN(op);
			String [] curs = soc.getCursos ();
			for (int i = 0; i < curs.length;i++) {
				cursos.muestraCursId(curs[i], i + 1);
			}
		}else if (op <= k) {
			Jubilado soc = sociosJ.darSocioJ(op - k + 1);
			String [] curs = soc.getCursos ();
			for (int i = 0; i < curs.length;i++) {
				cursos.muestraCursId(curs[i], i + 1);
			}
		}else if (op <= x) {
			Infantil soc = sociosI.darSocioI(op - x + 1);
			String [] curs = soc.getCursos ();
			for (int i = 0; i < curs.length;i++) {
				cursos.muestraCursId(curs[i], i + 1);
			}
		}
		 x = 0;
	}
	
	 /*
	  * Case 4
	  */
	
	 void get_Socio_Curso () {
		Curso curso = seleccionarCurso ();
		String [] soc = curso.mostrarSocios ();
		for (int i = 0; i < soc.length;i++) {
			sociosN.muestraSocId(soc[i], i + 1);
			sociosJ.muestraSocId(soc[i], i + 1);
			sociosI.muestraSocId(soc[i], i + 1);
		}	
	}
	/*
	 * Case 5 
	 */
	
	void CalqMens () {
		int op = seleccionarSocio();
		int total = 0;
		if (op <= j) {
			Normal soc = sociosN.darSocioN(op);
			total = soc.getTotal();
		}else if (op <= k) {
			Jubilado soc = sociosJ.darSocioJ(op - k + 1);
			total = soc.getTotal();
		}else if (op <= x) {
			Infantil soc = sociosI.darSocioI(op - x + 1);
			total = soc.getTotal();
		}
		System.out.println("El total es: " + total);
		x = 0;
	}
	
	/*
	 * Case 6
	 */
	
	void muestraCursos () {
		cursos.muestraCurs() ;
	}
	
	/*
	 * Case 7
	 */
	
	void MuestrSoc () {
		muestraSoc();
		x = 0;
	}
	
	void muestraSoc () {
		System.out.println("============");
		System.out.println("Normales");
		x = sociosN.muestraSocN (x);
		j = x;
		System.out.println("============");
		System.out.println("Jubilados");
		x = sociosJ.muestraSocJ (x);
		k = x;
		System.out.println("============");
		System.out.println("Infantiles");
		x = sociosI.muestraSocI (x);
	}
	
	/*
	 * Case 8
	 */
	
	
	Infantil onlyInfant () {
		System.out.println("============");
		System.out.println("Infantiles");
		x = sociosI.muestraSocI (x);
		System.out.println("Ingrese el numero de socio: ");
		int op = reader.nextInt();
		Infantil soc = sociosI.darSocioI(op);
		if (!soc.sin_socio()) { soc = null; }
		x = 0;
		return soc;
	}
	
	Normal onlyNorm () {
		System.out.println("============");
		System.out.println("Normales");
		x = sociosN.muestraSocN (x);
		System.out.println("Ingrese el numero de socio: ");
		int op = reader.nextInt();
		Normal soc = sociosN.darSocioN(op);
		x = 0;
		return soc;
	}
	
	void NormldeInf() {
		Infantil inf = onlyInfant();
		if (inf != null) {
			Normal norm = onlyNorm ();
			inf.setSocio_Adl(norm);
			System.out.println ("Se ha designado un socio adulto.");
		} else { System.out.println ("El socio Infantil ya tiene un adulto designado."); }
	}
	
	/*
	 * Case 9
	 */
	
	void DarAdltInf () {
		System.out.println("============");
		System.out.println("Infantiles");
		x = sociosI.muestraSocI (x);
		System.out.println("Ingrese el numero de socio: ");
		int op = reader.nextInt();
		Infantil soc = sociosI.darSocioI(op);
		System.out.println("============");
		System.out.println("Socio");
		soc.darSocAdlt(); 
		x = 0;
	}
}
