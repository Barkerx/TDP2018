package mapa;

import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import PowerUP.MejorarDisparo;
import PowerUP.powerUp;
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
	
	/**
	 * Crea el mapa con una gui, un juego y un jugador
	 * @param gu Gui donde se pondran los objetos graficos del mapa
	 * @param ju Juego que maneja al mapa
	 * @param p jugador del mapa
	 */
	public Map(gui gu,Juego ju,jugador p){
		int x=8;
		int y=15;
		g=gu;
		//inicializo la matriz de celdas
		celdas=new celda[x][y];
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
				celdas[i][j]=new celda(i,j);
		
		//agrego el personaje a la posicion 5 5
		p.setCelda(celdas[5][5]);
		celdas[5][5].setelem(p.getProfundidad(), p);
		p.setMap(this);
		//creo la lista de enemigos 
		lEnemy=new LinkedList<enemigo>();
		g.setResizable(false);
		fondo=new JLabel(new ImageIcon(this.getClass().getResource("/resources/fondo.png")));
   	 	fondo.setBounds(0, 0, 405, 765);
   	 	g.add(fondo,new Integer(0));
   	 	this.j=ju;
   	 	p.initgraph();
   	 	//creo un enemigo
   	 	
   	 	enemigo e=new enemigo(celdas[1][1],this,null);
   	 	celdas[1][1].setelem(e.getProfundidad(),e);
   	 	lEnemy.add(e);
   	 	e.initgraph();
		//creo 2 power ups
   	 	powerUp po=new MejorarDisparo(celdas[3][3],this);
   	    celdas[3][3].setelem(po.getProfundidad(), po);
   	    powerUp p1=new MejorarDisparo(celdas[6][6],this);
	    celdas[6][6].setelem(p1.getProfundidad(), p1);
	
	
	}
	/**
	 * Metodo que a partir de una celda C y una direccion dir retorna la celda que esta al lado de C
	 * @param celda celda de origen
	 * @param dir direccion a la cual se desea mover
	 * @return La celda a moverse, si es una celda permitida, null si es invalida.
	 */
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
		case -1:break;
		}
		if(x==celdas.length || y==celdas[0].length || y<0 || x<0 )	
			c=null;
			else
				c=celdas[x][y];
		return c;
	}
	/**
	 * Agrega al mapa el JLabel grafico  
	 * @param grafico Jlabel que se agregara al mapa
	 */
	public void addgraph(JLabel grafico) {
		fondo.add(grafico);
		fondo.repaint();
		
	}
	/**
	 * Separa el enemigo del mapa, asi ya no hay mas relacion entre ellos, es usado al eliminar un enemigo.
	 * @param enemigo enemigo al que se desea separar del mapa.
	 */
	public void desligar(enemigo enemigo) {

		lEnemy.remove(enemigo);
		j.addpuntos(enemigo.getpuntos());
	}
	
}
