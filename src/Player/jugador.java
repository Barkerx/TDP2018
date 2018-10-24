package Player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import arma.arma;
import arma.basico;
import mapa.celda;
import mapa.*;
import misc.*;

public class jugador extends nave{
     protected int disparos;
     protected int shield;
     protected arma arma;
     protected int vidas;
     protected boolean puede;
     public jugador(celda c,Map m) {
    	 this.c=c;
    	 this.m=m;
    	 profundidad=1;
    	 visitor=new visitorPlayer(this);
    	 grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/player.png")));
    	 puntos=0;
    	 vidas=3;
    	 velocidad=35;
    	 moviendo=false;
    	 shieldL=new JLabel();
    	 shieldL.setIcon(null);
    	 vida=100; 
    	 puede=true;
    	 disparos=1;
    	 arma=new basico(this);
     }
     
     public void changeRunning(){
    	 if(isRunning)
    		 isRunning=false;
    	 else
    		 isRunning=true;
     }
     /**
      * metodo que redefine al reducirVida de Gob, ya que aplica el escudo.
      */
     public void reducirVida(int n){
    	 if(shieldL.getIcon()!=null){
    		 shield=shield-1;
    		 if (shield==0){
        		 shieldL.setIcon(null);
        		 m.addgraph(shieldL,2);
    		 }
        	
    	 }
    	 else{
    		vida=vida-n;
    		if(vidas==0&&isRunning){
    			isRunning=false;
    			grafico.setIcon(null);
    			m.gameover(this);
    		}
    		else
    			if (vida<=0){
    				vida=100;
    				disparos=1;
    				arma=new basico(this);
    				vidas=vidas-1;
    				if(m!=null)
    					m.resetearJugador(this);
    		} 
    	 
    	 }
    }
     public void initgraph(){
    	 grafico.setBounds(c.getposx()*45, c.getposy()*45, 45 , 45);
         m.addgraph(grafico);
         if(shieldL.getIcon()!=null){
         shieldL.setBounds(c.getposx()*45, c.getposy()*45, 45 , 45);
         m.addgraph(shieldL,2);}
     }
     /**
      * metodo para sumar puntos al player usado por el juego
      * @param n puntaje a sumar
      */
     public void sumarEnemigo(int n){
    	 puntos=puntos+n;      
     }
     /**
      * metodo que redefine el mover de unidad ya que tiene en cuenta el disparo
      */
     public celda mover(int n){ 	
    	celda c2=null;
    	 if(n!=-1){
    		c2=super.mover(n);
    		puede=true; // al moverse uno habilita el disparo
    	 }
    	else{
    		moviendo=false;
    		disparar();
    		moviendo=false;
    	}
    	return c2;
    	
     }
	
	/**
	 * metodo usado para disparar,el disparo es obtenido por el arma
	 */
	public void disparar() {
		if(!moviendo && puede){
			arma.getDisparo();
			puede=false;
			}
	}
	public void setMap(Map map) {
		m=map;	
	}
	
	@Override
	public boolean Accept(Visitor V) {
		return V.visitPlayer(this);
	}
	/**
	 * metodo usado para recuperar el puntaje del jugador y de esa forma escribirlo en la gui
	 * @return puntaje del jugador
	 */
	public int getPoints(){
		return puntos;
	}
	
	public Map getmap() {
		// TODO Auto-generated method stub
		return m;
	}
	//POWERUPS
	/**
	 * pocion
	 */
	public void pocion() {
		vida=vida+30;
		puntos = puntos+300;
	}
	/**
	 * congela la IA de los enemigos.
	 */
	public void congelatiempo() {
		if(m!=null)
			m.congelatiempo();
		puntos=puntos+300;
		
	}
	/**
	 * setea un escudo en el jugador, con el cual evita 2 golpes
	 */
	public void setshield() {
		if(shieldL.getIcon()==null)
		{shieldL.setIcon(new ImageIcon(this.getClass().getResource("/resources/shield.png")));
		m.addgraph(shieldL,2);}
		shield=3;
		puntos=puntos+300;
	}
	/**
	 * aumenta la cantidad de disparos del jugador(maximo 3)
	 */
	public void aumentar() {
		arma.aumentarDisparos();
		puntos=puntos+300;
	}
	
	/**
	 * mejora el disparo a el siguiente(el maximo es el misil)
	 */
	public void mejorarDisparo() {
		arma=arma.levelUP();
		puntos=puntos+300;
	}
	/**
	 * metodo que daña a todos los enemigos del mapa.
	 */
	public void supermisil() {
		if(m!=null)
			m.supermisil();
		
		
	}
	public void candisparar() {
		puede=true;
		
	}
	public celda getceldaizq() {
		if(m!=null)
		return m.mover(c,IZQUIERDA);
		else
			return null;
	}
	
	public celda getceldader() {
		if(m!=null)
		return m.mover(c,DERECHA);
		else
			return null;
	}
	
	public celda getceldaizqizq() {
		if(m!=null){
			if(c!=m.mover(c,IZQUIERDA)){
				celda c1=m.mover(c,IZQUIERDA);
				return m.mover(c1, IZQUIERDA);
				}
				else
					return c;
			}
		else
			return null;
	}
	
	public celda getceldaderder() {
		if(m!=null){
			if(c!=m.mover(c,DERECHA)){
				celda c1=m.mover(c,DERECHA);
				return m.mover(c1, DERECHA);
				}
				else
					return c;
			}
		else
			return null;
	}
	
	public void setCelda(celda celda) {
		c=celda;
	}
     
}
