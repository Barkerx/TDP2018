package enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoEnemy;
import inteligencias.IABuscador;
import inteligencias.IAMareado;
import mapa.Mapa;
import player.Jugador;
import mapa.Celda;

public class Temporal extends Enemigo {
	private static final int vidaMax=130;
	protected int n;
	protected Jugador j;
	protected boolean cambio=false;
	public Temporal(Celda c, Mapa m, Jugador j) {
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
			new DisparoEnemy(c,m);
	}
	
}
