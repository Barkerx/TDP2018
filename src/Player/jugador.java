package Player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import arma.arma;
import arma.basico;
import disparo.Basico;
import disparo.DisparoP;
import mapa.celda;
import mapa.*;
import misc.*;

public class jugador extends nave{
     protected int disparos;
     protected JLabel shieldL;
     protected int shield;
     protected arma arma;
     public jugador(celda c,Map m) {
    	 this.c=c;
    	 this.m=m;
    	 visitor=new visitorPlayer(this);
    	 grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/JugadorImagen2.png")));
    	 puntos=0;
    	 vida=100;
    	 disparos=1;
    	 arma=new basico(this);
    	 
     }
     public void reducirVida(int n){
    	 if(shieldL!=null){
    		 shield=shield-1;
    		 if (shield==0)
        		 shieldL=null;
        	
    	 }
    	 else
    		super.reducirVida(n);    	  
    	 
    	 System.out.println(vida);
     }
     public void sumarEnemigo(int n){
    	 puntos=puntos+n;
	 System.out.println(puntos);
     }
     public celda mover(int n){ 	
    	celda c2=super.mover(n);
    	disparar(); 	
    	return c2;
     }
	@Override
	public void disparar() {
		DisparoP e=arma.getDisparo();
	}
	public void setMap(Map map) {
		m=map;	
	}
	public void setCelda(celda c )
	{
		this.c=c;
		c.objlist()[profundidad]=this;
	}
	@Override
	public boolean Accept(Visitor V) {
		return V.visitPlayer(this);
	}
	public void pocion() {
		vida=vida+30;
		puntos = puntos+300;
	}
	public int getPoints(){
		return puntos;
	}
	@Override
	public void run() {
		
	}
	public void congelatiempo() {
	//congelar tiempo
		puntos=puntos+300;
		
	}
	public void setshield() {
		shieldL=new JLabel(new ImageIcon(this.getClass().getResource("/resources/JugadorImagen2.png")));
		shield=3;
		
		puntos=puntos+300;
	}
	public void aumentar() {
		if(disparos<3)
		disparos++;
		
		puntos=puntos+300;
	}
	public void mejorarDisparo() {
		arma=arma.levelUP();
		
	}
	public celda getcelda() {
		// TODO Auto-generated method stub
		return c;
	}
	public Map getmap() {
		// TODO Auto-generated method stub
		return m;
	}
     
}
