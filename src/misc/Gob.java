package misc;

import javax.swing.JLabel;

import mapa.celda;

public class Gob {
	  	protected JLabel grafico;
	     protected celda c;
	     protected int profundidad;
	     protected boolean isRunning=true;
	     
	     
	     public JLabel getGrafico(){
	    	 return grafico;
	     }
	     public void setGrafico(JLabel graf){
	    	 grafico=graf;
	     }
	     public void destruir(){
	    	 isRunning=false;
	    	 grafico.setIcon(null);
	    	 c.objlist()[profundidad]=null;
	     }
	     
	     public int getProfundidad(){
	    	 return profundidad;
	     }
	     public boolean getIsRunning(){
	    	 return isRunning;
	     }
	     public void setIsRunning(boolean is){
	    	 isRunning=is;
	     }
}
