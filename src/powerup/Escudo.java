package powerup;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Mapa;
import mapa.Celda;
import nave.player.Jugador;
import nave.player.escudo.*;

public class Escudo extends PowerUp{

	public Escudo(Celda ce, Mapa m) {
		super(ce, m);
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/resources/shield.png")));
		initgraph();
		puntos=200;
		velocidad=20;
		new PowerUpRun(this,m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accionar(Jugador j) {
		 j.sumarPuntaje(puntos);
		 j.setShield(new Mejorado(j));
		
	}
	

}
