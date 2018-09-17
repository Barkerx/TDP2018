package disparo;

import mapa.Map;
import mapa.celda;
import misc.Visitor;

public class DisparoE extends Disparo{

	public DisparoE(celda ce, Map m) {
		super(ce, m);
		damage=30;
		visitor=new visitorDisparoE(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean Accept(Visitor V) {
		// TODO Auto-generated method stub
		return V.visitDisparoEnemigo(this);
	}
	public void mover(){
		boolean sigo=true;
		while(sigo){
			celda ce=super.mover(ABAJO);
			if (ce==null){
				destruir();
				sigo=false;
				}	
		}
	}
}
