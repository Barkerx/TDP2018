package iAenemigos;

import enemigos.enemigo;
import enemigos.enemigoAbstract;
import gui.Juego;
import mapa.celda;
import misc.Unidad;

public class boss extends FormaDeAtacar {

	public boss(Juego j, enemigoAbstract e) {
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
					e.disparar();
					celda c=e.mover(j.getxy(e));
					if (c==null){
						e.restart();
					}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else
			{
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				waked=true;
				}
			
				
			}
		}
		else
			t1.interrupt();
		

	}
}