package disparo;

public class DisparoRun implements Runnable{
     private Disparo d;
     private Thread t;
     private boolean moviendo=false;
     public DisparoRun(Disparo d){
    	 this.d=d;
    	 t=new Thread(this);
    	 t.start();
     }
     
     public void run(){
    	 
    	 boolean isRunnable=d.getIsRunning();
    	 while(isRunnable){
          isRunnable=d.getIsRunning();
           if(isRunnable &&!moviendo){
  		            d.mover();
  		          
  		          try{
  		        	Thread.sleep(150);
  		          }
  		          catch (Exception e){;}
  		            }
           }
    	 t.interrupt();
     }
}
