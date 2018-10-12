package disparo;

import java.util.LinkedList;

import mapa.Map;

public class DisparoMobiler implements Runnable{
	private Map m;
	private LinkedList<Disparo> d;
	private Thread t;
	public DisparoMobiler(Map m){
		this.m=m;
		d=new LinkedList<Disparo>();
		t=new Thread(this);
	}
	
	public void addDisparo(Disparo e){
		d.add(e);
	}
	public void killDisparo(Disparo e){
		d.remove(e);
	}

	public void play(){
		t.start();
	}
	
	public void run(){
		while(!m.ganado()){
			LinkedList<Disparo>	aux=new LinkedList<Disparo>();
			for(Disparo e:d)
				if(e.getIsRunning())
					aux.add(e);
			
			for(Disparo e:aux)
				if(e.getIsRunning())
					e.mover();
			
				}
				
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		t.interrupt();
		}
}
