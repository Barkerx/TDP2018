package enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import inteligencias.IABuscador;
import mapa.Mapa;
import mapa.Celda;
import misc.Visitor;
import player.Jugador;

public class Buscador extends Enemigo{
	
	protected Jugador j;
	
	public Buscador(Celda c, Mapa m,Jugador j) {
		super(c, m);
		vida=100;
		velocidad=45;
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/buscador.png")));
		initgraph();
		visitor=new VisitorBuscador(this);
		IA=new IABuscador(j,this);
		this.j=j;
		
	}
	
	public void disparar(){}
	
	@Override
	public boolean Accept(Visitor v){
		return v.visitBuscador(this);
	}
	
}