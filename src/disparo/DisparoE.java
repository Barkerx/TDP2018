package disparo;


import mapa.celda;
import misc.Unidad;
import misc.Visitor;

public abstract class DisparoE extends Disparo{
	

	@Override
	public boolean Accept(Visitor V) {
		// TODO Auto-generated method stub
		return V.visitDisparoEnemigo(this);
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

