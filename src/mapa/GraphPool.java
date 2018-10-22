package mapa;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import misc.Unidad;

public class GraphPool{
	private ExecutorService pool; 
	public GraphPool(){
	     pool = Executors.newFixedThreadPool(80);
	}
	
	public void add(Unidad p){
	pool.execute(p);
	}
}
