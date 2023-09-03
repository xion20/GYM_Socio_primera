package GYM_util;
import GYM.Socio;

public class clsListaArr {
    private Object [] Lst;
	private int tamL;
	private int cant;
	
	
	public clsListaArr (int tm) {
		tamax(tm);
		Lst = new Object [this.tamL];
		this.cant = 0;
	}
	
	private void tamax (int tm) {
		if (tm > 0 && tm <= 400) {
			this.tamL = tm;
		}
		else {
			System.out.println ("error, tamaño invalido.");
			this.tamL = 0;
		}
	}
	
	private boolean vacia () {
		return (cant == 0);
	}
	
	public boolean lleno() {
		return (cant == tamL);
	}

	private int getcant() {
		return cant;
	}

	private Object getElm (int pos) {
		return Lst [pos];
	}
	
	//Insertar elementos

	public void insertarU (Object Elm) {
		if (!lleno()) {
			Lst [this.cant] = Elm;
			cant++;
		}
		else {
			System.out.println ("error, curso lleno");
		}
	}
	
	public void MostrarLst () {
		if (!vacia()) {
			for (int i = 0; i < this.cant; i ++) {
				System.out.println("============");
				System.out.println("Socio N°" + (i + 1));
				Socio soc  = (Socio) Lst [i];
				soc.getDatos();
			}
		}
		else {
			System.out.println ("Error, curso vacio.");
		}
	}
	
	private void elimelm (int ind) {
		for (int j = ind; j < this.cant - 1; j++) {
			Lst [j] = Lst [j + 1];
		}
		Lst [this.cant] = null;
		this.cant --;

	}

	public boolean esta (Object elm) {
		boolean flag = false;
		if (!vacia()) {
			for (int i = 0; i < this.cant; i ++) {
				if (Lst[i] == elm) { flag = true; }
			}
		}
		return flag;
	}
	
}
