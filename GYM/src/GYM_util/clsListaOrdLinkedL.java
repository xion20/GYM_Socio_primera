package GYM_util;

public abstract class clsListaOrdLinkedL{
	protected clsNodeCurso lista;
	protected int contador;
	
	public clsListaOrdLinkedL(){
		limpiarLista();
		this.contador=0;
	}
	
	public boolean estaVacia(){
		return (this.lista==null);
	}
	

	public void limpiarLista(){
		this.lista=null;;
	}
	
	public abstract boolean esMenor(String idA, String idB);
	public abstract boolean esMayor(String idA, String idB);
	public abstract boolean iguales(String idA, String idB);
	
	public String devuelveId (int posicion){
		int counter = 0;
		clsNodeCurso temp;
		temp = this.lista;
		String elemento = null;
		if (posicion >= 0 && posicion < this.contador){			
			while (counter < posicion){
				temp = temp.getNextNode();
				counter ++;
			}
			elemento = temp.getNodeid();

		}else{
			System.out.println("-");
		}		
		return elemento;
	}
	
	public void inserta (String id, int precio){
		clsNodeCurso node;
		node = new clsNodeCurso (id, precio);
		this.contador++;
		if (estaVacia()){
			this.lista = node;
		} else{
			if (esMenor(id, this.lista.getNodeid())){
				node.setNextNode(this.lista);
				this.lista=node;
			} else{
				clsNodeCurso temp = this.lista;
				boolean flag = false;
				while (temp.getNextNode()!=null && !flag){
					if (esMayor(id,temp.getNextNode().getNodeid())){
						temp = temp.getNextNode();
					}else{
						flag = true;
					}
				}
				node.setNextNode(temp.getNextNode());
				temp.setNextNode(node);				
			}
		}
	}	
	
	
	public boolean esta(String id){
		boolean response = false;
		if (estaVacia()){
			System.out.println("Error esta. lista vacia");			
		} else{
			clsNodeCurso temp = this.lista;
			while (temp!=null && !response){
				if (iguales(id, temp.getNodeid())){
					response=true;
				}else{
					temp=temp.getNextNode();
				}
			}
		}		
		return response;
	}	
	
	public String [] getIds() {
		String [] ids = new String [this.contador];
		if (estaVacia()){
			System.out.println("Error esta. lista vacia");			
		} else{
			int i = 0;
			clsNodeCurso temp = this.lista;
			while (temp != null) {
				ids [i] = temp.getNodeid();
				i++;
				temp = temp.getNextNode();
			}		
		}
		return ids;
	}
	

	public void elimina(String id){
		clsNodeCurso temp, ant;
		boolean flag=false;
		
		if (estaVacia()){
			System.out.println("Error elimina. lista vacia");
		}else{
						
			if (!esta(id)){
				System.out.println("Error elimina. no esta elemento");
			}else{
				
				this.contador--;
				if (iguales(id,this.lista.getNodeid())){
					this.lista=this.lista.getNextNode();
				}else{				
					ant = this.lista;
					temp = this.lista.getNextNode();

					while (temp!=null && !flag){
						if (iguales(id,this.lista.getNodeid())){
							flag=true;
						}else{
							ant=temp;
							temp=temp.getNextNode();
						}
					}									
					
					if (flag){
						ant.setNextNode(temp.getNextNode());							
						
					}					
				}		
				
			}
		}	
	}

	
}
