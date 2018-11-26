package gui;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import mapa.*;
import misc.Unidad;
import player.Jugador;

public  class Juego {
	private Jugador j;
	private static Gui frame;
	private Mapa m;
	private boolean habilitado=false;
	public static void main(String[] args) {
		new Juego();
	
}
/**
 * constructor de juego, crea el jugador en nulo crea el mapa y pone la gui visible.	
 */
public Juego(){
		j=new Jugador(null,null);
		frame=new Gui(this);
		m=new Mapa1(frame,this,j);
		frame.setVisible(true);
		j.setMap(m);
		j.initgraph(true);
   }
   
   
   
  
  /**
   * metodo usado para mover el jugador a partir de un n desde la gui
   * @param dir direccion donde se movera el jugador
   */

public void mover(int dir){
	
   int direccion = -1;
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
			j.disparar();
			break;
		default:break;	
	}
	if(direccion!=-1)
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
	frame=new Gui(this);
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
			j.initgraph(true);
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
/**
 * Metodo usado para habilitar el input(es usado por la gui)
 */
public void habilitado(){
	habilitado=true;
}
/**
 * Metodo usado para deshabilitar el input(es usado por la gui)
 */
public void deshabilitado(){
	habilitado=false;
}
/**
 * Metodo usado para consultar si el input esta habilitado
 * @return True en caso de que el input este habilitado, false en caso contrario
 */
public boolean puedo() {
	return habilitado;
}

public Jugador getJugador(){
	return j;
}

}