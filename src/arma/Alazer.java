package arma;

import disparo.Dlazer;
import player.Jugador;

public class Alazer extends Arma{

	public Alazer(Jugador j) {
		super(j);
		disparos=1;
		maxDisparos=3;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Arma levelUP() {
		// TODO Auto-generated method stub
		return new Amisil(j);
	}

	@Override
	public void getDisparo() {
		switch(disparos){
		case 1:new Dlazer(j.getcelda(),j.getmap(),j);break;
		case 2:{
			if(j.getceldaizq()!=j.getcelda())
			new Dlazer(j.getceldaizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Dlazer(j.getceldader(),j.getmap(),j);
			}break;
		case 3:{
			if(j.getceldaizq()!=j.getcelda())
			new Dlazer(j.getceldaizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Dlazer(j.getceldader(),j.getmap(),j);
			new Dlazer(j.getcelda(),j.getmap(),j);
			}break;
		}
	}
}