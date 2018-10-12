package iAenemigos;

import enemigos.enemigo;
import gui.Juego;
import mapa.celda;

public class Buscador extends FormaDeAtacar{

	public Buscador(Juego j, enemigo e) {
		super(j, e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int mover() {
		int salida=j.getxy(e);
		return salida;
	}
		
	
}
