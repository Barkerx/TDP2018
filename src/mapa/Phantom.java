package mapa;

public class Phantom extends Thread{

	private int time;
	private Map m;
	public Phantom(int n,Map m){
		time=n;
		this.m=m;
		new Thread(this);
		this.start();
	}
	public void run(){
		try {
			Phantom.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.descongelar();
		this.interrupt();
	}
}
