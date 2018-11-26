package inteligencias;

import enemigos.EnemigoAbstract;
import misc.Unidad;

public class IAKamikaze extends Inteligencia{
	
	protected int n;
	protected int piv;
	protected int disparo;
	public IAKamikaze(EnemigoAbstract e) {
		this.e=e;
		piv=0;
		n=0;
		disparo=0;
	}
	
	

	@Override
	public int mover(){
		int salida=-1;
			disparo=disparo+1;
			if(disparo!=2){
				if(n==0){
					n=1;
					salida=Unidad.IZQUIERDA;}
				else{
					n=0;
					salida=Unidad.DERECHA;}
				piv=piv+1;
				if(piv==4){
					piv=0;
					salida=Unidad.ABAJO;
					}
			}else{
					e.disparar();
					disparo=0;
				}
			return salida;
				
	}
	
}	
