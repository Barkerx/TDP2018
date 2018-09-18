package enemigos;

import iAenemigos.FormaDeAtacar;
import mapa.Map;
import mapa.celda;
import misc.Visitor;
import misc.nave;

public class enemigo extends nave{
	private FormaDeAtacar ataque;
	
	public enemigo(celda c,Map m,FormaDeAtacar a) {
		super(c,m);
		c.setelem(profundidad, this);
		ataque = a;
		visitor=new visitorEnemigo(this);
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/enemigo.png")));
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Accept(Visitor V) {
		return V.visitenemigo(this);
	}

	@Override
	public void run() {
		// while(isRunning)
		// mover(a.getdir);
		//thread.sleep(100);
		
	}
	
	public void destruir(){
		m.desligar(this);
		ataque.desvincular();
		destruir();
		
	}

	public int getpuntos() {
		return puntos;
	}

}
