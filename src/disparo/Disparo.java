package disparo;


import misc.*;

public abstract class Disparo extends Unidad implements Runnable{
	
	protected Thread t1;
	protected int damage;

	/**
	 * metodo usado para retornar el daño de un disparo
	 * @return retorna el daño del disparo.
	 */
	public int getdamage(){
		return damage;
	}
	/**
	 * metodo que redefine el mover de unidad
	 */
	public abstract void mover();
	/**
	 * metodo que se va a ejecutar al crear un disparo.
	 */
	public int getvelocidad() {
		// TODO Auto-generated method stub
		return velocidad;
	}
	
	public void run(){
	   	 
	   	 while(isRunning){
	          if(isRunning &&!moviendo){
	 		            mover();
	 		          
	 		          try{
	 		        	Thread.sleep(velocidad*2);
	 		          }
	 		          catch (Exception e){;}
	 		            }
	          }
	   	 t1.interrupt();
	    }
	
}
