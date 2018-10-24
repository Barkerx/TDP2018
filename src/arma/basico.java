package arma;

import Player.jugador;
import disparo.Basico;

public class basico extends arma{

	public basico(jugador j) {
		super(j);
		maxDisparos=5;
		disparos=1;
		// TODO Auto-generated constructor stub
	}

	@Override
	public arma levelUP() {
		return new lazer(j);
		
	}
	public void aumentarDisparo(){
		if(disparos<maxDisparos)
			disparos=disparos+1;
	}	

	public void getDisparo() {
		switch(disparos){
		case 1:new Basico(j.getcelda(),j.getmap(),j);break;
		case 2:
			if(j.getceldaizq()!=j.getcelda())
			new Basico(j.getceldaizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Basico(j.getceldader(),j.getmap(),j);
			break;
		case 3:
			if(j.getceldaizq()!=j.getcelda())
			new Basico(j.getceldaizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Basico(j.getceldader(),j.getmap(),j);
			new Basico(j.getcelda(),j.getmap(),j);
			break;
		case 4:
			if(j.getceldaizq()!=j.getcelda())
			new Basico(j.getceldaizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Basico(j.getceldader(),j.getmap(),j);
			if(j.getceldaizq()!=j.getcelda())
			new Basico(j.getceldaizqizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Basico(j.getceldaderder(),j.getmap(),j);
			break;
		case 5:
			if(j.getceldaizq()!=j.getcelda())
			new Basico(j.getceldaizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Basico(j.getceldader(),j.getmap(),j);
			if(j.getceldaizq()!=j.getcelda())
			new Basico(j.getceldaizqizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Basico(j.getceldaderder(),j.getmap(),j);
			new Basico(j.getcelda(),j.getmap(),j);
			break;
		}
	
	}
	
}
