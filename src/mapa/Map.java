package mapa;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.Juego;
import gui.gui;
import misc.Unidad;

public class Map {
	protected celda[][] celdas;
	protected gui g;
//	protected IA[] EIA;
//	protected linkedList<Enemigos> lEnemy;
	protected Juego j;
	public Map(gui gu,Juego ju,Unidad p){
		int x=17;
		int y=9;
		g=gu;
		celdas=new celda[x][y];
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
				celdas[i][j]=new celda(x,j,this);
		
		p.setCelda(celdas[0][5]);
		celdas[0][5].setelem(p.getProfundidad(), p);
		g.setResizable(false);
		
		JLabel fondo=new JLabel(new ImageIcon(this.getClass().getResource("/resources/fondo.png")));
   	 	fondo.setBounds(0, 0, 256, 544);
   	 	g.add(fondo,new Integer(0));
	}
	public celda mover(celda celda, int dir) {
		// TODO Auto-generated method stub
		celda c;
		int x=celda.getposx();
		int y=celda.getposy();
		
		switch (dir){
		case 0:y=y++; break;
	//	case 1:x=x-1;y=y+1; break;
		case 2:x=x--; break;
	//	case 3:x=x-1;y=y-1; break;
		case 4:y=y--; break;
//		case 5:x=x+1;y=y-1; break;
		case 6:x=x+1;break;
//		case 7:x=x+1;y=y+1; break;
		}
		if(x==celdas.length || y==celdas[0].length || y<0 || x<0)	
			c=celda;
			else
				c=celdas[x][y];
		return c;
	}
	
}
