package mapa;

import javax.swing.JLabel;

import misc.Gob;

public class celda {
	protected Gob objects[];
	protected int x,y;
	public celda(int x,int y){
		this.x=x;
		this.y=y;
		objects= new Gob[4];
		objects[0]=null;
		objects[1]=null;
		objects[2]=null;
		objects[3]=null;
	}
	
	public Gob[] objlist(){
		return objects;
	}
	
	public void setelem(int n, Gob o){
		objects[n]=o;
	}
	public int getposx(){
		return x;	
	}
	public int getposy(){
		return y;	
	}

	public void repaint() {
		// TODO Auto-generated method stub
		
	}

}
