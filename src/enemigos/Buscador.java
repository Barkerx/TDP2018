package enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Player.jugador;
import iAenemigos.IABuscador;
import mapa.Map;
import mapa.celda;

public class Buscador extends enemigo{
	
	protected jugador j;
	
	public Buscador(celda c, Map m,jugador j) {
		super(c, m);
		vida=100;
		velocidad=45;
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/buscador.png")));
		initgraph();
		IA=new IABuscador(j,this);
		this.j=j;
		
	}
	
	public void disparar(){}
	@Override
	public void descongelar() {
		IA=new IABuscador(j,this);	
	}

}
