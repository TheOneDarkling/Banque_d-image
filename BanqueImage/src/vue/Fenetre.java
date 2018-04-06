package vue;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Fenetre extends Frame implements WindowListener {
	
	public Fenetre(){
		this.setLayout(new BorderLayout());
		Afficher_images canvasmilieu=new Afficher_images();
	
		Afficher_Fleche canvasbas=new Afficher_Fleche();
		this.add(canvasbas, BorderLayout.SOUTH);
		BarreTri canvasG=new BarreTri();
		this.add(canvasG,BorderLayout.WEST);
		
		BarreRecherche canvasHaut=new BarreRecherche();
		this.add(canvasHaut,BorderLayout.NORTH);
		this.add(canvasmilieu);
		
		
		this.addWindowListener(this);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Fenetre();

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
