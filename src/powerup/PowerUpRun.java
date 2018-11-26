package powerup;


public class PowerUpRun implements Runnable {

	private PowerUp d;
    private Thread t;
    private boolean moviendo=false;
    public PowerUpRun(PowerUp d){
   	 this.d=d;
   	 t=new Thread(this);
   	 t.start();
    }
    
    public void run(){
   	 
   	 boolean isRunnable=d.getIsRunning();
   	 while(isRunnable){
   		 
         isRunnable=d.getIsRunning();
          if(isRunnable){
       	   if (!moviendo){
 		            d.mover();
 		          try{
 		        	Thread.sleep(1000);
 		          }
 		          catch (Exception e){;}
 		            }
          }
           	   
 	   }
   	  		t.interrupt();
   	 
    }
}
