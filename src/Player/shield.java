package Player;
import javax.swing.JLabel;

public abstract class shield {
	
	protected JLabel image;
	protected jugador j;
	protected int puntos;
	
	protected shield(jugador j){
		this.j=j;
		image=null;
	}
	public void reducirVida(int n)	{
	if(puntos>0){
		puntos--;
		if (puntos==0)
			j.setShield(new Basico(j));
			
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
}
