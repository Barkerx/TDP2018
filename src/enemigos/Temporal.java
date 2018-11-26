package enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import disparo.disparoEnemy;
import iAenemigos.IABuscador;
import iAenemigos.IAMareado;
import mapa.Mapa;
import mapa.celda;

public class Temporal extends enemigo {
	private static final int vidaMax=130;
	protected int n;
	protected jugador j;
	protected boolean cambio=false;
	public Temporal(celda c, Mapa m, jugador j) {
		super(c, m);
		vida=vidaMax;
		velocidad=40;
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/temporal.png")));
		initgraph();
		IA=new IABuscador(j,this);
		this.j=j;
		n=0;
	}
	
	public void reducirVida(int n){
		super.reducirVida(n);
		if(vida<(vidaMax/2)&&!cambio)
			{ 	
				IA=new IAMareado(this);
				cambio=true;
			}
	}
	
	public void disparar() {
		if(isRunning)
			new disparoEnemy(c,m);
	}
	
}
