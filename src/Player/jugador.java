package Player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import PowerUP.powerUp;
import mapa.celda;
import mapa.*;
import misc.*;

public class jugador extends nave{
     
     public jugador(celda c) {
    	 super(c);
    	 grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/JugadorImagen2.png")));
     }
     public celda mover(int n){
    	 celda c2=super.mover(n);
    	 if(c2!=null){
    		 intercambiarceldas(c2, profundidad);
    		 initgraph();
    	 }
    	 return c2;
     }
	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}
     
}
