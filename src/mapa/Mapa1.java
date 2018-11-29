package mapa;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import gui.Juego;
import gui.Gui;
import jaco.mp3.player.MP3Player;
import nave.player.Jugador;

public class Mapa1 extends Mapa{

	protected int horda;
public Mapa1(Gui gu,Juego ju,Jugador p){
		horda=4;
		inicializoCeldas();
		//agrego el personaje a la posicion 5 5
		p.setCelda(celdas[10][14]);
		celdas[10][14].setelem(p.getProfundidad(), p);
		//linkeo la libreria mp3 al archivo
		cancion=new MP3Player(this.getClass().getResource("/resources/mapa1.mp3"));
		//Inicializo gui
		fondo=new JLabel(new ImageIcon(this.getClass().getResource("/resources/fondo.png")));
   	 	fondo.setBounds(0, 0, 900, 675);
   	 	inicializoGui(gu,ju);
   	 	initMap();
	    //regalo un PowerUp al jugador al comenzar.
   	 	new Thread(this);
   	 	this.start();
	}



public void crearEnemigos(){
	//creo enemigos
	if(!gane){
		if(horda>0){
			int act=0;
			while(act<8){
				Random r=new Random();
				int x=r.nextInt(18)+2;
				int y=r.nextInt(3)+1;
				if(celdas[x][y].objlist()[1]==null&&celdas[x][y].objlist()[0]==null)
				{
					crearEnemigo(celdas[x][y]);
					act=act+1;
				}
				
			}
			horda=horda-1;
		}
		else
			gane=true;
	if(gane)
		gane();
		
	}
}


	@Override
	public void run(){
	initSound();
	Random aleatorio = new Random(System.currentTimeMillis());
	int intAleatorio = aleatorio.nextInt(4);
	crearpowerUP(celdas[10][5],intAleatorio);
	//d.play();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	j.habilitado();
	crearObstaculo();
	crearEnemigos();
	m.play();
	this.interrupt();
	}



	@Override
	public Mapa nextMap(Jugador ju,Gui gu) {
		return  new Mapa2(gu,j,ju);
	}
}
   