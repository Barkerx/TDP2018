package enemigos;

import java.util.LinkedList;

import mapa.Map;

public class EnemyMobiler implements Runnable{
	private boolean waked=true;
	private Map m;
	private LinkedList<enemigoAbstract> enemigos;
	
	private Thread t;
	public EnemyMobiler(Map m){
		this.m=m;
		enemigos=new LinkedList<enemigoAbstract>();
		t=new Thread(this);
	}
	
	public void addEnemy(enemigoAbstract e){
		enemigos.add(e);
	}
	public void killEnemy(enemigoAbstract e){
		enemigos.remove(e);
	}
	public void congelar(){
		waked=false;
	}
	public void play(){
		t.start();
	}
	
	public void run(){
		while(!m.ganado()){
			if(waked){
			LinkedList<enemigoAbstract>	aux=new LinkedList<enemigoAbstract>();
			for(enemigoAbstract e:enemigos)
				if(e.getIsRunning())
					aux.add(e);
			
			for(enemigoAbstract e:aux)
				if(e.getIsRunning())
					e.mover();
			
				}
				else
				{
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					waked=true;
				}
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
		t.interrupt();
		}
}
