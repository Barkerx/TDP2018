package arma;

import disparo.Dmisil;
import nave.player.Jugador;

public class Amisil extends Arma{

	public Amisil(Jugador j) {
		super(j);
		disparos=1;
		maxDisparos=3;
	}

	@Override
	public Arma levelUP() {
		return this;
	}

	@Override
	public void getDisparo() {
		switch(disparos){
		case 1:new Dmisil(j.getcelda(),j.getmap(),j);break;
		case 2:{
			if(j.getceldaizq()!=j.getcelda())
			new Dmisil(j.getceldaizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Dmisil(j.getceldader(),j.getmap(),j);
			}break;
		case 3:{
			if(j.getceldaizq()!=j.getcelda())
			new Dmisil(j.getceldaizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Dmisil(j.getceldader(),j.getmap(),j);
			new Dmisil(j.getcelda(),j.getmap(),j);
			}break;
		default:break;	
		}
	}

}
