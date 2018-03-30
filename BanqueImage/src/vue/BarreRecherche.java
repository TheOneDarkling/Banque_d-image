package vue;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

public class BarreRecherche extends Canvas {
	public BarreRecherche(){
		int largeur=(int) modele.Constantes.w*2/3;
		int hauteur=(int) modele.Constantes.h*1/12;
		this.setPreferredSize(new Dimension(largeur,hauteur));
		this.setBackground(Color.RED);
	}

}
