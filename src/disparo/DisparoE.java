package disparo;



import mapa.Mapa;
import mapa.Celda;
import unidad.Unidad;
import visitor.Visitor;
import visitor.VisitorDisparoE;

public abstract class DisparoE extends Disparo{
	
	protected DisparoE(Celda c,Mapa m){
		super(c,m);
		visitor=new VisitorDisparoE(this);
		
	}
	@Override
	public boolean Accept(Visitor V) {
		return V.visitDisparoEnemigo(this);
	}
	public void mover(){
		Celda ce=c;
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

