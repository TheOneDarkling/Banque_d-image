package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.TextField;

public class BarreRecherche extends Panel {
	public BarreRecherche(){
		int largeur=(int) modele.Constantes.w*2/3+(int) modele.Constantes.w*1/10;;
		int hauteur=(int) modele.Constantes.h*1/12;
		this.setPreferredSize(new Dimension(largeur,hauteur));
		this.setBackground(Color.RED);
		
		TextField test = new TextField();
		test.setColumns(50);
		this.add(test);
		
	}

}
