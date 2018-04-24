package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import controleur.ControleurRecherche;

public class BarreRecherche extends Panel {
	public BarreRecherche(ControleurRecherche ctrlRech){
		int largeur=(int) modele.Constantes.w*2/3+(int) modele.Constantes.w*1/10;;
		int hauteur=(int) modele.Constantes.h*1/12;
		this.setPreferredSize(new Dimension(largeur,hauteur));
		//this.setBackground(Color.RED);
		this.setBackground(new Color(200,200,200));
		
		TextField tag = new TextField();
		tag.setColumns(50);
		tag.setName("tag");
		tag.addTextListener(ctrlRech);
		
		Font font = new Font("Arial",Font.BOLD,15);
		Label lb2= new Label("Recherche par tags");
		lb2.setFont(font);
		this.add(lb2);
		this.add(tag);

		
		
	}

}
