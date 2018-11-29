package mapa;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pool{
	private ExecutorService pool; 
	public Pool(){
	     pool = Executors.newFixedThreadPool(150);
	}
	
	public void add(Thread p){
	pool.execute(p);
	}
}
