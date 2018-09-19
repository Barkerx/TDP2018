package mapa;

import misc.Gob;

public class celda {
	protected Gob objects[];
	protected int x,y;
	/**
	 * Crea una celda con todos sus elementos en nulo
	 * @param x posicion x de la celda
	 * @param y posicion y de la celda
	 */
	public celda(int x,int y){
		this.x=x;
		this.y=y;
		objects= new Gob[4];
		objects[0]=null;
		objects[1]=null;
		objects[2]=null;
		objects[3]=null;
	}
	/**
	 * consulta que retorna la colecion de objetos dentro de la celda
	 * @return colecion de objetos dentro de la celda.
	 */
	public Gob[] objlist(){
		return objects;
	}
	/**
	 * set en la profundidad n el objeto O en la coleccion de objetos.
	 * @param n profundidad del objeto
	 * @param o objeto
	 */
	public void setelem(int n, Gob o){
		objects[n]=o;
	}
	/**
	 * consulta para obtener coordenada x de la celda.
	 * @return x de la celda
	 */
	public int getposx(){
		return x;	
	}
	/**
	 * consulta para obtener la coordenada y de la celda
	 * @return y de la celda
	 */
	public int getposy(){
		return y;	
	}


}
