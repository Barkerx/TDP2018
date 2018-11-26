package enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Player.jugador;
import iAenemigos.IABuscador;
import mapa.Mapa;
import mapa.celda;
import misc.Visitor;

public class Buscador extends enemigo{
	
	protected jugador j;
	
	public Buscador(celda c, Mapa m,jugador j) {
		super(c, m);
		vida=100;
		velocidad=45;
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/buscador.png")));
		initgraph();
		visitor=new visitorBuscador(this);
		IA=new IABuscador(j,this);
		this.j=j;
		
	}
	
	public void disparar(){}
	
	@Override
	public boolean Accept(Visitor v){
		return v.visitBuscador(this);
	}
	
}