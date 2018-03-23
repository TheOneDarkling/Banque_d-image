package vue;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;

import modele.Biblio;

public class Afficher_images extends Canvas implements Observer{
	Biblio image= new Biblio();
	Image[] img = new Image[image.m_listeNom.size()];
	Image[] imgre = new Image[image.m_listeNom.size()];
	
	
	public Afficher_images(){
		super();
		Frame f = new Frame();
		f.setSize(1500, 800);
		f.setVisible(true);
		f.add(this);
		this.setPreferredSize(new Dimension(1500,800));
		for(int i=0;i<image.m_listeNom.size();i++){
			
			try {
				
				 img[i]=ImageIO.read(new File(image.m_listeNom.get(i)));
				 imgre[i]=img[i].getScaledInstance(250, 200,Image.SCALE_DEFAULT);
			} catch (IOException e) {
				throw new RuntimeException("L'image "+image.m_listeNom.get(i)+" est introuvable");
			}
		}
		repaint();
		

		
	}
	
	public void paint(Graphics g) {
		for(int i=0;i<4;i++)
		g.drawImage(imgre[i], 0+260*i, 0,250, 200, null);
	}



@Override
public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	
}

public static void main(String[] args) {
	new Afficher_images();
	
	
}
}
