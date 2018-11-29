package powerup;

import mapa.Mapa;

public class PowerUpRun extends Thread {

	private PowerUp d;
	
    public PowerUpRun(PowerUp d,Mapa m){
   	 this.d=d;
   	 m.activate(this);
    }
    
    public void run(){
   	 
   	 boolean isRunnable=d.getIsRunning();
   	 while(isRunnable){
         isRunnable=d.getIsRunning();
          if(isRunnable){
 		            d.mover();
 		          try{
 		        	Thread.sleep(600);
 		          }
 		          catch (Exception e){;}
          }
 	   }
   	  this.interrupt();
    }
}