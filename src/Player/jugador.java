package Player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import PowerUP.powerUp;
import disparo.Basico;
import disparo.DisparoP;
import mapa.celda;
import mapa.*;
import misc.*;

public class jugador extends nave{
     
     public jugador(celda c,Map m) {
    	 super(c,m);
    	 visitor=new visitorPlayer(this);
    	 grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/JugadorImagen2.png")));
     }
     public celda mover(int n){
    	 celda c2=super.mover(n);
    	 if(c2!=null){
    		 intercambiarceldas(c2, profundidad);
    	 }
    	 return c2;
     }
	@Override
	public void disparar() {
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
	}
     
}
