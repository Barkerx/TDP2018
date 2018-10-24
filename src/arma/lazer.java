package arma;

import Player.jugador;
import disparo.Basico;
import disparo.Laser;

public class lazer extends arma{

	public lazer(jugador j) {
		super(j);
		disparos=1;
		maxDisparos=3;
		// TODO Auto-generated constructor stub
	}

	@Override
	public arma levelUP() {
		// TODO Auto-generated method stub
		return new misil(j);
	}

	@Override
	public void getDisparo() {
		switch(disparos){
		case 1:new Laser(j.getcelda(),j.getmap(),j);break;
		case 2:{
			if(j.getceldaizq()!=j.getcelda())
			new Laser(j.getceldaizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Laser(j.getceldader(),j.getmap(),j);
			}break;
		case 3:{
			if(j.getceldaizq()!=j.getcelda())
			new Laser(j.getceldaizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Laser(j.getceldader(),j.getmap(),j);
			new Laser(j.getcelda(),j.getmap(),j);
			}break;
		}
	}
}