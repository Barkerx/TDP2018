package enemigos;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoBoss;
import mapa.Map;
import mapa.celda;
import mapa.mapaBoss;

public class FinalBOSS extends enemigoAbstract {
	private int dir;
	public FinalBOSS(celda c,Map m,int dir){
		profundidad=1;
		this.c=c;
		c.setelem(profundidad,this);
		this.m=m;
		this.dir=dir;
		puntos=300;
		x=c.getposx();
		y=c.getposy();
		grafico=new JLabel();
		shieldL=null;
		velocidad=16;
		visitor=new visitorEnemigo(this);
		//ataque=new FinalBoss(null, this);
		t1=new Thread(this);
		t1.start();
	}
	public void disparar(int dir) {
		new DisparoBoss(c,m,dir);
	}
	public void reducirVida(int n){
		mapaBoss ma=(mapaBoss) m;
		ma.reducirVida(n);
	}
	public void destruir(    ){
		isRunning=false;
		c.setelem(profundidad, null);
		c=null;
	}
		
	public void run(){
		while(isRunning){
			disparar();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		explotar();
	}
	@Override
	public void disparar() {
		disparar(dir);
		
	}
	public void explotar(){
	int i=0;
	celda n=c;
	while(i<12){
	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/exp1d.png")));
	grafico.setBounds(x*45,y*45,45,45);
	m.addgraph(grafico,2);
	try {
		Thread.sleep(100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/exp2d.png")));
	m.addgraph(grafico,2);
	try {
		Thread.sleep(100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/exp3d.png")));
	m.addgraph(grafico,2);
	try {
		Thread.sleep(100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/exp4d.png")));
	m.addgraph(grafico,2);
	try {
		Thread.sleep(100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	grafico.setIcon(null);
	m.addgraph(grafico,2);
	
	i=i+1;
	
	}
	t1.interrupt();
	}
	public void kill() {
		isRunning=false;
	}
	
}
    