package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Mapa;
import mapa.celda;
import misc.Unidad;

public class DisparoBoss extends DisparoE{
	public DisparoBoss(celda c, Mapa m) {
		super(c,m);
		velocidad=35;
		damage=50;
		x=c.getposx();
		y=c.getposy();
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/misilinv.png")));
		initgraph();
		m.addDisparo(this);
		//new DisparoRun(this,m);
	}
	
	public void mover(){
		celda ce = null;
		if(isRunning){
	//		while(isRunning){
			ce=super.mover(Unidad.ABAJO);
				if (ce.getposy()==m.getmaxY())
				{	
					destruir();
				}
			
		//	}
		}	
	}

}
