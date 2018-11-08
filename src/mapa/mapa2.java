package mapa;

import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import disparo.DisparoMobiler;
import enemigos.EnemyMobiler;
import enemigos.enemigoAbstract;
import gui.Juego;
import gui.gui;
import jaco.mp3.player.MP3Player;

public class mapa2 extends Mapa{

	public mapa2(gui gu,Juego ju,jugador p){
		horda=4;
		inicializoCeldas();
		//agrego el personaje a la posicion 5 5
		p.setCelda(celdas[10][14]);
		celdas[10][14].setelem(p.getProfundidad(), p);
		//creo la lista de enemigos 
		lEnemy=new LinkedList<enemigoAbstract>();
		//linkeo la libreria mp3 al archivo
		cancion=new MP3Player(this.getClass().getResource("/resources/mapa2.mp3"));
		//Inicializo gui
		fondo=new JLabel(new ImageIcon(this.getClass().getResource("/resources/fondo2.png")));
   	 	fondo.setBounds(0, 0, 900, 675);
   	 	inicializoGui(gu,ju);
   	 	//creo el mobiler de enemigos y de disparos, el pool de grafica
   	 	dp=new Pool();
   	 	m=new EnemyMobiler(this);
   	 	d=new DisparoMobiler(this);
   	 	
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
	public void run() {
		initSound();
		Random aleatorio = new Random(System.currentTimeMillis());
		int intAleatorio = aleatorio.nextInt(4);
		crearpowerUP(celdas[10][5],intAleatorio);	
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
	public Mapa nextMap(jugador ju,gui gu) {
		// TODO Auto-generated method stub
		return new mapaBoss(gu,j,ju);
	}
	
}
