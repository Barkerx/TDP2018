package misc;

import javax.swing.JLabel;

import misc.Visitor;
import mapa.Map;
import mapa.celda;

public abstract class Gob {
		 protected Visitor visitor;
	  	 protected JLabel grafico;
	     protected celda c;
	     protected int vida;
	     protected int profundidad;
	     protected boolean isRunning=true;
	 	 protected Map m;
	 	 public Gob(celda c,Map m){
	 		 this.c=c;
	 		 this.m=m;
	 	 }
	 	 public void reducirVida(int n){
	 		 vida=vida-n;
	 		 if (vida<=0)
	 			 destruir();
	 	 }
	 	public abstract boolean Accept(Visitor V);
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
	 	public void initgraph(){
	       	 grafico.setBounds(c.getposx()*45, c.getposy()*45, 100 , 100);
	         m.addgraph(grafico);
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
