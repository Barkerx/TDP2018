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
	/**
	 * constructor del enemigo, lo crea y pone los graficos.
	 * @param c celda donde va a estar el enemigo
	 * @param m mapa donde va a estar el enemigo
	 * @param a forma de atacar que tendra el enemigo
	 */
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
	/**
	 * redefine el metodo eliminar de Gob, lo desrelaciona con el mapa, se desvincula de la IA que lo maneja, y luego se destruye.
	 */
	public void destruir(){
		m.desligar(this);
		//ataque.desvincular();
		super.destruir();
	}
	
/**
 * retorna la cantidad de puntos asociada al enemigo
 * @return puntos del enemigo
 */
	public int getpuntos() {
		return puntos;
	}

}
