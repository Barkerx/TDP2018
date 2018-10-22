package iAenemigos;

import enemigos.enemigo;
import enemigos.enemigoAbstract;

public class IADormido extends FormaDeAtacar{

	public IADormido(enemigoAbstract e) {
		this.e=e;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int mover() {
		return 20;
	}

}
