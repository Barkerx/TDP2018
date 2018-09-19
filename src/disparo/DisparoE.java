package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Map;
import mapa.celda;
import misc.Visitor;

public class DisparoE extends Disparo{

	public DisparoE(celda c, Map m) {
		this.c=c;
		this.m=m;
		profundidad=2;
		velocidad=50;
		isRunning=true;
		damage=30;
		visitor=new visitorDisparoE(this);
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/disparo.png")));
		run();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean Accept(Visitor V) {
		// TODO Auto-generated method stub
		return V.visitDisparoEnemigo(this);
	}
	public void mover(){
			celda ce=super.mover(ABAJO);
			if (ce==null){
				destruir();
				}	
		}
	}

