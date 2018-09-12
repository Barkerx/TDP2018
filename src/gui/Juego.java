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
import Player.jugador;

public  class Juego {
	private jugador j;
	private static gui frame;

	public static void main(String[] args) {
		new Juego();
		
	
}
	
public Juego(){
	   j=new jugador(null); 
	   frame=new gui(this);
	   new Map(frame,this,j);
	   frame.setVisible(true);
   }
   
   
   
  
  

public void mover(int dir){
   int direccion = 0;
	switch (dir){
		case KeyEvent.VK_UP : //Arriba
			direccion = 4;
			break;
		case KeyEvent.VK_LEFT : //Izquierda
			direccion = 2;
			break;
		case KeyEvent.VK_DOWN : //Abajo
			direccion = 0;
			break;	
		case KeyEvent.VK_RIGHT : //Derecha
			direccion = 6;
			break;
		case KeyEvent.VK_SPACE : //Espacio
			direccion=-1;
			break;
	}
	j.mover(direccion);
}


}