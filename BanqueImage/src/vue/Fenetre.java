package vue;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import controleur.ControleurAffichage;
import controleur.ControleurRecherche;
import modele.Biblio;

public class Fenetre extends Frame implements WindowListener {

	public Fenetre() {
		try {
			Biblio b = new Biblio();
			ControleurAffichage ctrlAff = new ControleurAffichage(b);
			ControleurRecherche ctrlRech = new ControleurRecherche(b);
			
			this.setLayout(new BorderLayout());
			
			BarreTri bTri = new BarreTri(ctrlRech);
			this.add(bTri, BorderLayout.WEST);

			BarreRecherche bRecherche = new BarreRecherche(ctrlRech);
			this.add(bRecherche, BorderLayout.NORTH);
			
			Afficher_images images = new Afficher_images(b);
			images.addMouseListener(ctrlAff);
			b.addObserver(images);
			this.add(images);

			
			Afficher_Fleche fleches = new Afficher_Fleche(b);
			fleches.addMouseListener(ctrlAff);
			b.addObserver(fleches);
			
			Note notes = new Note(b);
			
			BasDePage bdp = new BasDePage(fleches, notes);
			b.addObserver(bdp);
			
			this.add(bdp, BorderLayout.SOUTH);
			

			this.addWindowListener(this);
			this.pack();
			this.setVisible(true);

		} catch (IOException e) {
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
