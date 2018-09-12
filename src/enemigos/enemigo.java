package enemigos;

import iAenemigos.FormaDeAtacar;
import mapa.celda;
import misc.nave;

public class enemigo extends nave{
	private FormaDeAtacar ataque;
	
	public enemigo(celda c,FormaDeAtacar a) {
		super(c);
		ataque = a;
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}

}
