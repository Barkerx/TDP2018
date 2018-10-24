package arma;

import Player.jugador;
import disparo.Basico;
import disparo.Misil;

public class misil extends arma{

	public misil(jugador j) {
		super(j);
		disparos=1;
		maxDisparos=3;
	}

	@Override
	public arma levelUP() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void getDisparo() {
		switch(disparos){
		case 1:new Misil(j.getcelda(),j.getmap(),j);break;
		case 2:{
			if(j.getceldaizq()!=j.getcelda())
			new Misil(j.getceldaizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Misil(j.getceldader(),j.getmap(),j);
			}break;
		case 3:{
			if(j.getceldaizq()!=j.getcelda())
			new Misil(j.getceldaizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Misil(j.getceldader(),j.getmap(),j);
			new Misil(j.getcelda(),j.getmap(),j);
			}break;
		}
	}

}
