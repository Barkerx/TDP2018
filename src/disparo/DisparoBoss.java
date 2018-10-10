package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Map;
import mapa.celda;
import misc.Unidad;

public class DisparoBoss extends DisparoE{
	private int dir;
	public DisparoBoss(celda c, Map m,int dir) {
		this.c=c;
		this.m=m;
		profundidad=2;
		velocidad=30;
		damage=50;
		this.dir=dir;
		shieldL=null;
		moviendo=false;
		visitor=new visitorDisparoE(this);
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/misilinv.png")));
		initgraph();
		new DisparoRun(this);
	}
	
	public void mover(){
		celda ce = null;
		if(isRunning){
	//		while(isRunning){
			ce=super.mover(dir);
				if (ce==null)
				{	
					destruir();
				}
			
		//	}
		}	
	}

}
