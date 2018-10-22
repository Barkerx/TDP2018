package disparo;



import mapa.Map;
import mapa.celda;
import misc.Unidad;
import misc.Visitor;

public abstract class DisparoE extends Disparo{
	
	protected DisparoE(celda c,Map m){
		super(c,m);
		visitor=new visitorDisparoE(this);
		
	}
	@Override
	public boolean Accept(Visitor V) {
		// TODO Auto-generated method stub
		return V.visitDisparoEnemigo(this);
	}
	public void mover(){
		celda ce=c;
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

