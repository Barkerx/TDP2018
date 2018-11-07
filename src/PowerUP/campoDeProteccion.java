package PowerUP;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.Mejorado;
import Player.jugador;
import mapa.Mapa;
import mapa.celda;

public class campoDeProteccion extends powerUp{

	public campoDeProteccion(celda ce, Mapa m) {
		super(ce, m);
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/resources/shield.png")));
		initgraph();
		puntos=200;
		velocidad=20;
		new powerUpRun(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accionar(jugador j) {
		 j.sumarPuntaje(puntos);
		 j.setShield(new Mejorado(j));
		
	}
	

}
