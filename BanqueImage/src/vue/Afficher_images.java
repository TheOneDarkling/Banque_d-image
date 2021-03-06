package vue;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;

import modele.Biblio;

public class Afficher_images extends Canvas implements Observer{
	Biblio image;
	ArrayList<Image> img;
	int hauteur =(int) modele.Constantes.h*2/3;
	int largeur=(int) modele.Constantes.w*2/3;
	int pasX = 20;
	int pasY = 30;
	
	public Afficher_images(Biblio b) {
		super();
		this.image=b;
		this.setName("images");
		//this.setBackground(Color.green);
		this.setBackground(new Color(200,200,200));
		this.setPreferredSize(new Dimension(largeur,hauteur));
	
		this.img = new ArrayList<Image>();
	
		
		for (int i = 0; i < image.m_listeImage.size(); i++) {

			try {

				this.img.add(ImageIO.read(new File(image.m_listeImage.get(i).m_lien)));
				
			
		
				
				
			} catch (IOException e) {
				throw new RuntimeException("L'image " + image.m_listeImage.get(i) + " est introuvable");
			}
		}
		
		repaint();
			

			
		

	}
	

	public void paint(Graphics g ) {
		if (modele.Constantes.estengrand){g.drawImage(img.get(image.m_listeImageSelection.get(modele.Constantes.numimage)), 0, 0, largeur, hauteur, null);
			
		}
		else{
			g.clearRect(0, 0, largeur, hauteur);
			

		for (int i = modele.Constantes.numdebutdepage*8; i < (modele.Constantes.numdebutdepage+1)*8; i++) {
			if (i <=image.m_listeImageSelection.size()-1) {
				g.drawImage(img.get(image.m_listeImageSelection.get(i)),(pasX+(largeur-(pasX*5))/4) * (i%4)+pasX,((pasY+(pasX+(largeur-(pasX*5))/4))*((i/4)%2)+pasY),(largeur-(pasX*5))/4,(largeur-(pasX*5))/4,null);
				Font font = new Font("Arial",Font.BOLD,15);
				g.setFont(font);
				g.drawString(image.m_listeImage.get(image.m_listeImageSelection.get(i)).m_titre, (pasX+(largeur-(pasX*5))/4) * (i%4)+(largeur-(pasX*5))/8, ((pasY+(pasX+(largeur-(pasX*5))/4))*((i/4)%2)+pasY)-10);
				
			}
		}
		}
	}

	@Override
	public void update(Observable arg0, Object message) {
		if(message.toString().equals("newImage")) {
			try {
				this.img.add(ImageIO.read(new File(image.m_listeImage.get(image.m_listeImage.size()-1).m_lien)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		repaint();
		
	}
	
}
