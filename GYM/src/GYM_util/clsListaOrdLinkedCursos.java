package GYM_util;
import GYM.Curso;

public class clsListaOrdLinkedCursos extends clsListaOrdLinkedL{
	public boolean esMenor(String idA, String idB){
		boolean response = false;
		if (idA.compareToIgnoreCase(idB)<0){
			response=true;
		}
		return response;
	}
	public boolean esMayor(String idA, String idB){
		boolean response=false;
		if (idA.compareToIgnoreCase(idB)>0){
			response=true;
		}	
		return response;
	}
	public boolean iguales(String idA, String idB){
		boolean response=false;
		if (idA == idB){
			response=true;
		}
		return response;
	}
	
	/*
	 * public void muestra(){
		clsNodeCurso temp;		
		if (!estaVacia()){
			int i = 0;
			temp=this.lista;
			while (temp!=null){
				Curso curs =(Curso) temp.getNodeid();
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
	 */

	public int getcontador() { 
		return this.contador;
	}
	
	public int total () {
		clsNodeCurso temp;
		int total = 0;
		if (!estaVacia()){
			temp = this.lista;
			while (temp != null){
				total = total + temp.getNodePrecio();
				temp=temp.getNextNode();
			}
		}else{
			System.out.println("Error total. Lista vacia");
		}
		return total;
	}
	
}
