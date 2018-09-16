package enemigos;

import iAenemigos.FormaDeAtacar;
import mapa.Map;
import mapa.celda;
import misc.Visitor;
import misc.nave;

public class enemigo extends nave{
	private FormaDeAtacar ataque;
	
	public enemigo(celda c,Map m,FormaDeAtacar a) {
		super(c,m);
		ataque = a;
		visitor=new visitorEnemigo(this);
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Accept(Visitor V) {
		return V.visitenemigo(this);
	}

}
