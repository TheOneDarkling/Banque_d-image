package vue;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JPanel;
import controleur.ControleurAffichage;
import modele.Biblio;

public class Note extends JPanel{
	Checkbox[] etoiles = new Checkbox[5];
	int largeur = (int) modele.Constantes.w * 2 / 3 + (int) modele.Constantes.w * 1 / 10;
	int hauteur = (int) modele.Constantes.h * 1 / 12;

	public static String[] libelles = { "*", "**", "***", "****", "*****" };
	public Note(Biblio b) {
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(largeur, hauteur));
		if(modele.Constantes.estengrand){
			CheckboxGroup cg = new CheckboxGroup();
			Label note = new Label("Saisir une Note sur 5 :");
			Font f = new Font("Arial",Font.BOLD,18);
			note.setFont(f);
			this.add(note);
			
			for (int i = 0; i < 5; i++) {
				this.etoiles[i] = new Checkbox(libelles[i], false, cg);
				Font font = new Font("Arial",Font.BOLD,50);
				this.etoiles[i].setFont(font);
				this.etoiles[i].setForeground(Color.yellow);
				this.add(this.etoiles[i]);
			}
		}
		else{
			/*
			JPanel droit=new JPanel();
			ImageIcon test =new ImageIcon("fleche.png");
			JLabel img = new JLabel(test);
			droit.add(img).setPreferredSize(new Dimension(hauteur,hauteur));;
			//JPanel gauche=new JPanel((LayoutManager) new ImageIcon("fleche_inv.png"));
			this.add(droit);
			*/
	
			
			Afficher_Fleche fleche = new Afficher_Fleche(b);
			b.addObserver(fleche);
			fleche.addMouseListener(new ControleurAffichage(b));
			this.add(fleche);
}
			
		}
			
		


	public static void main(String[] args) {
		

	}






}
