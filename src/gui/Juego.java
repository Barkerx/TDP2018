package gui;

import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.*;
import misc.Unidad;
import misc.nave;
import Player.jugador;

public  class Juego {
	private jugador j;
	private static gui frame;
	private Mapa m;
	private int n;
	private boolean gane=false;
	private boolean habilitado=false;
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
	j.sumarPuntaje(getpuntos);
	
}
/**
 * Metodo usado cuando se gana el juego
 */
public void win() {
	frame.enableInputMethods(false);
	j.setCelda(null);
	j.setMap(null);
	j.changeRunning();
	frame.dispose();
	frame=new gui(this);
	frame.enableInputMethods(false);
	Mapa m2=m.nextMap(j,frame);
	frame.setVisible(true);
	if(m2==null){
		System.out.println("Ganaste");
		JLabel stat =new JLabel(new ImageIcon(this.getClass().getResource("/resources/winimage.jpg")));
		stat.setBounds(0, 0, 900, 675);
		frame.add(stat, new Integer(1));
		//hacer un frame de perdiste.
		habilitado=false;
		}
		else{
			m=null;
			m=m2;
			frame.setVisible(true);
			j.setMap(m);
			j.initgraph();
			frame.enableInputMethods(true);
			j.changeRunning();
		}
}

public void gamerover() {
	System.out.println("Perdiste");
	JLabel stat =new JLabel(new ImageIcon(this.getClass().getResource("/resources/gamerover.png")));
	stat.setBounds(0, 0, 900, 675);
	frame.add(stat, new Integer(1));
	habilitado=false; 
}

public void habilitado(){
	habilitado=true;
}
public void deshabilitado(){
	habilitado=false;
}
public boolean puedo() {
	return habilitado;
}
public jugador getJugador(){
	return j;
}


}