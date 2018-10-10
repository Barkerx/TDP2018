package iAenemigos;

import java.util.Random;

import enemigos.enemigo;
import gui.Juego;
import mapa.celda;
import misc.Unidad;

public class BuscadorTemporal extends FormaDeAtacar{

	public BuscadorTemporal(Juego j, enemigo e) {
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
					if(e.getVida()){
						Random r=new Random();
						int dir=r.nextInt(4);
						switch(dir){
						case 0:e.mover(Unidad.ARRIBA);
								e.disparar();
								break;
						case 1:e.mover(Unidad.ABAJO);
								e.disparar();
								break;
						case 2:e.mover(Unidad.DERECHA);
								e.disparar();
								break;
						case 3:e.mover(Unidad.IZQUIERDA);
								e.disparar();
								break;
						
						}
						try {
							Thread.sleep(1500);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							}
						
					}
					else
					{		e.disparar();
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


