package player;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import arma.Arma;
import arma.Abasico;
import mapa.Celda;
import mapa.*;
import misc.*;

public class Jugador extends Nave{
     protected Arma arma;
     protected int vidas;
     protected JLabel puntosLabel;
     protected JLabel vidaLabel;
     protected JLabel vidasLabel;
     protected Shield escudo;
     protected boolean puede;
     public Jugador(Celda c,Mapa m) {
    	 this.c=c;
    	 this.m=m;
    	 profundidad=1;
    	 visitor=new VisitorPlayer(this);
    	 grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/player.png")));
    	 puntos=0;
    	 vidas=3;
    	 velocidad=35;
    	 moviendo=false;
    	 escudo=new Ebasico(this);
    	 shieldL=null;
    	 vida=150; 
    	 puede=true;
    	 arma=new Abasico(this);
    	 vidaLabel=new JLabel();
    	 vidaLabel.setBounds(50, 590, 100, 40);
    	 vidaLabel.setForeground(Color.WHITE);
    	 puntosLabel=new JLabel();
    	 puntosLabel.setBounds(450, 0, 100, 40);
    	 puntosLabel.setForeground(Color.WHITE);
    	 vidasLabel=new JLabel();
    	 vidasLabel.setBounds(50, 0, 100, 40);
    	 vidasLabel.setForeground(Color.WHITE);
     }
     /**
      * metodo usado para actualizar la grafica de los puntos actuales del jugador
      */
     private void updatePuntos(){
    	 puntosLabel.setText("Puntos:"+puntos);
     }
     /**
      * metodo usado para actualizar la grafica de la vida actual del jugador
      */
     private void updateVida(){
    	 vidaLabel.setText("vida:"+vida);
     }
     /**
      * metodo usado para actualizar la grafica de la vidas actuales del jugador
      */
     private void updateVidas(){
    	 vidasLabel.setText("vidas:"+vidas);
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
 			updateVida();
     }
     /**
      * metodo usado para inicializar la grafica del jugador en el mapa
      */
     public void initgraph(boolean t){
    	 grafico.setBounds(c.getposx()*45, c.getposy()*45, 45 , 45);
         m.addgraph(grafico);
 		 if(escudo.getImage()!=null){
 			 shieldL=escudo.getImage();
 			 shieldL.setBounds(c.getposx()*45, c.getposy()*45, 45 , 45);
 			 m.addgraph(shieldL,2);
 		 }
 		 if(t){
 		 updatePuntos();
 		 m.addgraph(puntosLabel,2);
 		 updateVida();
 		 m.addgraph(vidaLabel,2);
 		 updateVidas();
 		 m.addgraph(vidasLabel,2);
 		 }
 	}
     /**
      * metodo para sumar puntos al player usado por el juego
      * @param n puntaje a sumar
      */
     public void sumarPuntaje(int n){
    	 puntos=puntos+n; 
    	 updatePuntos();
     }
     /**
      * metodo que redefine el mover de unidad ya que tiene en cuenta el disparo
      */
     public Celda mover(int n){ 	
    	Celda c2=null;
    	if(isRunning){
    	 if(n!=-1){
    		c2=super.mover(n);
    		puede=true; // al moverse uno habilita el disparo
    	 }
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
		return escudo.accept(V);
	}
	/**
	 * metodo usado para recuperar el puntaje del jugador y de esa forma escribirlo en la gui
	 * @return puntaje del jugador
	 */
	public int getPoints(){
		return puntos;
	}
	
	public Mapa getmap() {
		
		return m;
	}
	public void setVida(int n){
		vida=n;
		if(vida>150){
			vida=150;
			updateVida();
		}
			else{
			if (vida<=0){
				if(vidas==0&&isRunning){
					c.setelem(profundidad,null);
					grafico.setIcon(null);
					m.gameover(this);
				}
				else{
				vida=150;
				arma=new Abasico(this);
				vidas=vidas-1;
				if(m!=null)
						m.resetearJugador(this);//mover a la celda de reseteo XXX
					}
				}
			}
	}
	public int getVida(){
		return vida;
	}
	
	/**
	 * setea un escudo en el jugador, con el cual evita 2 golpes
	 * @param Ebasico 
	 */
	public void setShield(Shield b) {
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
		visitor=b.getVisitor();
	}
	
	/**
	 * Metodo que retorna el arma del jugador
	 * @return el arma del jugador
	 */
	public Arma getArma() {
		return arma;
	}
	/**
	 * Metodo usado para setear el arma del jugador
	 * @param a El arma que tendra el jugador
	 */
	public void setArma(Arma a){
		arma=a;
	}
	/**
	 * metodo que daña a todos los enemigos del mapa.
	 */
	public void candisparar() {
		puede=true;
		
	}
	public Celda getceldaizq() {
		if(m!=null)
		return m.mover(c,IZQUIERDA);
		else
			return null;
	}
	
	public Celda getceldader() {
		if(m!=null)
		return m.mover(c,DERECHA);
		else
			return null;
	}
	
	public Celda getceldaizqizq() {
		if(m!=null){
			if(c!=m.mover(c,IZQUIERDA)){
				Celda c1=m.mover(c,IZQUIERDA);
				return m.mover(c1, IZQUIERDA);
				}
				else
					return c;
			}
		else
			return null;
	}
	
	public Celda getceldaderder() {
		if(m!=null){
			if(c!=m.mover(c,DERECHA)){
				Celda c1=m.mover(c,DERECHA);
				return m.mover(c1, DERECHA);
				}
				else
					return c;
			}
		else
			return null;
	}
	
	public void setCelda(Celda celda) {
		c=celda;
	}
	public Shield getShield() {
		return escudo;
	}
     
}
