package enemigos;

import iAenemigos.FormaDeAtacar;
import mapa.Map;
import mapa.celda;
import misc.Visitor;
import misc.nave;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class enemigo extends nave{
	private FormaDeAtacar ataque;
	
	public enemigo(celda c,Map m,FormaDeAtacar a) {
		this.c=c;
		this.m=m;
		//ataque = a;
		puntos=300;
		visitor=new visitorEnemigo(this);
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/enemigo.png")));
		//run();
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Accept(Visitor V) {
		System.out.println(V);
			return V.visitenemigo(this);
	}

	@Override
	public void run() {
	//	 while(isRunning)
		//	try {
		//		Thread.sleep(100);
		//	} catch (InterruptedException e) {
			//	// TODO Auto-generated catch block
			//	e.printStackTrace();
			//}
		
	}
	
	public void destruir(){
		m.desligar(this);
		//ataque.desvincular();
		super.destruir();
	}
	

	public int getpuntos() {
		return puntos;
	}

}
