package arma;

import Player.jugador;
import disparo.Laser;

public class lazer extends arma{

	public lazer(jugador j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public arma levelUP() {
		// TODO Auto-generated method stub
		return new misil(j);
	}

	@Override
	public void getDisparo() {
		if(j.cantDisparos()==1)
			new Laser(j.getcelda(),j.getmap(),j);
			else
				if(j.cantDisparos()==2)
				{	
					if(j.getceldaizq()!=null)
						new Laser(j.getceldaizq(),j.getmap(),j);
					if(j.getceldader()!=null)
						new Laser(j.getceldader(),j.getmap(),j);
				}
				else
					if(j.cantDisparos()==3){
						if(j.getceldaizq()!=null)
							new Laser(j.getceldaizq(),j.getmap(),j);
						if(j.getceldader()!=null)
							new Laser(j.getceldader(),j.getmap(),j);
						new Laser(j.getcelda(),j.getmap(),j);
					}
		
		}

}
