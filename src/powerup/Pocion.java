package powerup;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Mapa;
import nave.player.Jugador;
import mapa.Celda;

public class Pocion extends PowerUp{
	private int pocion;
	public Pocion(Celda ce, Mapa m) {
		super(ce, m);
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/resources/pocion.png")));
		initgraph();
		velocidad=10;
		pocion=30;
		puntos=300;
		new PowerUpRun(this,m);
		// TODO Auto-generated constructor stub
	}
	public void accionar(Jugador j){
		j.sumarPuntaje(puntos);
		j.setVida(j.getVida()+pocion);
	}
}
