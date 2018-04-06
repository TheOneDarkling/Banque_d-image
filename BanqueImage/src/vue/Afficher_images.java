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
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;

import modele.Biblio;

public class Afficher_images extends Canvas implements Observer{
	Biblio image;
	Image[] img;
	Image[] imgre;
	int hauteur =(int) modele.Constantes.h*2/3;
	int largeur=(int) modele.Constantes.w*2/3;
	int pasX = 20;
	int pasY = 30;
	
	public Afficher_images() {
		super();
		this.setBackground(Color.green);
		this.setPreferredSize(new Dimension(largeur,hauteur));
	
		try {
			this.image = new Biblio();
		} catch (IOException e1) {
			System.exit(-1);
		}
		this.img = new Image[image.m_listeImage.size()];
		this.imgre = new Image[image.m_listeImage.size()];
	
		
		
		
		for (int i = 0; i < image.m_listeImage.size(); i++) {

			try {

				img[i] = ImageIO.read(new File(image.m_listeImage.get(i).m_lien));
				
			
		
				
				
			} catch (IOException e) {
				throw new RuntimeException("L'image " + image.m_listeImage.get(i) + " est introuvable");
			}
		}
		

		repaint();

	}

	public void paint(Graphics g ) {
		for (int i = modele.Constantes.numdebutdepage*8; i < (modele.Constantes.numdebutdepage+1)*8; i++) {
			if (i <=image.m_listeImage.size()-1) {
				g.drawImage(img[i],(pasX+(largeur-(pasX*5))/4) * (i%4)+pasX,((pasY+(pasX+(largeur-(pasX*5))/4))*((i/4)%2)+pasY),(largeur-(pasX*5))/4,(largeur-(pasX*5))/4,null);
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
