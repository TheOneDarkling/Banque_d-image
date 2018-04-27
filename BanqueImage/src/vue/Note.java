package vue;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import controleur.ControleurAffichage;
import controleur.ControleurNotes;
import modele.Biblio;
import modele.ImagePerso;

public class Note extends JPanel{
	Checkbox[] etoiles = new Checkbox[5];
	int largeur = (int) modele.Constantes.w * 2 / 3 + (int) modele.Constantes.w * 1 / 10;
	int hauteur = (int) modele.Constantes.h * 1 / 12;
	Biblio b;
	CheckboxGroup cg;
	
	public static String[] libelles = {"*", "**", "***", "****", "*****" };
	
	public Note(Biblio b, ControleurNotes ctrl) {
		this.b=b;
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(largeur, hauteur));
		
		cg = new CheckboxGroup();
		Label note = new Label("Saisir une Note sur 5 :");
		Font f = new Font("Arial",Font.BOLD,18);
		note.setFont(f);
		this.add(note);
		
		for (int i = 0; i < 5; i++) {
			this.etoiles[i] = new Checkbox(libelles[i], false, cg);
			Font font = new Font("Arial",Font.BOLD,50);
			this.etoiles[i].setFont(font);
			this.etoiles[i].setForeground(Color.yellow);
			this.etoiles[i].addItemListener(ctrl);
			this.add(this.etoiles[i]);
		}
		
		
	}
	
	public void resetAllCheckboxes() {
		cg.setSelectedCheckbox(null);
	}
	
	void initCheckbox() {
		ImagePerso img = b.m_listeImage.get(b.m_listeImageSelection.get(modele.Constantes.numimage));
		if(img.m_note != 6) {
			cg.setSelectedCheckbox(this.etoiles[img.m_note-1]);
		}else {
			this.resetAllCheckboxes();
		}
	}
	
}
