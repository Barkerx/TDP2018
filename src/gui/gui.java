package gui;
import javax.swing.border.EmptyBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLayeredPane;
import javax.swing.*;


public class gui extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;

	private JLayeredPane contentPane;
    private Thread t;
	protected boolean keyBoardUpPressed;

	protected boolean keyBoardDownPressed;

	protected boolean keyBoardLeftPressed;

	protected boolean keyBoardRightPressed;
	
  	protected boolean keyBoardSPACEPressed;
	private static Juego j;

	public gui(final Juego j) {	
		super("galaga");
       addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_UP &&j.puedo()){
					keyBoardUpPressed=true;
				}
				else
					if(arg0.getKeyCode()==KeyEvent.VK_DOWN&&j.puedo()){
						keyBoardDownPressed=true;
					}
					else
						if(arg0.getKeyCode()==KeyEvent.VK_LEFT&&j.puedo()){
							keyBoardLeftPressed=true;
						}
						else
							if(arg0.getKeyCode()==KeyEvent.VK_RIGHT&&j.puedo()){
								keyBoardRightPressed=true;
							}
							else
								if(arg0.getKeyCode()==KeyEvent.VK_SPACE&&j.puedo())
									keyBoardSPACEPressed=true;				
			}
			public void keyReleased(KeyEvent arg0){
				if(arg0.getKeyCode()==KeyEvent.VK_UP&&j.puedo()){
					keyBoardUpPressed=false;
				}
				else
					if(arg0.getKeyCode()==KeyEvent.VK_DOWN&&j.puedo()){
						keyBoardDownPressed=false;
					}
					else
						if(arg0.getKeyCode()==KeyEvent.VK_LEFT&&j.puedo()){
							keyBoardLeftPressed=false;
						}
						else
							if(arg0.getKeyCode()==KeyEvent.VK_RIGHT&&j.puedo()){
								keyBoardRightPressed=false;
							}
							else
								if(arg0.getKeyCode()==KeyEvent.VK_SPACE&&j.puedo())
									keyBoardSPACEPressed=false;
							
							
			}
			
				
    });
        //crea la ventana de la gui.
		getContentPane().setLayout(null);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 910, 710);
		setLocationRelativeTo(null);
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//inicializa la gui
		
		t=new Thread(this);
		t.start();
		gui.j=j;
		
		
	}
	
private void mover(){
	 if(keyBoardLeftPressed&&j.puedo()){
     	  j.mover(KeyEvent.VK_LEFT);
       }
       else
     	  if(keyBoardRightPressed&&j.puedo()){
     		  j.mover(KeyEvent.VK_RIGHT);
           }
           else
         	  if(keyBoardDownPressed&&j.puedo()){
         		  j.mover(KeyEvent.VK_DOWN);
               }
               else
             	  if(keyBoardUpPressed&&j.puedo()){
             		  j.mover(KeyEvent.VK_UP);
                   }
             	  else
             		  if(keyBoardSPACEPressed&&j.puedo())
             			  j.mover(KeyEvent.VK_SPACE);
}
/**
 * Metodo que se ejecutara siempre al crear la gui.
 */
public void run() {
	while(true){
			
              mover();		  
                   
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
}

}

