package PowerUP;


public class powerUpRun implements Runnable {

	private powerUp d;
    private Thread t;
    private boolean moviendo=false;
    public powerUpRun(powerUp d){
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
