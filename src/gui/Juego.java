package gui;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import mapa.*;
import misc.Unidad;
import Player.jugador;

public  class Juego {
	private jugador j;
	private static gui frame;

	public static void main(String[] args) {
		new Juego();
		
	
}
	
public Juego(){
	   j=new jugador(null,null);
	   frame=new gui(this);
	   new Map(frame,this,j);
	   frame.setVisible(true);
   }
   
   
   
  
  

public void mover(int dir){
   int direccion = 0;
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
			direccion=-1;
			break;
	}
	j.mover(direccion);
}


}