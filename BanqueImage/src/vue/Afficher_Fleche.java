package vue;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Afficher_Fleche extends Canvas{
	Image img;
	public Afficher_Fleche(){
		Frame f = new Frame();
		f.setSize(1500, 800);
		f.setVisible(true);
		f.add(this);
		this.setPreferredSize(new Dimension(1500,150));
		try {
			img=ImageIO.read(new File("fleche.png")).getScaledInstance(250, 150, Image.SCALE_DEFAULT);;
		} catch (IOException e) {
			throw new RuntimeException("L'image fleche.png est introuvable");
		}
		
	}
	
	public void paint(Graphics g) {
		g.drawImage(img, 1500-250, 0, 250, 150, null);
	}
	

	public static void main(String[] args) {
		new Afficher_Fleche();

	}

}
