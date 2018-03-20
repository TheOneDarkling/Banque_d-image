package vue;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;

public class Afficher_images extends Canvas implements Observer{{
	Image[] img;
	Image[] imgre;
	public Afficher_images(Modele m){
		super();
		this.setPreferredSize(new Dimension(833,480));
		
		try {
			 img[0]=ImageIO.read(new File(imageDefault));
			 imgre[0]=img[0].getScaledInstance(, height, hints)
		} catch (IOException e) {
			throw new RuntimeException("L'image "+imageDefault+" est introuvable");
		}
		
		m.addObserver(this);
	
		
	}
}

@Override
public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	
}
}
