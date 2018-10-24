package mapa;

import java.util.LinkedList;
import java.util.Random;
import javax.swing.JLabel;
import Player.jugador;
import PowerUP.*;
import disparo.Disparo;
import disparo.DisparoMobiler;
import enemigos.Buscador;
import enemigos.EnemyMobiler;
import enemigos.Kamikaze;
import enemigos.Temporal;
import enemigos.enemigo;
import enemigos.enemigoAbstract;
import gui.Juego;
import gui.gui;
import misc.Gob;
import misc.Unidad;
import jaco.mp3.player.MP3Player;
import obstaculos.*;
public abstract class Map extends Thread {
	protected celda[][] celdas; 
	protected gui g;
	protected MP3Player cancion;
	private boolean creandoPW=false;
	protected JLabel fondo;
	protected LinkedList<enemigoAbstract> lEnemy;
	protected Juego j;
	protected int horda;
	protected boolean gane =false;
	protected EnemyMobiler m;
	protected DisparoMobiler d;
	protected Pool dp;
	protected boolean waked=true;
	protected Phantom p;
	
	protected void inicializoCeldas(){
		//inicializo la matriz de celdas
				int x=20;
				int y=15;
				celdas=new celda[x][y];
				for(int i=0;i<x;i++)
					for(int j=0;j<y;j++)
						celdas[i][j]=new celda(i,j,this);
				
	}
	
	protected void inicializoGui(gui gu,Juego ju){
		g=gu;
		g.setResizable(false);
   	 	g.add(fondo,new Integer(0));
   	 	this.j=ju;	 
	}
	
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
		int intAleatorio = aleatorio.nextInt(6);
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
	/**
	 * Metodo Usado para crear Obstaculos de forma aleatoria
	 */
	protected void crearObstaculo() {
		Random r=new Random();
		int i=0;
		while(i<8)
			{
			int x=r.nextInt(12)+4;
			int y=r.nextInt(5)+5;
			if(celdas[x][y].objlist()[0]==null)
				{	
				obstaculo p=null;
				int c=r.nextInt(2);
				switch(c){
					case 0:p=new ParedPlayer(celdas[x][y],this);break;
					case 1:p=new ParedTodos(celdas[x][y],this);break;
					}
				i++;
				}
			}
	}
	/**
	 * Metodo usado para dañar a todos los enemigos en 30 puntos
	 */
	public void supermisil() {
	// agregar elemento grafico en celdas[5][5] de una bomba
		LinkedList<enemigoAbstract> eliminar=new LinkedList<enemigoAbstract>();
		for(enemigoAbstract e:lEnemy)
			eliminar.add(e);
				
		for(enemigoAbstract e:eliminar){
				e.reducirVida(30);
		}
		
	}
	/**
	 * metodo usado para congelar a los enemigos, cambiando su IA por una que no hace nada.
	 */
	public void congelatiempo() {
		for(enemigoAbstract e:lEnemy)
			e.congelar();
		p=new Phantom(3000,this);
	}
	/**
	 * Metodo usado para descongelar los enemigos, cambiando su IA por la Original
	 */
	protected void descongelar(){	
		for(enemigoAbstract e:lEnemy)
			e.descongelar();
	}
		//CONGELAR TIEMPO DEL JUEGO
	/**
	 * metodo usado para indicar que el juego se termino.
	 * @param jugador
	 */
	public void gameover(jugador jugador) {
		jugador.changeRunning();
		jugador.getcelda().setelem(jugador.getProfundidad(),null);
		jugador.setGrafico(null);
		j.gamerover();
	}
	/**
	 * metodo usado para reiniciar la posicion del enemigo.
	 * @param enemigoAbstract enemigo que reiniciara su posicion
	 */
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
	/**
	 * Al morir el jugador reinicia su posicion en una celda puntual y congela el tiempo para que el jugador tenga tiempo.
	 * @param j jugador a reiniciar la posicion
	 */
	public void resetearJugador(jugador j){
		j.changeRunning();
		j.getcelda().setelem(j.getProfundidad(),null);
		j.setCelda(celdas[10][14]);
		celdas[10][14].setelem(j.getProfundidad(), j);
		j.initgraph();
		j.changeRunning();
		congelatiempo();
	}
	/**
	 * metodo usado para crear Enemigos en el mapa, cada mapa crea sus enemigos.
	 */
	protected abstract void crearEnemigos();
	/**
	 * metodo usado para crear un enemigo en la celda c.
	 * @param c celda donde se insertara el enemigo.
	 */
	protected void crearEnemigo(celda c){
		enemigo e = null;
		Random r=new Random();
		int x=r.nextInt(3);
	switch(x){
	case 0:e=new Buscador(c,this,j.getJugador());break;
	case 1:e=new Kamikaze(c,this);break;
	case 2:e=new Temporal(c,this,j.getJugador());break;
	}
		lEnemy.add(e);
		m.addEnemy(e);
	}
	/**
	 * metodo usado para parar el sonido del mapa.
	 */
	public void stopSound(){
		cancion.setRepeat(false);
		cancion.stop();
	}
	/**
	 * metodo usado para comenzar el sonido del mapa
	 */
	public void initSound(){
		cancion.play();
		cancion.setRepeat(true);
	}
	/**
	 * metodo usado para indicar que el mapa fue ganado al juego
	 */
	protected void gane(){
		stopSound();
		this.interrupt();
		j.win();
	}
	/**
	 * metodo que retorna el estado del mapa
	 * @return True si se gano el mapa, False en caso contrario.
	 */
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
	public void addDisparo(Disparo p){
		d.addDisparo(p);
	}
	public void killDisparo(Disparo p){
		d.killDisparo(p);
	}
	public void movegraph(Gob g) {
		 dp.add(g);
	}
	
}
