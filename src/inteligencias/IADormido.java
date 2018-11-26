package inteligencias;

import enemigos.EnemigoAbstract;

public class IADormido extends Inteligencia{

	public IADormido(EnemigoAbstract e) {
		this.e=e;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int mover() {
		return 20;
	}

}
