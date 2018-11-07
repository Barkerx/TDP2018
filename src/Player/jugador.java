package Player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import arma.arma;
import arma.basico;
import mapa.celda;
import mapa.*;
import misc.*;

public class jugador extends nave{
     protected arma arma;
     protected int vidas;
     protected shield escudo;
     protected boolean puede;
     public jugador(celda c,Mapa m) {
    	 this.c=c;
    	 this.m=m;
    	 profundidad=1;
    	 visitor=new visitorPlayer(this);
    	 grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/player.png")));
    	 puntos=0;
    	 vidas=3;
    	 velocidad=35;
    	 moviendo=false;
    	 escudo=new Basico(this);
    	 shieldL=null;
    	 vida=150; 
    	 puede=true;
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
    	 escudo.reducirVida(n);
    }
     public void initgraph(){
    	 grafico.setBounds(c.getposx()*45, c.getposy()*45, 45 , 45);
         m.addgraph(grafico);
 		 if(escudo.getImage()!=null){
 			 shieldL=escudo.getImage();
 			 shieldL.setBounds(c.getposx()*45, c.getposy()*45, 45 , 45);
 			 m.addgraph(shieldL,2);
 		 }
     }
     /**
      * metodo para sumar puntos al player usado por el juego
      * @param n puntaje a sumar
      */
     public void sumarPuntaje(int n){
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
	public void setMap(Mapa map) {
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
	
	public Mapa getmap() {
		// TODO Auto-generated method stub
		return m;
	}
	public void setVida(int n){
		vida=n;
			if (vida<=0){
				if(vidas==0&&isRunning){
					c.setelem(profundidad,null);
					isRunning=false;
					grafico.setIcon(null);
					m.gameover(this);
				}
				else{
				vida=150;
				arma=new basico(this);
				vidas=vidas-1;
				if(m!=null)
					m.resetearJugador(this);//mover a la celda de reseteo XXX
					}
			}
		
	}
	public int getVida(){
		return vida;
	}
	
	/**
	 * setea un escudo en el jugador, con el cual evita 2 golpes
	 * @param basico 
	 */
	public void setShield(shield b) {
		escudo=b;
		if(escudo.getImage()!=null && shieldL==null){
	 		 shieldL=escudo.getImage();
	 		 shieldL.setBounds(c.getposx()*45, c.getposy()*45, 45 , 45);
	         m.addgraph(shieldL,2);
	 		 }
			else{
				if(shieldL!=null && escudo.getImage()==null){
				shieldL.setIcon(null);
				m.addgraph(shieldL,2);
				shieldL=null;
				}
			}
	}
	/**
	 * aumenta la cantidad de disparos del jugador(maximo 3)
	 */
	public void aumentar() {
		arma.aumentarDisparos();
	}
	
	/**
	 * mejora el disparo a el siguiente(el maximo es el misil)
	 */
	public void mejorarDisparo() {
		arma=arma.levelUP();
	}
	/**
	 * metodo que daña a todos los enemigos del mapa.
	 */
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
