package arma;

import Player.jugador;
import disparo.Misil;

public class misil extends arma{

	public misil(jugador j) {
		super(j);
	}

	@Override
	public arma levelUP() {
		// TODO Auto-generated method stub
		return new misil(j);
	}

	@Override
	public void getDisparo() {
		if(j.cantDisparos()==1)
			new Misil(j.getcelda(),j.getmap(),j);
			else
				if(j.cantDisparos()==2)
				{
					if(j.getceldaizq()!=null)
						new Misil(j.getceldaizq(),j.getmap(),j);
					if(j.getceldader()!=null)
						new Misil(j.getceldader(),j.getmap(),j);
				}
				else
					if(j.cantDisparos()==3){
						if(j.getceldaizq()!=null)
							new Misil(j.getceldaizq(),j.getmap(),j);
						if(j.getceldader()!=null)
							new Misil(j.getceldader(),j.getmap(),j);
						new Misil(j.getcelda(),j.getmap(),j);
					}
		
		}

}
