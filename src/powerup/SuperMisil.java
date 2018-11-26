package powerup;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import enemigos.EnemigoAbstract;
import mapa.Mapa;
import player.Jugador;
import mapa.Celda;

public class SuperMisil extends PowerUp{

	public SuperMisil(Celda ce, Mapa m) {
		super(ce, m);
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/resources/superMisil.png")));
		initgraph();
		velocidad=20;
		puntos=200;
		new PowerUpRun(this);
	}
	
	@Override
	public void accionar(Jugador j) {
		j.sumarPuntaje(puntos);
		LinkedList<EnemigoAbstract> p=new LinkedList<EnemigoAbstract>();
		for(EnemigoAbstract e:m.getEnemigos())
			if(e.getIsRunning())
				p.add(e);
		
		for(EnemigoAbstract e1:p)
			if(e1.getIsRunning())
				e1.reducirVida(50);
	}

	
}
