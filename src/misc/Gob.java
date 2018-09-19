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
	 	 /**
	 	  * metodo usado para reducir la vida en n del Gob
	 	  * @param n vida a reducir del Gob
	 	  */
	 	 public void reducirVida(int n){
	 		 vida=vida-n;
	 		 if (vida<=0)
	 			 destruir();
	 	 }
	 	 /**
	 	  * metodo usado para el visitor, es para que el visitante sepa a quien va a visitar
	 	  * @param V el visitor al que le diremos quien es el que visitara
	 	  * @return si el visitor nos deja pasar o no nos deja pasar
	 	  */
	 	public abstract boolean Accept(Visitor V);
	 	/**
	 	 * usado para obtener el grafico del Gob
	 	 * @return Grafico del Gob
	 	 */
	     public JLabel getGrafico(){
	    	 return grafico;
	     }
	     /**
	      * metodo para setear un grafico al Gob
	      * @param graf el grafico que queremos setear
	      */
	     public void setGrafico(JLabel graf){
	    	 grafico=graf;
	     }
	     /**
	      * Metodo usado para eliminar un Gob(tanto logica como graficamente)
	      */
	     public void destruir(){
	    	 isRunning=false;
	    	 grafico.setIcon(null);
	    	 c.objlist()[profundidad]=null;
	    	 initgraph();
	     }
	     /**
	      * metodo usado para actualizar la grafica en el mapa.
	      */
	 	public void initgraph(){
	       	 grafico.setBounds(c.getposx()*45, c.getposy()*45, 100 , 100);
	         m.addgraph(grafico);
	 	}
	 /**
	  * metodo para obtener la profundidad de un gob
	  * @return Profundidad del Gob
	  */
	     public int getProfundidad(){
	    	 return profundidad;
	     }
	     /**
	      * metodo usado para saber si un gob esta o no corriendo
	      * @return true si esta corriendo, false en caso contrario.
	      */
	     public boolean getIsRunning(){
	    	 return isRunning;
	     }
	     
}
