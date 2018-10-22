package enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import disparo.disparoEnemy;
import gui.Juego;
import iAenemigos.boss;
import mapa.Map;
import mapa.celda;
import misc.Unidad;

public class Boss extends enemigo{

	private jugador j;
	public Boss(celda c, Map m, Juego j) {
		super(c,m);
		puntos=300;
		shieldL=null;
		vida=200;
		x=c.getposx();
		y=c.getposy();
		velocidad=45;
		visitor=new visitorEnemigo(this);
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/enemigo.png")));
		initgraph();
		this.j=j.getJugador();
		IA = new boss(j.getJugador(),this);
		}
		
		public void disparar(){
			new disparoEnemy(c,m);
		}
		@Override
		public void mover() {
			if(isRunning){
				int direccion=IA.mover();	
					celda ce=m.mover(c, direccion);
					if(c!=ce){
						mover(direccion);
					}
					else
						if(ce.getposy()==14&&direccion==Unidad.ABAJO)
							restart();
				}
			
				}

		@Override
		public void descongelar() {
			IA=new boss(j,this);
			
		}
}
