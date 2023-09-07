package GYM_util;

public class clsNodeCurso {
	private String id;
	private int precio;
	private clsNodeCurso nextNode;

	//Sobrecarga----------
	clsNodeCurso(String id, int precio){
		this(id,precio,null);
	}

	clsNodeCurso(String id, int precio, clsNodeCurso nextNode){
		this.id = id;
		this.precio = precio;
		this.nextNode=nextNode;
	}
	
	//  --------------
	
	void setNodeInfo(String id, int precio){
		this.id = id;
		this.precio = precio;
	}
	
	void setNextNode(clsNodeCurso nextNode){
		this.nextNode=nextNode;
	}
	
	String getNodeid(){
		return this.id;
	}
	
	int getNodePrecio(){
		return this.precio;
	}
	
	clsNodeCurso getNextNode(){
		return this.nextNode;
	}

}
