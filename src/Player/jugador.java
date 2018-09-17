package Player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.Basico;
import disparo.DisparoP;
import mapa.celda;
import mapa.*;
import misc.*;

public class jugador extends nave{
     protected int disparos;
     protected JLabel shieldL;
     protected int shield;
     public jugador(celda c,Map m) {
    	 super(c,m);
    	 visitor=new visitorPlayer(this);
    	 grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/JugadorImagen2.png")));
    	 puntos=0;
    	 disparos=1;
    	 
     }
     public void reducirVida(int n){
    	 if(shieldL!=null){
    		 shield=shield-1;
    		 if (shield==0)
        		 shieldL=null;
        	
    	 }
    	 else
    		super.reducirVida(n);    	  
    	 
     }
     public void sumarEnemigo(int n){
    	 puntos=puntos+n;
     }
     public celda mover(int n){
    	 celda c2=super.mover(n);
    	 disparar();
    	 return c2;
     }
	@Override
	public void disparar() {
		//cambiar por arma cuando este implementada;ya que la idea esrecuperar el disparo del arma, la cantidad de disparos estan en el player
		DisparoP e=new Basico(c,m,this);
		e.mover();
	}
	public void setMap(Map map) {
		m=map;	
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
     
}
