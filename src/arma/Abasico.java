package arma;

import disparo.Dbasico;
import player.Jugador;

public class Abasico extends Arma{

	public Abasico(Jugador j) {
		super(j);
		maxDisparos=5;
		disparos=1;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Arma levelUP() {
		return new Alazer(j);
		
	}
	public void aumentarDisparo(){
		if(disparos<maxDisparos)
			disparos=disparos+1;
	}	

	public void getDisparo() {
		switch(disparos){
		case 1:new Dbasico(j.getcelda(),j.getmap(),j);break;
		case 2:
			if(j.getceldaizq()!=j.getcelda())
			new Dbasico(j.getceldaizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Dbasico(j.getceldader(),j.getmap(),j);
			break;
		case 3:
			if(j.getceldaizq()!=j.getcelda())
			new Dbasico(j.getceldaizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Dbasico(j.getceldader(),j.getmap(),j);
			new Dbasico(j.getcelda(),j.getmap(),j);
			break;
		case 4:
			if(j.getceldaizq()!=j.getcelda())
			new Dbasico(j.getceldaizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Dbasico(j.getceldader(),j.getmap(),j);
			if(j.getceldaizq()!=j.getcelda())
			new Dbasico(j.getceldaizqizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Dbasico(j.getceldaderder(),j.getmap(),j);
			break;
		case 5:
			if(j.getceldaizq()!=j.getcelda())
			new Dbasico(j.getceldaizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Dbasico(j.getceldader(),j.getmap(),j);
			if(j.getceldaizq()!=j.getcelda())
			new Dbasico(j.getceldaizqizq(),j.getmap(),j);
			if(j.getceldader()!=j.getcelda())
			new Dbasico(j.getceldaderder(),j.getmap(),j);
			new Dbasico(j.getcelda(),j.getmap(),j);
			break;
		}
	
	}
	
}
