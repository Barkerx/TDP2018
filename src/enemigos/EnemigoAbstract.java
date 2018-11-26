package enemigos;

import javax.swing.ImageIcon;

import inteligencias.IADormido;
import inteligencias.Inteligencia;
import mapa.Celda;
import misc.Visitor;
import misc.Nave;

public abstract class EnemigoAbstract extends Nave{
	protected Inteligencia IA;
	protected boolean mori=false;
	public abstract void disparar();
	
	@Override
	public boolean Accept(Visitor V) {
			return V.visitenemigo(this);
	}
	public void setCelda(Celda c )
	{
		this.c=c;
		c.setelem(profundidad,this);
	}
	/**
	 * redefine el metodo eliminar de Gob, lo desrelaciona con el mapa, se desvincula de la IA que lo maneja, y luego se destruye.
	 */
	public void destruir(){
	if(isRunning&&!mori){
		mori=true;
		m.desligar(this);
		explotar();
		super.destruir();
		}
	}
	public void explotar(){
		m.movegraph(this);
	}
	
	public void run(){
		if(mori){
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/2kvacl.gif")));
		grafico.setBounds(x*45, y*45, 45, 45);
		m.addgraph(grafico);
		try {
			EnemigoAbstract.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		grafico.setIcon(null);
		}else
			super.run();
	}
/**
 * retorna la cantidad de puntos asociada al enemigo
 * @return puntos del enemigo
 */
	public int getpuntos() {
		return puntos;
	}
	
public Celda getcelda() {
	return c;
}

public void restart() {
	m.restart(this);
}

public abstract void mover();

public Inteligencia getIA() {
	return IA;
}

public void setIA(Inteligencia ia) {
	IA=ia;
}

//crear un enemmigo para cada IA, y que se encargue el enemigo de hacer el movimiento de IA DEBIDO

}
