package mapa;

import java.io.File;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import enemigos.Boss;
import enemigos.FinalBOSS;
import enemigos.enemigoAbstract;
import gui.Juego;
import gui.gui;
import jaco.mp3.player.MP3Player;
import misc.Unidad;

public class mapaBoss extends Map{
	private int vida;
	private LinkedList<FinalBOSS> lEnemyBOSS;
	private JLabel boss;
	public mapaBoss(gui gu,Juego ju,jugador p){
		int x=20;
		int y=15;
		g=gu;
		//inicializo la matriz de celdas
		celdas=new celda[x][y];
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
				celdas[i][j]=new celda(i,j,this);
		
		//agrego el personaje a la posicion 5 5
		p.setCelda(celdas[10][14]);
		celdas[10][14].setelem(p.getProfundidad(), p);
		//linkeo la libreria mp3 al archivo
	    cancion=new MP3Player(this.getClass().getResource("/resources/Boss.mp3"));
		//creo la lista de enemigos y la vida del BOSS 
		lEnemy=new LinkedList<enemigoAbstract>();
		vida=3000;
		lEnemyBOSS=new LinkedList<FinalBOSS>();
		//Inicializo 
		g.setResizable(false);
		fondo=new JLabel(new ImageIcon(this.getClass().getResource("/resources/fondoBOSS.png")));
   	 	fondo.setBounds(0, 0, 900, 675);
   	 	g.add(fondo,new Integer(0));
   	 	this.j=ju;
	    //regalo un PowerUp al jugador al comenzar.
	    t1=new Thread(this);
	    t1.start();
	}
	
	@Override
	public void run() {

		Random aleatorio = new Random();
		int intAleatorio = aleatorio.nextInt(2);
		crearpowerUP(celdas[5][5],intAleatorio);
		int a = aleatorio.nextInt(2);
		crearpowerUP(celdas[4][4],a);
		int b = aleatorio.nextInt(2);
		crearpowerUP(celdas[6][6],b);
		initSound();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CrearBOSS();
		crearEnemigos();
		while(gane){
			
		}
		
		
	}

	@Override
	protected void crearEnemigos() {
		if(!gane){
		enemigoAbstract e=new Boss(celdas[1][2], this, j);
		lEnemy.add(e);
		enemigoAbstract e2=new Boss(celdas[2][3], this, j);
		lEnemy.add(e2);
		enemigoAbstract e3=new Boss(celdas[18][3], this, j);
		lEnemy.add(e3);
		enemigoAbstract e4=new Boss(celdas[19][2], this, j);
		lEnemy.add(e4);
		}
	}
	
	public void reducirVida(int n) {
		vida=vida-n;
		if(vida<0&&!gane){
			gane=true;
			eliminarBoss();
		}
	}

	public void addgraph(JLabel grafico) {
		fondo.add(grafico,new Integer(2));  
		fondo.repaint();
	}
	
	private void CrearBOSS(){
		boss=new JLabel(new ImageIcon(this.getClass().getResource("/resources/BOSS.png")));
	    boss.setBounds(130, 0, 600, 264);
	    addgraph(boss,1);
	    
	    FinalBOSS b=new FinalBOSS(celdas[3][2],this,Unidad.IZQUIERDA);
	    lEnemyBOSS.add(b);
	    FinalBOSS b0=new FinalBOSS(celdas[4][3],this,Unidad.ABAJOIZQUIERDA);
	    lEnemyBOSS.add(b0);
	    FinalBOSS b1=new FinalBOSS(celdas[4][4],this,Unidad.ABAJO);
	    lEnemyBOSS.add(b1);
	    FinalBOSS b2=new FinalBOSS(celdas[5][4],this,Unidad.ABAJO);
	    lEnemyBOSS.add(b2);
	    FinalBOSS b3=new FinalBOSS(celdas[6][5],this,Unidad.ABAJO);
	    lEnemyBOSS.add(b3);
	    FinalBOSS b4=new FinalBOSS(celdas[7][4],this,Unidad.ABAJO);
	    lEnemyBOSS.add(b4);
	    FinalBOSS b5=new FinalBOSS(celdas[8][4],this,Unidad.ABAJO);
	    lEnemyBOSS.add(b5);
	    FinalBOSS b6=new FinalBOSS(celdas[9][4],this,Unidad.ABAJO);
	    lEnemyBOSS.add(b6);
	    FinalBOSS b7=new FinalBOSS(celdas[10][4],this,Unidad.ABAJO);
	    lEnemyBOSS.add(b7);
	    FinalBOSS b9=new FinalBOSS(celdas[11][3],this,Unidad.ABAJO);
	    lEnemyBOSS.add(b9);
	    FinalBOSS b8=new FinalBOSS(celdas[12][3],this,Unidad.ABAJO);
	    lEnemyBOSS.add(b8);
	    FinalBOSS b10=new FinalBOSS(celdas[13][3],this,Unidad.ABAJO);
	    lEnemyBOSS.add(b10);
	    FinalBOSS b11=new FinalBOSS(celdas[14][3],this,Unidad.ABAJODERECHA);
	    lEnemyBOSS.add(b11);
	    FinalBOSS b12=new FinalBOSS(celdas[15][2],this,Unidad.DERECHA);
	    lEnemyBOSS.add(b12);
	
		
	}
	private void eliminarBoss(){
			LinkedList<enemigoAbstract> aux=new LinkedList<enemigoAbstract>();
			for(enemigoAbstract e:lEnemy)
			{	
				aux.add(e);
			}	
			for(enemigoAbstract ea:aux)
			{	
				lEnemy.remove(ea);
				ea.destruir();
			}
			LinkedList<FinalBOSS> aux2=new LinkedList<FinalBOSS>();
			for(FinalBOSS eb:lEnemyBOSS)
			{	
				aux2.add(eb);
				eb.kill();
			}
			try {
				Thread.sleep(5500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(FinalBOSS eba:aux2){
				lEnemyBOSS.remove(eba);
				eba.destruir();
			}
			
			boss.setIcon(null);
			addgraph(boss,1);
			stopSound();
			j.win();
		
	}
}
