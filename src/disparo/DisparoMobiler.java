package disparo;

import java.util.LinkedList;

import mapa.Mapa;

public class DisparoMobiler implements Runnable{
	private Mapa m;
	private LinkedList<Disparo> d;
	private Thread t;
	private boolean eliminado=false;
	private boolean agregado=false;
	private LinkedList<Disparo> elim;
	private LinkedList<Disparo> l;
	public DisparoMobiler(Mapa m){
		this.m=m;
		d=new LinkedList<Disparo>();
		l=new LinkedList<Disparo>();
		elim=new LinkedList<Disparo>();
		t=new Thread(this);
		play();
	}
	
	public void addDisparo(Disparo e){
		l.add(e);
		agregado=true;
	}
	public void killDisparo(Disparo e){
		elim.add(e);
		eliminado=true;
	}

	public void play(){
		t.start();
	}
	
	public void run(){
		while(!m.ganado()){
			//lista donde estan los nuevos disparos a agregar
			
			if(agregado){
			LinkedList<Disparo> aux=new LinkedList<Disparo>();
			for(Disparo e:l)
				if(e.getIsRunning())
					{d.add(e);
					aux.add(e);
					}
			for(Disparo e:aux)
				l.remove(e);
			agregado=false;
			}
			
			//lista donde estan los disparos a eliminar
			if(eliminado){
			LinkedList<Disparo> aux2=new LinkedList<Disparo>();
			for(Disparo e:elim)
				if(e.getIsRunning())
					{d.remove(e);
					aux2.add(e);
					}
			for(Disparo e:aux2)
				elim.remove(e);
			eliminado=false;
			}
			
			for(Disparo e:d)
				if(e.getIsRunning())
					e.mover();
		
			try {
				Thread.sleep(130);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		t.interrupt();
		}
}
