package enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.disparoEnemy;
import iAenemigos.IAKamikaze;
import mapa.Mapa;
import mapa.celda;

public class Kamikaze extends enemigo {

	public Kamikaze(celda c, Mapa m) {
		super(c, m);
		vida=150;
		velocidad=30;
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/kamikaze.png")));
		initgraph();
		IA=new IAKamikaze(this);
		
		// TODO Auto-generated constructor stub
	}

	public void disparar() {
		if(isRunning)
			new disparoEnemy(c,m);
	}

}
