package gui;


import java.awt.event.KeyEvent;
import mapa.*;
import misc.Unidad;
import misc.nave;
import Player.jugador;
import enemigos.enemigoAbstract;

public  class Juego {
	private jugador j;
	private static gui frame;
	private Map m;
	private int n;
	private boolean gane=false;
	private boolean habilitado;
	public static void main(String[] args) {
		new Juego();
		
	
}
/**
 * constructor de juego, crea el jugador en nulo crea el mapa y pone la gui visible.	
 */
public Juego(){
		n=1;
		j=new jugador(null,null);
		frame=new gui(this);
		m=new mapa1(frame,this,j);
		frame.setVisible(true);
		j.setMap(m);
		j.initgraph();
		habilitado=true;
   }
   
   
   
  
  /**
   * metodo usado para mover el jugador a partir de un n desde la gui
   * @param dir direccion donde se movera el jugador
   */

public void mover(int dir){
	
   int direccion = 0;
   if(j.getIsRunning()&&habilitado){
	switch (dir){
		case KeyEvent.VK_UP : //Arriba
			direccion = Unidad.ARRIBA;
			break;
		case KeyEvent.VK_LEFT : //Izquierda
			direccion = Unidad.IZQUIERDA;
			break;
		case KeyEvent.VK_DOWN : //Abajo
			direccion = Unidad.ABAJO;
			break;	
		case KeyEvent.VK_RIGHT : //Derecha
			direccion = Unidad.DERECHA;
			break;
		case KeyEvent.VK_SPACE : //Espacio
			direccion= nave.DISPARAR;
			break;
	}
	
	j.mover(direccion);
   }
}
/**
 * metodo usado para aumentar los puntos del jugador
 * @param getpuntos puntos a sumar en el jugador
 */
public void addpuntos(int getpuntos) {
	j.sumarEnemigo(getpuntos);
	
}
/**
 * Metodo usado cuando se gana el juego
 */
public void win() {
		n=n+1;
	if(!gane){	
		if(n==2)
			Mapa2();
	/*	if(n==3)
			MapaBoss();*/
		if(n==3){
			System.out.println("GANASTE n es 3");
			gane=true;
		}
	}
	
}

private void MapaBoss(){
	if(n==3){
		habilitado=false;
		m=null;
		j.setCelda(null);
		j.setMap(null);
		frame.dispose();
		frame=new gui(this);
		m=new mapaBoss(frame,this,j);
		frame.setVisible(true);
		j.setMap(m);
		j.initgraph();
		habilitado=true;
	}
}
private void Mapa2(){
	if(n==2){
	habilitado=false;
	m=null;
	j.setCelda(null);
	j.setMap(null);
	frame.dispose();
	frame=new gui(this);
	m=new mapa2(frame,this,j);
	frame.setVisible(true);
	j.setMap(m);
	j.initgraph();
	habilitado=true;
	}
}

public void gamerover() {
	System.out.println("Perdiste");
	 
}
public int getxy(enemigoAbstract e) {
	int salida=Unidad.ABAJO;
	int x1=j.getcelda().getposx();
	int y1=j.getcelda().getposy();
	int x2=e.getcelda().getposx();
	int y2=e.getcelda().getposy();
	int x=Math.abs(x2-x1);
	int y=Math.abs(y2-y1);
	
	if(x<y){
		salida=Unidad.ABAJO;
	}
	else
		if(x==y && y>=0){
			if(x2>x1)
				salida=Unidad.ABAJOIZQUIERDA;
			else
			if(x1>x2)
				salida=Unidad.ABAJODERECHA;
				
			}
		else
			if(x>y){
				if(x2>x1)
				salida=Unidad.IZQUIERDA;
				else
					salida=Unidad.DERECHA;
			}
			
	return salida;
}




}