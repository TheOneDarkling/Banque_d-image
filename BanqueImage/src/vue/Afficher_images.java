package vue;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;

import modele.Biblio;

public class Afficher_images extends Canvas implements Observer, WindowListener {
	Biblio image;
	Image[] img;
	Image[] imgre;
	int hauteur =(int) modele.Constantes.w;
	int largeur=(int) modele.Constantes.h;
	int resizedX = 250;
	int resizedY = 200;
	int pas = 50;
	int startX = 50;
	int startY = 20;
	public int numdebutdepage =0 ;

	public Afficher_images() {
		super();
		this.setBackground(Color.green);

		try {
			this.image = new Biblio();
		} catch (IOException e1) {
			System.exit(-1);
		}
		this.img = new Image[image.m_listeImage.size()];
		this.imgre = new Image[image.m_listeImage.size()];
		
		
		this.setPreferredSize(new Dimension(hauteur*2/3,largeur*2/3));
		
		for (int i = 0; i < image.m_listeImage.size(); i++) {

			try {

				img[i] = ImageIO.read(new File(image.m_listeImage.get(i).m_lien));
				imgre[i] = img[i].getScaledInstance(resizedX, resizedY, Image.SCALE_DEFAULT);
			} catch (IOException e) {
				throw new RuntimeException("L'image " + image.m_listeImage.get(i) + " est introuvable");
			}
		}

		repaint();

	}

	public void paint(Graphics g) {
		for (int i = numdebutdepage*8; i < (numdebutdepage+1)*8; i++) {
			if (i <=image.m_listeImage.size()-1) {
				g.drawImage(imgre[i], startX + (resizedX + pas) * (i%4), startY + (resizedY + pas)*((i/4)%2), resizedX, resizedY, null);
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	
}
