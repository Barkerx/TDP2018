package nave.enemigos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import nave.enemigos.inteligencias.IABuscador;
import mapa.Mapa;
import mapa.Celda;
import visitor.Visitor;
import visitor.VisitorBuscador;
import nave.player.Jugador;

public class Buscador extends Enemigo{
	
	protected Jugador j;
	
	public Buscador(Celda c, Mapa m,Jugador j) {
		super(c, m,50,100,45);
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/buscador.png")));
		//initgraph();
		visitor=new VisitorBuscador(this);
		IA=new IABuscador(j,this);
		this.j=j;
		
	}
	
	public void disparar(){
		//Como el Enemigo Buscador no puede disparar, su disparar no hace nada.
	}
	
	@Override
	public boolean Accept(Visitor v){
		return v.visitBuscador(this);
	}
	
}