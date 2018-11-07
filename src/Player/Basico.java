package Player;


public class Basico extends shield{

	public Basico(jugador j){
		super(j);
		puntos=0;
		image=null;
	}
	
	@Override
	public void levelUp() {
		j.setShield(new Mejorado(j));
	}
	
}
