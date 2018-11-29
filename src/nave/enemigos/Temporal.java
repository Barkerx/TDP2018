package nave.enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import disparo.DisparoEnemy;
import nave.enemigos.inteligencias.IABuscador;
import nave.enemigos.inteligencias.IAMareado;
import mapa.Mapa;
import nave.player.Jugador;
import mapa.Celda;

public class Temporal extends Enemigo {
	private static final int vidaMax=130;
	protected int n;
	protected Jugador j;
	protected boolean cambio=false;
	public Temporal(Celda c, Mapa m, Jugador j) {
		super(c, m,55,vidaMax,40);
		vida=vidaMax;
		velocidad=40;
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/temporal.png")));
	//	initgraph();
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
