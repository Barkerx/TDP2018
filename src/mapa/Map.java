package mapa;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import enemigos.enemigo;
import gui.Juego;
import gui.gui;
import misc.Unidad;

public class Map {
	protected celda[][] celdas;
	protected gui g;
	protected JLabel fondo;
//	protected IA[] EIA;
	protected LinkedList<enemigo> lEnemy;
	protected Juego j;
	public Map(gui gu,Juego ju,jugador p){
		int x=8;
		int y=15;
		g=gu;
		celdas=new celda[x][y];
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
				celdas[i][j]=new celda(i,j);
		
		p.setCelda(celdas[5][5]);
		celdas[5][5].setelem(p.getProfundidad(), p);
		g.setResizable(false);
		p.setMap(this);
		lEnemy=new LinkedList<enemigo>();
		fondo=new JLabel(new ImageIcon(this.getClass().getResource("/resources/fondo.png")));
   	 	fondo.setBounds(0, 0, 405, 765);
   	 	g.add(fondo,new Integer(0));
   	 	
   	 	p.initgraph();
   	 	
	}
	public celda mover(celda celda, int dir) {
		// TODO Auto-generated method stub
		celda c;
		int x=celda.getposx();
		int y=celda.getposy();
		switch (dir){
		case Unidad.ABAJO:y=y+1; break;
	//	case 1:x=x-1;y=y+1; break;
		case Unidad.IZQUIERDA:x=x-1; break;
	//	case 3:x=x-1;y=y-1; break;
		case Unidad.ARRIBA:y=y-1; break;
//		case 5:x=x+1;y=y-1; break;
		case Unidad.DERECHA:x=x+1;break;
//		case 7:x=x+1;y=y+1; break;
		}
		if(x==celdas.length || y==celdas[0].length || y<0 || x<0)	
			c=null;
			else
				c=celdas[x][y];
		return c;
	}
	public void addgraph(JLabel grafico) {
		fondo.add(grafico);
		fondo.repaint();
		
	}
	public void desligar(enemigo enemigo) {
		j.addpuntos(enemigo.getpuntos());
		lEnemy.remove(enemigo);
		
	}
	
}
