package vue;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import controleur.ControleurAffichage;
import modele.Biblio;

public class Fenetre extends Frame implements WindowListener {

	public Fenetre() {
		Biblio b;
		try {
			b = new Biblio();
			this.setLayout(new BorderLayout());
			Afficher_images canvasmilieu = new Afficher_images(b);
			Afficher_Fleche canvasbas = new Afficher_Fleche(b);

			b.addObserver(canvasmilieu);
			b.addObserver(canvasbas);
			
			canvasbas.addMouseListener(new ControleurAffichage(b));
			
			BarreTri canvasG = new BarreTri();
			this.add(canvasG, BorderLayout.WEST);

			BarreRecherche canvasHaut = new BarreRecherche();
			this.add(canvasHaut, BorderLayout.NORTH);
			this.add(canvasmilieu);

			/*Note test = new Note(b);

			this.add(test, BorderLayout.SOUTH);*/
			this.add(canvasbas, BorderLayout.SOUTH);

			this.addWindowListener(this);
			this.pack();
			this.setVisible(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
