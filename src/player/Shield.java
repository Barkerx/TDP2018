package player;
import javax.swing.JLabel;

import misc.Visitor;

public abstract class Shield {
	
	protected Visitor v;
	protected JLabel image;
	protected Jugador j;
	protected int puntos;
	
	protected Shield(Jugador j){
		this.j=j;
		image=null;
	}
	public void reducirVida(int n)	{
	if(puntos>0){
		puntos--;
		if (puntos==0)
			j.setShield(new Ebasico(j));
		}
		else
		{
			j.setVida(j.getVida()-n);
		}
}
	
	// XXX hacer visitor para el escudo y hacer el visitor del kamikaze XXX
	
	public JLabel getImage(){
		return image;
	}
	public abstract void levelUp();
	public abstract Visitor getVisitor();
	public abstract boolean accept(Visitor v);
	public abstract void destruir();

}
