package GYM_util;
import GYM.Curso;

public class clsListaOrdLinkedCursos extends clsListaOrdLinkedL{
	public boolean esMenor(Object objA, Object objB){
		boolean response=false;
		Curso curs1 = (Curso)objA;
		Curso curs2 =(Curso)objB;
		if (curs1.getCodigo().compareToIgnoreCase(curs2.getCodigo())<0){
			response=true;
		}
		return response;
	}
	public boolean esMayor(Object objA, Object objB){
		boolean response=false;
		Curso curs1 = (Curso)objA;
		Curso curs2 =(Curso)objB;
		if (curs1.getCodigo().compareToIgnoreCase(curs2.getCodigo())>0){
			response=true;
		}	
		return response;
	}
	public boolean iguales(Object objA, Object objB){
		boolean response=false;
		Curso curs1 = (Curso)objA;
		Curso curs2 =(Curso)objB;
		if (curs1.getCodigo()== curs2.getCodigo()){
			response=true;
		}
		return response;
	}
	
	public void muestra(){
		clsNode temp;		
		if (!estaVacia()){
			int i = 0;
			temp=this.lista;
			while (temp!=null){
				Curso curs =(Curso)temp.getNodeInfo();
				i++;
				System.out.println("============");
				System.out.println("Curso N°" + i);
				curs.muestra();
				temp=temp.getNextNode();
			}
			System.out.println("============");
		}else{
			System.out.println("Error muestra. Lista vacia");
		}		
	}
	
	public int getcontador() { 
		return this.contador;
	}
	
	public int total () {
		clsNode temp;
		int total = 0;
		if (!estaVacia()){
			temp = this.lista;
			while (temp != null){
				Curso curs = (Curso)temp.getNodeInfo();
				total = total + curs.getPrecio();
				temp=temp.getNextNode();
			}
			;
		}else{
			System.out.println("Error total. Lista vacia");
		}
		return total;
	}
	
}
