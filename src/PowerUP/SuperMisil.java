package PowerUP;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import enemigos.enemigoAbstract;
import mapa.Mapa;
import mapa.celda;

public class SuperMisil extends powerUp{

	public SuperMisil(celda ce, Mapa m) {
		super(ce, m);
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/resources/superMisil.png")));
		initgraph();
		velocidad=20;
		puntos=200;
		new powerUpRun(this);
	}
	
	@Override
	public void accionar(jugador j) {
		j.sumarPuntaje(puntos);
		LinkedList<enemigoAbstract> p=new LinkedList<enemigoAbstract>();
		for(enemigoAbstract e:m.getEnemigos())
			if(e.getIsRunning())
				p.add(e);
		
		for(enemigoAbstract e1:p)
			if(e1.getIsRunning())
				e1.reducirVida(50);
	}

	
}
