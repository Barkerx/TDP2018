package enemigos;

import java.util.LinkedList;

import mapa.Map;

public class EnemyMobiler implements Runnable{

	private Map m;
	private LinkedList<enemigoAbstract> enemigos;
	private LinkedList<enemigoAbstract>	aux;
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
	public void play(){
		t.start();
	}
	
	public void run(){
		while(!m.ganado()){
			aux=new LinkedList<enemigoAbstract>();
			for(enemigoAbstract e:enemigos)
				if(e.getIsRunning())
					aux.add(e);
			
			for(enemigoAbstract e:aux)
				if(e.getIsRunning())
					e.mover();
			try {
				Thread.sleep(600);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		}
		t.interrupt();
		}
}
