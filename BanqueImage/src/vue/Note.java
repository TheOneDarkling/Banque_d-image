package vue;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Biblio;

public class Note extends JPanel {
	Checkbox[] etoiles = new Checkbox[5];
	int largeur = (int) modele.Constantes.w * 2 / 3 + (int) modele.Constantes.w * 1 / 10;
	int hauteur = (int) modele.Constantes.h * 1 / 12;

	public static String[] libelles = { "*", "**", "***", "****", "*****" };
	public Note(Biblio b) {
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(largeur, hauteur));
		if(Afficher_images.estengrand){
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
			
			Afficher_Fleche canvasbas = new Afficher_Fleche(b);
			this.add(canvasbas);
}
			
		}
			
		


	public static void main(String[] args) {

	}

}
