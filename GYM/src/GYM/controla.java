package GYM;

public class controla {
	
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

}
