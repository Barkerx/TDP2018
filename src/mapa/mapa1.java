package mapa;

import java.io.File;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import disparo.DisparoMobiler;
import enemigos.EnemyMobiler;
import enemigos.enemigo;
import enemigos.enemigoAbstract;
import gui.Juego;
import gui.gui;
import jaco.mp3.player.MP3Player;

public class mapa1 extends Map{

	protected int horda;
public mapa1(gui gu,Juego ju,jugador p){
		int x=20;
		int y=15;
		horda=0;
		g=gu;
		//inicializo la matriz de celdas
		celdas=new celda[x][y];
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
				celdas[i][j]=new celda(i,j,this);
		
		//agrego el personaje a la posicion 5 5
		p.setCelda(celdas[10][14]);
		celdas[10][14].setelem(p.getProfundidad(), p);
		//creo la lista de enemigos 
		lEnemy=new LinkedList<enemigoAbstract>();
		//linkeo la libreria mp3 al archivo
		cancion=new MP3Player(this.getClass().getResource("/resources/mapa1.mp3"));
		//Inicializo 
		g.setResizable(false);
		fondo=new JLabel(new ImageIcon(this.getClass().getResource("/resources/fondo.png")));
   	 	fondo.setBounds(0, 0, 900, 675);
   	 	g.add(fondo,new Integer(0));
   	 	this.j=ju;	    
   	 	m=new EnemyMobiler(this);
	    //regalo un PowerUp al jugador al comenzar.
	    t1=new Thread(this);
	    t1.start();
	    
	}
public void crearEnemigos(){
	//creo enemigos
	if(!gane){
		if(horda<2){
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
			horda=horda+1;
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
	int intAleatorio = aleatorio.nextInt(2);
	crearpowerUP(celdas[10][5],intAleatorio);
	j.habilitado();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	crearObstaculo();
	crearEnemigos();
	m.play();
	}
	
}
   