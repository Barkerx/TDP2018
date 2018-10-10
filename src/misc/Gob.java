package misc;

import javax.swing.ImageIcon;
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
	     protected  volatile boolean isRunning=true;
	 	 protected Map m;
	 	 protected volatile Thread t1;
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
	    	 if(isRunning){
	    	 isRunning=false;
	    	 grafico.setIcon(null);
	    	 grafico.setBounds(c.getposx()*45, c.getposy()*45, 45 , 45);
	    	 m.addgraph(grafico);
	    	 c.setelem(profundidad,null);
	    	 }
	     }
	     
	     /**
	      * metodo usado para actualizar la grafica en el mapa.
	      */
	 	public void initgraph(){
	       	 grafico.setBounds(c.getposx()*45, c.getposy()*45, 45 , 45);
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
		
		//grafico.getVisibleRect().intersects(arg0)
/**
 *Metodo usado para Explotar el gob(mas que nada hace una explosion grafica 
 */
		public void explotar(){
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/exp1.png")));
		grafico.setBounds(c.getposx()*45, c.getposy()*45, 45, 45);
		m.addgraph(grafico);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/exp2.png")));
		grafico.setBounds(c.getposx()*45, c.getposy()*45, 45, 45);
		m.addgraph(grafico);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		grafico.setIcon(null);
		m.addgraph(grafico);
	}	
}
