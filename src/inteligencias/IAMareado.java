package inteligencias;

import enemigos.EnemigoAbstract;
import misc.Unidad;

public class IAMareado extends Inteligencia{
	protected int dir;
	public IAMareado(EnemigoAbstract e) {
		this.e=e;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int mover() {
		int salida=0;
		if(e.getIsRunning()){
			dir=dir+1;	
			switch(dir){
			case 0:salida=Unidad.ABAJO;break;
			case 1:salida=Unidad.IZQUIERDA;break;
			case 2:salida=Unidad.ARRIBA;break;
			case 3:salida=Unidad.DERECHA;break;
			  }
			if(dir==3){
				dir=-1;}
			}

		
	return salida;}
	
}