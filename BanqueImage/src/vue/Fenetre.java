package vue;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import modele.Biblio;

public class Fenetre extends Frame implements WindowListener {

	public Fenetre() {
		Biblio b;
		try {
			b = new Biblio();
			this.setLayout(new BorderLayout());
			
			BarreTri bTri = new BarreTri();
			this.add(bTri, BorderLayout.WEST);

			BarreRecherche bRecherche = new BarreRecherche();
			this.add(bRecherche, BorderLayout.NORTH);
			
			Afficher_images images = new Afficher_images(b);
			b.addObserver(images);
			this.add(images);

			Note flechesNotes = new Note(b);

			this.add(flechesNotes, BorderLayout.SOUTH);
			

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
