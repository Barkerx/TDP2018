package enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import iAenemigos.IABuscador;
import iAenemigos.IAMareado;
import mapa.Map;
import mapa.celda;

public class Temporal extends enemigo {
	protected jugador j;
	protected boolean cambio=false;
	public Temporal(celda c, Map m, jugador jugador) {
		super(c, m);
		vida=130;
		velocidad=40;
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/enemigo.png")));
		initgraph();
		IA=new IABuscador(jugador,this);
		j=jugador;
	}

	@Override
	public void descongelar() {
		if(cambio)
			IA=new IAMareado(this);
		else
			IA=new IABuscador(j,this);
	}
	
	public void reducirVida(int n){
		super.reducirVida(n);
		if(vida<(130/2)&&!cambio)
			{IA=new IAMareado(this);
				cambio=true;
			}
	}

}
