package mapa;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import misc.Gob;

public class Pool{
	private ExecutorService pool; 
	public Pool(){
	     pool = Executors.newFixedThreadPool(80);
	}
	
	public void add(Gob p){
	pool.execute(p);
	}
}
