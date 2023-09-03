package GYM_util;
import GYM.Socio;
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
	public void insertaFin(Object objElemento){
		if (!estaVacia()){
			this.lista.setNextNode(new clsNode(objElemento));
			this.lista=this.lista.getNextNode();
		}else{
			this.tope = this.lista=new clsNode(objElemento);			
		}
	}	

	// elimina elemento ubicado m�s a la derecha
	void eliminaFin(){
		if (!estaVacia()){
			if (this.lista == this.tope){
				// un solo elemento
				limpiaLista();
			}else{
				clsNode temp;
				for (temp=this.tope;temp.getNextNode()!=lista;temp=temp.getNextNode());
				this.lista=temp;
				this.lista.setNextNode(null);			
			}
		}else{
			System.out.println("Error eliminaFin. Lista vacia");			
		}
	}		

	
	// inserta elemento a la izq
	public void insertaTope(Object objElemento){
		if (!estaVacia()){
			this.tope = new clsNode(objElemento,this.tope);		
		}else{
			this.tope = this.lista=new clsNode(objElemento);			
		}
	}	

	
	// elimina elemento ubicado m�s a la izq
	void eliminaTope(){
		if (!estaVacia()){
			if (this.lista==this.tope){
				// un solo elemento
				limpiaLista();
			}else{
				this.tope=this.tope.getNextNode();			
			}
		}else{
			System.out.println("Error eliminaTope. Lista vacia");			
		}
	}	
	
	
	public void muestraSoc(){
		clsNode temp;
		int i = 0;
		if (!estaVacia()){
			temp = this.tope;
			while (temp!=null){
				Socio soc =(Socio)temp.getNodeInfo();
				i++;
				System.out.println("============");
				System.out.println("Socio N°" + i);
				soc.getDatos();
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
			System.out.println("Error muestra. Lista vacia");
		}		
	}
	
	clsNode getTope(){return tope;}
	
	public Socio darSocio (int numero) {
		clsNode temp = this.tope;
		int i = 1;
		Socio socio = null;
		while (temp!=null){
			if (i == numero) {
				socio = (Socio) temp.getNodeInfo();
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
	
	void Desplazar (char Sentido, int Cant) {
		if (!estaVacia()) {
			if (Sentido == 'D') {
				for (int i = 0; i < Cant; i++) {
					this.insertaTope(null);
				}
			}else {
				for (int i = 0; i < Cant; i++) {
					this.insertaFin(null);
				}
			}
		}
		else {
			System.out.println("Error muestra. Lista vacia");
		}
	}
	
	

}
