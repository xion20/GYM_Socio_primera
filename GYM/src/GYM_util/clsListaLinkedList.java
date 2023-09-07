package GYM_util;
import GYM.Socio;
import GYM.Normal;
import GYM.Jubilado;
import GYM.Infantil;
import GYM.Curso;

public class clsListaLinkedList {
	private clsNode tope, lista;
	
	public clsListaLinkedList(){
		limpiaLista();
	}
	
	boolean estaVacia(){
		return (lista == null);
	}
	

	void limpiaLista(){
		this.tope = this.lista = null;;
	}
	
	
	// inserta elemento a la derecha
	public void inserta(Object objElemento){
		if (!estaVacia()){
			this.lista.setNextNode(new clsNode(objElemento));
			this.lista=this.lista.getNextNode();
		}else{
			this.tope = this.lista=new clsNode(objElemento);			
		}
	}	
	
	
	public int muestraSocN(int i){
		clsNode temp;
		if (!estaVacia()){
			temp = this.tope;
			while (temp!=null){
				Normal soc =(Normal)temp.getNodeInfo();
				i++;
				System.out.println("============");
				System.out.println("Socio N°" + i);
				soc.getDatos();
				temp=temp.getNextNode();
			}			
		}else{
			System.out.println("aun no hay socios Normales");
		}return i;		
	}
	
	public int muestraSocJ(int i){
		clsNode temp;
		if (!estaVacia()){
			temp = this.tope;
			while (temp!=null){
				Jubilado soc =(Jubilado)temp.getNodeInfo();
				i++;
				System.out.println("============");
				System.out.println("Socio N°" + i);
				soc.getDatos();
				temp=temp.getNextNode();
			}			
		}else{
			System.out.println("aun no hay socios Jubilados");
		}return i;		
	}
	
	public int muestraSocI(int i){
		clsNode temp;
		if (!estaVacia()){
			temp = this.tope;
			while (temp!=null){
				Infantil soc =(Infantil)temp.getNodeInfo();
				i++;
				System.out.println("============");
				System.out.println("Socio N°" + i);
				soc.getDatos();
				temp=temp.getNextNode();
			}			
		}else{
			System.out.println("aun no hay socios Infantiles");
		}return i;		
	}
	
	public void muestraSocId (String id, int i){
		clsNode temp;
		if (!estaVacia()){
			boolean response = false;
			temp = this.tope;
			while (temp!=null && !response){
				Socio soc = (Socio)temp.getNodeInfo();
				if (soc.getId() == id) {
					System.out.println("============");
					System.out.println("Socio N°" + i);
					soc.getDatos();
					response = true;
				}
				temp=temp.getNextNode();
			}			
		}else{
			System.out.println("Error muestra. Lista vacia");
		}		
	}
	
	public void muestraCurs(){
		clsNode temp;
		int i = 0;
		if (!estaVacia()){
			temp = this.tope;
			while (temp!=null){
				Curso curs = (Curso) temp.getNodeInfo();
				i++;
				System.out.println("============");
				System.out.println("Curso N°" + i);
				curs.muestra();
				temp=temp.getNextNode();
			}			
		}else{
			System.out.println("Aun no se han agregado cursos.");
		}		
	}
	
	public void muestraCursId(String id, int i){
		clsNode temp;
		if (!estaVacia()){
			boolean response = false;
			temp = this.tope;
			while (temp!=null && !response){
				Curso curs = (Curso) temp.getNodeInfo();
				if (curs.getCodigo() == id) {
					System.out.println("============");
					System.out.println("Curso N°" + i);
					curs.muestra();
					response = true;
				}
				temp=temp.getNextNode();
			}			
		}else{
			System.out.println("Error muestra. Lista vacia");
		}		
	}
	
	clsNode getTope(){return tope;}
	
	public Normal darSocioN (int numero) {
		clsNode temp = this.tope;
		int i = 1;
		Normal socio = null;
		while (temp!=null){
			if (i == numero) {
				socio = (Normal) temp.getNodeInfo();
			} 
			temp = temp.getNextNode();
		} return socio;
	}
	
	public Jubilado darSocioJ (int numero) {
		clsNode temp = this.tope;
		int i = 1;
		Jubilado socio = null;
		while (temp!=null){
			if (i == numero) {
				socio = (Jubilado) temp.getNodeInfo();
			} 
			temp = temp.getNextNode();
		} return socio;
	}
	
	public Infantil darSocioI (int numero) {
		clsNode temp = this.tope;
		int i = 1;
		Infantil socio = null;
		while (temp!=null){
			if (i == numero) {
				socio = (Infantil) temp.getNodeInfo();
			} 
			temp = temp.getNextNode();
		} return socio;
	}
	
	public Curso darCurso (int numero) {
		Curso x = null;
		clsNode temp = this.tope;
		int i = 1;
		while (temp!=null){
			if (i == numero) {
				x = (Curso) temp.getNodeInfo();
				break;
			}
			temp = temp.getNextNode();
		}
		return x;
	}

}
