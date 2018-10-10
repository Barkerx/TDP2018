package enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import disparo.disparoEnemy;
import gui.Juego;
import iAenemigos.boss;
import mapa.Map;
import mapa.celda;
import misc.Unidad;

public class Boss extends enemigoAbstract{

	
	public Boss(celda c, Map m, Juego j) {
		profundidad=1;
		this.c=c;
		c.setelem(profundidad,this);
		this.m=m;
		puntos=300;
		shieldL=null;
		vida=200;
		velocidad=16;
		visitor=new visitorEnemigo(this);
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/enemigo.png")));
		initgraph();
		ataque = new boss(j,this);
		}
		
		public void disparar(){
			new disparoEnemy(c,m);
		}
}


