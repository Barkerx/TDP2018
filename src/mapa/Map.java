package mapa;

import java.util.LinkedList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import Player.jugador;
import PowerUP.*;
import enemigos.EnemyMobiler;
import enemigos.enemigo;
import enemigos.enemigoAbstract;
import gui.Juego;
import gui.gui;
import misc.Unidad;
import jaco.mp3.player.MP3Player;
import obstaculos.*;
public abstract class Map extends Thread {
	protected celda[][] celdas; 
	protected gui g;
	protected MP3Player cancion;
	protected Thread t1;
	private boolean creandoPW=false;
	protected JLabel fondo;
//	protected FormaDeAtacar[] EIA;
	protected LinkedList<enemigoAbstract> lEnemy;
	protected Juego j;
	protected int horda;
	protected boolean gane =false;
	protected EnemyMobiler m;
	/**
	 * Metodo que a partir de una celda C y una direccion dir retorna la celda que esta al lado de C
	 * @param celda celda de origen
	 * @param dir direccion a la cual se desea mover
	 * @return La celda a moverse, si es una celda permitida, null si es invalida.
	 */
	public celda mover(celda celda, int dir) {
		// TODO Auto-generated method stub
		celda c;
		int x=celda.getposx();
		int y=celda.getposy();
		switch (dir){
		case Unidad.ABAJO:y=y+1; break;
		case Unidad.ABAJOIZQUIERDA:x=x-1;y=y+1; break;
		case Unidad.IZQUIERDA:x=x-1; break;
	//	case 3:x=x-1;y=y-1; break;
		case Unidad.ARRIBA:y=y-1; break;
//		case 5:x=x+1;y=y-1; break;
		case Unidad.DERECHA:x=x+1;break;
		case Unidad.ABAJODERECHA:x=x+1;y=y+1; break;
		}
		if(x==celdas.length || y==celdas[0].length || y<0 || x<0 )	
			c=celda;
			else
				c=celdas[x][y];
		return c;
	}
	/**
	 * Agrega al mapa el JLabel grafico  
	 * @param grafico Jlabel que se agregara al mapa
	 */
	public void addgraph(JLabel grafico,int n) {
		g.add(grafico,new Integer(n));  
		g.repaint();
	}
	public void addgraph(JLabel grafico) {
		fondo.add(grafico,new Integer(1));  
		fondo.repaint();
	}
	/**
	 * Separa el enemigo del mapa, asi ya no hay mas relacion entre ellos, es usado al eliminar un enemigo.
	 * @param enemigoAbstract enemigo al que se desea separar del mapa.
	 */
	public void desligar(enemigoAbstract enemigoAbstract) {
		
		lEnemy.remove(enemigoAbstract);
		j.addpuntos(enemigoAbstract.getpuntos());
		m.killEnemy(enemigoAbstract);
		if(!creandoPW){
		celda c=celdas[enemigoAbstract.getcelda().getposx()][enemigoAbstract.getcelda().getposy()];
		Random aleatorio = new Random(System.currentTimeMillis());
		int intAleatorio = aleatorio.nextInt(7);
		int haypowerUp = aleatorio.nextInt(11)+1;
		
		if(haypowerUp%4==0){
			creandoPW=true;
			crearpowerUP(c,intAleatorio);
			}
		}
		if(lEnemy.size()==0)
			crearEnemigos();
		
	}
	/**
	 * metodo usado para crear powerUps de forma aleatoria al eliminar un enemigo
	 * @param c celda a la cual se creara el powerUP
	 * @param n n a partir del cual se creara un powerUP
	 */
	
	protected void crearpowerUP(celda c,int n) {
		powerUp po;
		switch (n){
		case 0:po=new AumentarCantDisparos(c,this);
		c.setelem(po.getProfundidad(), po);
		break;
		case 1: po=new MejorarDisparo(c,this);
		c.setelem(po.getProfundidad(), po);
		break;
		case 2: po=new pocion(c,this);
		c.setelem(po.getProfundidad(), po);
		break;
		case 3: po=new campoDeProteccion(c,this);
		c.setelem(po.getProfundidad(), po);
			break;
		case 4: po=new CongelaTiempo(c,this);
		c.setelem(po.getProfundidad(), po);
		break; 
		case 5: po=new SuperMisil(c,this);
		c.setelem(po.getProfundidad(), po);
			break;
		}
		creandoPW=false;
	}
	public void crearObstaculo() {
		Random r=new Random();
		int i=0;
		while(i<8)
			{
			int x=r.nextInt(12)+4;
			int y=r.nextInt(5)+5;
			if(celdas[x][y].objlist()[0]==null)
				{	
				obstaculo p;
				int c=r.nextInt(2);
				switch(c){
					case 0:p=new ParedPlayer(celdas[x][y],this);break;
					case 1:p=new ParedTodos(celdas[x][y],this);break;
					}
				i++;
				}
			}
	}
	
	public void supermisil() {
	// agregar elemento grafico en celdas[5][5] de una bomba
		LinkedList<enemigoAbstract> eliminar=new LinkedList<enemigoAbstract>();
		for(enemigoAbstract e:lEnemy)
			eliminar.add(e);
				
		for(enemigoAbstract e:eliminar){
				e.reducirVida(30);
		}
		
	}
	public void congelatiempo(jugador jugador) {
		m.congelar();
		}
		//CONGELAR TIEMPO DEL JUEGO
	public void gameover(jugador jugador) {
		j.gamerover();
		
	}
	public void restart(enemigoAbstract enemigoAbstract) {
		celda c=enemigoAbstract.getcelda();
		Random r= new Random();
		boolean b=true;
		while(b){
		int x=r.nextInt(17)+2;
		int y=r.nextInt(3)+1;
		if(celdas[x][y].objlist()[1]==null){
		c.setelem(enemigoAbstract.getProfundidad(), null);
		enemigoAbstract.setCelda(celdas[x][y]);
		celdas[x][y].setelem(enemigoAbstract.getProfundidad(), enemigoAbstract);
		enemigoAbstract.initgraph();
		b=false;
			}
		}
		
	}
	
	public void resetearJugador(jugador j){
		j.changeRunning();
		j.getcelda().setelem(j.getProfundidad(),null);
		j.setCelda(celdas[10][14]);
		celdas[10][14].setelem(j.getProfundidad(), j);
		j.congelatiempo();
		j.initgraph();
		j.changeRunning();
	}
	
	protected abstract void crearEnemigos();
	
	protected void crearEnemigo(celda c){
		enemigo e=new enemigo(c,this,j);
		lEnemy.add(e);
		m.addEnemy(e);
	}
	
	public void stopSound(){
		cancion.setRepeat(false);
		cancion.stop();
	}
	public void initSound(){
		cancion.play();
		cancion.setRepeat(true);
	}
	protected void gane(){
		stopSound();
		j.win();
	}
	public boolean ganado(){
		return gane;
	}
	public int getmaxY() {
		// TODO Auto-generated method stub
		return celdas[0].length-1;
	}
	public int getminY() {
		// TODO Auto-generated method stub
		return 0;
	}
}
