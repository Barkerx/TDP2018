package nave.player.escudo;

import javax.swing.JLabel;
import nave.player.Jugador;
import visitor.Visitor;

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
	
	public JLabel getImage(){
		return image;
	}
	public abstract void levelUp();
	public abstract Visitor getVisitor();
	public abstract boolean accept(Visitor v);
	/**
	 * Metodo usado para destruir el escudo 
	 */
	public abstract void destruir();

}
