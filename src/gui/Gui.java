package gui;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLayeredPane;
import javax.swing.*;


public class Gui extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;

	private JLayeredPane contentPane;
    private Thread t;
	protected volatile boolean keyBoardUpPressed=false; 
	protected volatile boolean keyBoardDownPressed=false;
	protected volatile boolean keyBoardLeftPressed=false;
	protected volatile boolean keyBoardRightPressed=false;
	
	private static Juego j;

	public Gui(final Juego j) {
		super("galaga");
		
       addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_UP ){
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
							else
								if(arg0.getKeyCode()==KeyEvent.VK_SPACE)
									j.mover(KeyEvent.VK_SPACE);				
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
		Gui.j=j;
		
		
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
/**
 * Metodo que se ejecutara siempre al crear la gui.
 */
public void run() {
	while(true){
			if(j.puedo())
				mover();		  
                   
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
}

}

