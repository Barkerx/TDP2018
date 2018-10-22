package enemigos;

import iAenemigos.FormaDeAtacar;
import iAenemigos.IADormido;
import iAenemigos.IAMareado;
import mapa.celda;
import misc.Visitor;
import misc.nave;

public abstract class enemigoAbstract extends nave{
	protected FormaDeAtacar IA;
	
	public abstract void disparar();
	
	@Override
	public boolean Accept(Visitor V) {
			return V.visitenemigo(this);
	}
	public void setCelda(celda c )
	{
		this.c=c;
		c.setelem(profundidad,this);
	}
	/**
	 * redefine el metodo eliminar de Gob, lo desrelaciona con el mapa, se desvincula de la IA que lo maneja, y luego se destruye.
	 */
	public void destruir(){
		if(isRunning){
		m.desligar(this);
	//	explotar();
		super.destruir();
		}
	}
	
/**
 * retorna la cantidad de puntos asociada al enemigo
 * @return puntos del enemigo
 */
	public int getpuntos() {
		return puntos;
	}

	public abstract void congelar();
	
public celda getcelda() {
	// TODO Auto-generated method stub
	return c;
}

public void restart() {
	m.restart(this);
}

public abstract void mover();


public abstract void descongelar();

}
//crear un enemmigo para cada IA, y que se encargue el enemigo de hacer el movimiento de IA DEBIDO