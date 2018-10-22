package arma;

import Player.jugador;
import disparo.Basico;

public class basico extends arma{

	public basico(jugador j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public arma levelUP() {
		return new lazer(j);
		
	}

	public void getDisparo() {
	if(j.cantDisparos()==1)
		new Basico(j.getcelda(),j.getmap(),j);
		else
			if(j.cantDisparos()==2)
			{
				if(j.getceldaizq()!=j.getcelda())
				new Basico(j.getceldaizq(),j.getmap(),j);
				if(j.getceldader()!=j.getcelda())
				new Basico(j.getceldader(),j.getmap(),j);
			}
			else
				if(j.cantDisparos()==3){
					if(j.getceldaizq()!=j.getcelda())
					new Basico(j.getceldaizq(),j.getmap(),j);
					if(j.getceldader()!=j.getcelda())
					new Basico(j.getceldader(),j.getmap(),j);
					new Basico(j.getcelda(),j.getmap(),j);
				}
	
	}
	
}
