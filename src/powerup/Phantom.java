package powerup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.Timer;

import enemigos.EnemigoAbstract;
import inteligencias.IADormido;
import inteligencias.Inteligencia;
import mapa.Mapa;

public class Phantom {

	private int time;
	private Mapa m;
	private static Phantom INSTANCE = null;
	
	private Phantom(int n,Mapa m){
		time=n;
		this.m=m;
		start();
	}
	private synchronized static void createInstance(int n,Mapa m) { 
            INSTANCE = new Phantom(3000,m);
    }
	public synchronized static Phantom getInstance(int n, Mapa m){
		if(INSTANCE==null){
				createInstance(n,m);
				}
			return INSTANCE;
	}
	public synchronized static void resetInstance(){
		INSTANCE=null;
	}
	public void start(){
		LinkedList<EnemigoAbstract> l= new LinkedList<EnemigoAbstract>();
		for(EnemigoAbstract e:m.getEnemigos()){
			if(e.getIsRunning())
				l.add(e);
		} 
		Map<EnemigoAbstract,Inteligencia> k=new HashMap<EnemigoAbstract,Inteligencia>();
		for(EnemigoAbstract e:l){
			if(e.getIsRunning()){
				k.put(e, e.getIA());
			}
		}
		for(EnemigoAbstract e:l){
			if(e.getIsRunning()){
				e.setIA(new IADormido(e));
			}
		}
		int delay = time; 
		  ActionListener taskPerformer = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		    	  for(EnemigoAbstract e:l){
		  			if(e.getIsRunning()){
		  				e.setIA(k.get(e));
		  			}
		  		}
		      }
		  };
		 new Timer(delay, taskPerformer).start(); 
	}
}
