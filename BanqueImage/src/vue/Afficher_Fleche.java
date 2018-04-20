package vue;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;

import modele.Biblio;

public class Afficher_Fleche extends Canvas implements Observer  {
	Image img;
	Image img_inv;
	Biblio image;

	int largeur = (int) modele.Constantes.w * 2 / 3 + (int) modele.Constantes.w * 1 / 10;
	int hauteur = (int) modele.Constantes.h * 1 / 12;

	public Afficher_Fleche(Biblio b) {
		this.setName("fleches");
		this.image = b;

		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(largeur, hauteur));
		try {
			img = ImageIO.read(new File("fleche.png")).getScaledInstance(hauteur, hauteur, Image.SCALE_DEFAULT);
			img_inv = ImageIO.read(new File("fleche_inv.png")).getScaledInstance(hauteur, hauteur, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			throw new RuntimeException("L'image fleche.png est introuvable");
		}

	}

	public void paint(Graphics g) {
		g.drawImage(img, largeur - hauteur, 0, hauteur, hauteur, null);
		g.drawImage(img_inv, (int) modele.Constantes.w * 1 / 10, 0, hauteur, hauteur, null);
		g.drawString(
				"Page : " + (modele.Constantes.numdebutdepage + 1) + " /  " + (((image.m_listeImageSelection.size()-1) / 8) + 1),
				largeur / 2, hauteur / 2);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
		
	}

}
