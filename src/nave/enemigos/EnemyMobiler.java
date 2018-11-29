package nave.enemigos;

import java.util.LinkedList;

import mapa.Mapa;

public class EnemyMobiler implements Runnable{

	private Mapa m;
	private LinkedList<EnemigoAbstract> enemigos;
	private Thread t;
	
	public EnemyMobiler(Mapa m){
		this.m=m;
		enemigos=new LinkedList<EnemigoAbstract>();
		t=new Thread(this);
	}
	
	public void addEnemy(EnemigoAbstract e){
		enemigos.add(e);
	}
	public void killEnemy(EnemigoAbstract e){
		enemigos.remove(e);
	}
	public void play(){
		t.start();
	}
	
	public void run(){
		LinkedList<EnemigoAbstract> aux;	
		while(!m.ganado()){
			aux=new LinkedList<EnemigoAbstract>();
			for(EnemigoAbstract e:enemigos)
				if(e.getIsRunning())
					aux.add(e);
			
			for(EnemigoAbstract e:aux)
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
