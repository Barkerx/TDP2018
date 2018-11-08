package mapa;

import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import disparo.DisparoMobiler;
import enemigos.Boss;
import enemigos.EnemyMobiler;
import enemigos.FinalBOSS;
import enemigos.enemigoAbstract;
import gui.Juego;
import gui.gui;
import jaco.mp3.player.MP3Player;

public class mapaBoss extends Mapa{
	private int vida;
	private LinkedList<FinalBOSS> lEnemyBOSS;
	private JLabel boss;
	private jugador s;
	public mapaBoss(gui gu,Juego ju,jugador p){
		horda=0;
		int x=20;
		int y=15;
		g=gu;
		s=p;
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
   	 	m=new EnemyMobiler(this);
   	 	dp=new Pool();
   	 	d=new DisparoMobiler(this);
	    //regalo un PowerUp al jugador al comenzar.
	    new Thread(this);
	    this.start();
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
		j.habilitado();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CrearBOSS();
		crearEnemigos();
		m.play();
		
	}

	@Override
	protected void crearEnemigos() {
		if(!gane){
		crearEnemigo(celdas[1][2]);
		crearEnemigo(celdas[2][3]);
		crearEnemigo(celdas[18][3]);
		crearEnemigo(celdas[19][2]);
		}
	}
	protected void crearEnemigo(celda c){
		enemigoAbstract e=new Boss(c,this,j);
		lEnemy.add(e);
		m.addEnemy(e);
	}
	protected FinalBOSS crearEnemigoBOSS(celda c,JLabel l){
		enemigoAbstract e=new FinalBOSS(c,this,s,l);
		lEnemy.add(e);
		if(l!=null)
			m.addEnemy(e);
		return (FinalBOSS)e;
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
		boss=new JLabel(new ImageIcon(this.getClass().getResource("/resources/leviathan.png")));
	    boss.setBounds(0, 0, 170, 260);
	    FinalBOSS e1=crearEnemigoBOSS(celdas[8][2],null);
	    FinalBOSS e2=crearEnemigoBOSS(celdas[10][2],null);
	    FinalBOSS e3=crearEnemigoBOSS(celdas[9][4],boss);
	    e3.setPartner(e2);
	    e3.setPartner(e1);
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
			// 	eb.explotar();	
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

	@Override
	public Mapa nextMap(jugador j,gui gu) {
		// TODO Auto-generated method stub
		return null;
	}

}
