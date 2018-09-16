package gui;
import javax.swing.border.EmptyBorder;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.swing.JLayeredPane;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;


public class gui extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;

	private JLayeredPane contentPane;
    private Thread t;
	protected boolean keyBoardUpPressed;

	protected boolean keyBoardDownPressed;

	protected boolean keyBoardLeftPressed;

	protected boolean keyBoardRightPressed;
	
	
	private static Juego j;

	public gui(final Juego j) {	
		super("galaga");
       addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_UP){
					keyBoardUpPressed=true;
				}
				else
					if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
						keyBoardDownPressed=true;
					}
					else
						if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
							keyBoardLeftPressed=true;
						}
						else
							if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
								keyBoardRightPressed=true;
							}	
							
			}
			public void keyReleased(KeyEvent arg0){
				if(arg0.getKeyCode()==KeyEvent.VK_UP){
					keyBoardUpPressed=false;
				}
				else
					if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
						keyBoardDownPressed=false;
					}
					else
						if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
							keyBoardLeftPressed=false;
						}
						else
							if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
								keyBoardRightPressed=false;
							}
							else
								if(arg0.getKeyCode()==KeyEvent.VK_SPACE)
								j.mover(KeyEvent.VK_SPACE);
							
							
			}
			
				
    });
        
		getContentPane().setLayout(null);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 405, 765);
		setLocationRelativeTo(null);
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		t=new Thread(this);
		t.start();
		gui.j=j;
		
		
	}
	
private void mover(){
	 if(keyBoardLeftPressed){
     	  j.mover(KeyEvent.VK_LEFT);
       }
       else
     	  if(keyBoardRightPressed){
     		  j.mover(KeyEvent.VK_RIGHT);
           }
           else
         	  if(keyBoardDownPressed){
         		  j.mover(KeyEvent.VK_DOWN);
               }
               else
             	  if(keyBoardUpPressed){
             		  j.mover(KeyEvent.VK_UP);
                   }
	
}

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

