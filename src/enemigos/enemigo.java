package enemigos;

import iAenemigos.*;
import mapa.Map;
import mapa.celda;
import misc.Unidad;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import disparo.disparoEnemy;
import gui.Juego;


public class enemigo extends enemigoAbstract{
	private static final int maxVida=100;
	/**
	 * constructor del enemigo, lo crea y pone los graficos.
	 * @param c celda donde va a estar el enemigo
	 * @param m mapa donde va a estar el enemigo
	 * @param a forma de atacar que tendra el enemigo
	 */
		
	
	public enemigo(celda c,Map m,Juego j) {
		profundidad=1;
		this.c=c;
		c.setelem(profundidad,this);
		this.m=m;
		puntos=300;
		shieldL=null;
		vida=maxVida;
		velocidad=16;
		x=c.getposx();
		y=c.getposy();
		visitor=new visitorEnemigo(this);
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/enemigo.png")));
		initgraph();
		Random r=new Random();
		int a=r.nextInt(3);
		switch (a){
		
		case 0:ataque = new Buscador(j,this);
				break;
		case 1:ataque = new Kamikaze(j,this);
				break;
		case 2:ataque = new BuscadorTemporal(j,this);		
				break;	
		}
			
	}
	public void disparar() {
		if(isRunning)
			new disparoEnemy(c,m);
	}

	
}
