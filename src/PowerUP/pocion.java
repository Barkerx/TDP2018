package PowerUP;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import mapa.Mapa;
import mapa.celda;
public class pocion extends powerUp{
	private int pocion;
	public pocion(celda ce, Mapa m) {
		super(ce, m);
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/resources/pocion.png")));
		initgraph();
		velocidad=10;
		pocion=30;
		puntos=300;
		new powerUpRun(this);
		// TODO Auto-generated constructor stub
	}
	public void accionar(jugador j){
		j.sumarPuntaje(puntos);
		j.setVida(j.getVida()+pocion);
	}
}
