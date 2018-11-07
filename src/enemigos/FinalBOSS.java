package enemigos;


import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import disparo.DisparoBoss;
import iAenemigos.IAFinalBoss;
import mapa.Mapa;
import mapa.celda;
import mapa.mapaBoss;
import misc.Unidad;

public class FinalBOSS extends enemigoAbstract{
	protected int b;
	private int disparos;
	private celda original;
	private LinkedList<FinalBOSS> lEnemy;
	public FinalBOSS(celda c,Mapa m,jugador j,JLabel l){
		profundidad=1;
		this.c=c;
		c.setelem(profundidad,this);
		this.m=m;
		velocidad=35;
		puntos=3000;
		x=c.getposx();
		y=c.getposy();
		grafico=l;
		shieldL=null;
		lEnemy=new LinkedList<FinalBOSS>();
		disparos=0;
		original=c;
		velocidad=16;
		IA=null;
		visitor=new visitorEnemigo(this);
		if(grafico!=null){
			initgraph();
			IA=new IAFinalBoss(this,j);
		}
	}
	public void disparar() {
		disparos++;
		new DisparoBoss(c,m);
	}
	public void reducirVida(int n){
		mapaBoss ma=(mapaBoss) m;
		ma.reducirVida(n);
	}
	public void initgraph(){
		if(grafico!=null){
	 	 grafico.setBounds(c.getposx()*45, c.getposy()*45, 170 , 260);
         m.addgraph(grafico);
         }
	}
	public void destruir(){
		if(!mori&&isRunning){
		mori=true;
		c.setelem(profundidad, null);
		c=null;
		explotar();
		m=null;
		}
	}
		public void cambio(){
			velocidad=45;
		}
	
	public void run(){

	if(mori){
		if(grafico==null)
		grafico=new JLabel();
		int i=0;
		while(i<12){
			grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/2kvacl.gif")));
			grafico.setBounds(x*45,y*45,45,45);
			m.addgraph(grafico,3);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		grafico.setIcon(null);
		m.addgraph(grafico,3);	
		i=i+1;
			}
		}
	else
	{
		for(int i=0;i<9&&isRunning&&grafico!=null;i++){
			  switch(dir){
			  case ABAJO:
				  grafico.setBounds(c.getposx()*45, c.getposy()*45+5, 170, 260);
				  if(shieldL!=null)
					  shieldL.setBounds(grafico.getX()*45, grafico.getY()*45+5, 170, 260);
				  break;
			  case IZQUIERDA:
				  grafico.setBounds(c.getposx()*45-5, c.getposy()*45, 170, 260);
				  if(shieldL!=null)
					  shieldL.setBounds(grafico.getX()-5, grafico.getY(), 170, 260);
				  break;
			  case ARRIBA:
				  grafico.setBounds(c.getposx()*45, c.getposy()*45-5, 170, 260);
				  if(shieldL!=null)
					  shieldL.setBounds(grafico.getX(), grafico.getY()-5, 170, 260);
				  break;
			  case DERECHA:
				  grafico.setBounds(c.getposx()*45+5, c.getposy()*45, 170, 260);
				  if(shieldL!=null)
					  shieldL.setBounds(grafico.getX()+5, grafico.getY(), 170, 260);
				  break;
			  case ABAJOIZQUIERDA:
				  grafico.setBounds(grafico.getX()-5, grafico.getY()+5, 170, 260);
				  if(shieldL!=null)
					  shieldL.setBounds(grafico.getX()-5, grafico.getY()+5, 170, 260);
				  break;
			  case ABAJODERECHA:
				  grafico.setBounds(grafico.getX()+5, grafico.getY()+5, 170, 260);
				  if(shieldL!=null)
					  shieldL.setBounds(grafico.getX()+5, grafico.getY()+5, 170, 260);
				  break;	  
			  }
			  try{
				  Unidad.sleep(50-velocidad);
			  }catch(InterruptedException e){
				  
			  }
		  }
		this.interrupt();
		}
		
	}
	public void kill() {
		mori=true;
	}

	public celda mover(int n) {
			super.mover(n);
		return null;
	}
	
	public int getDisparos(){
		return disparos;
	}
	
	public void reset() {
		for(FinalBOSS e:lEnemy)
			e.reset();
		if(isRunning){	
			moviendo=true;
			original.setelem(profundidad,this);
			c.setelem(profundidad,null);
			c=original;
			x=original.getposx();
			y=original.getposy();
			moviendo=false;
			initgraph();
			}
	}
	public void setPartner(FinalBOSS e2) {
		lEnemy.add(e2);
	}
	public LinkedList<FinalBOSS> getPartner(){
		return lEnemy;
	}
	@Override
	public void mover() {
		int n=IA.mover();
			for(FinalBOSS e:lEnemy)
				e.mover(n);
			super.mover(n);
		
	}
	
	
	
	
}