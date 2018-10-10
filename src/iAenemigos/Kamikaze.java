package iAenemigos;

import enemigos.enemigo;
import gui.Juego;
import misc.Unidad;

public class Kamikaze extends FormaDeAtacar{
	
	

	public Kamikaze(Juego j, enemigo e) {
		super(j, e);
		 t1=new Thread(this);
    	 t1.start();
	}
	
	

	@Override
	public void run() {
		if(e.getIsRunning()){
			int n=0;
			int piv=0;
		while(e.getIsRunning()){		
			if(waked){
				
				if(n==0){
					n=1;
					e.disparar();
					e.mover(Unidad.IZQUIERDA);
					e.disparar();}
				else{
					n=0;
					e.disparar();
					e.mover(Unidad.DERECHA);
					e.disparar();
				}
				piv=piv+1;
				if(piv==4){
					piv=0;
					e.mover(Unidad.ABAJO);
					}
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else
			{
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				waked=true;
				}
			
				
			}
		t1.interrupt();
		}
		else
			t1.interrupt();
		

	}
	
}	
