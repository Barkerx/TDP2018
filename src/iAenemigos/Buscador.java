package iAenemigos;

import enemigos.enemigo;
import gui.Juego;
import mapa.celda;

public class Buscador extends FormaDeAtacar{

	public Buscador(Juego j, enemigo e) {
		super(j, e);
		t1=new Thread(this);
   	 	t1.start();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		if(e.getIsRunning()){
		while(e.getIsRunning()){
			
			if(waked){
					celda c=e.mover(j.getxy(e));
					if (c==null){
						e.restart();
					}
				try {
					Thread.sleep(300);
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
