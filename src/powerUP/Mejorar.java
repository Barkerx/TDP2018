package powerUP;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Mapa;
import player.Jugador;
import mapa.Celda;

public class Mejorar extends PowerUp{

	public Mejorar(Celda ce, Mapa m) {
		super(ce, m);
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/resources/mejorarDisparo.png")));
		initgraph();
		velocidad=40;
		puntos=300;
		new PowerUpRun(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accionar(Jugador j) {
		j.sumarPuntaje(puntos);
		j.setArma(j.getArma().levelUP());
		
	}

}
