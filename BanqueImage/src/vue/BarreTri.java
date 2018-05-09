package vue;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;

import controleur.CtrlAjoutImages;
import controleur.CtrlRecherche;

public class BarreTri extends Panel implements Observer{
	JComboBox<String> Taille;
	JComboBox<String> Couleur;
	JComboBox<String> Format;

	public BarreTri(CtrlRecherche ctrlRech, CtrlAjoutImages ctrlImg){
	
		int largeur=(int) modele.Constantes.w*1/9;
		int hauteur=(int) modele.Constantes.h*2/3;
		
		this.setPreferredSize(new Dimension(largeur,hauteur));
		this.setBackground(new Color(100,100,100));
		String[] taille={"Taille superieur a","400 x 300","640 x 480","800 x 600","1024 x 768","1600 x 1200","2272 x 1704","2816 x 2112"};
		String[] couleur={"Couleur dominante","Vert","Bleu","Rouge","Jaune","Marron","Noir","Blanc","Orange","Violet","Rose","Gris"};
		String[] format={"Format ",".jpg",".bmp",".png",".gif",".tiff"};
   
        
		Taille= new JComboBox<String>(taille);
		Couleur= new JComboBox<String>(couleur);
		Format= new JComboBox<String>(format);
		Button ajoutimage = new Button("Ajouter une image");
		ajoutimage.setName("ajoutImage");
		ajoutimage.addMouseListener(ctrlImg);

		Button ajoutDossier = new Button("Ajouter un dossier");
		ajoutDossier.setName("ajoutDossier");
		ajoutDossier.addMouseListener(ctrlImg);
		
		
		Font font = new Font("Arial",Font.BOLD,15);
		Font fontbarre = new Font("Arial",Font.BOLD,13);
		
		
		
		Label lb2= new Label("Recherche par nom");
		lb2.setFont(font);
		
		TextField nom = new TextField();
		nom.setColumns(15);
		nom.setFont(fontbarre);
		
		nom.setName("nom");
		nom.addTextListener(ctrlRech);
		
		Taille.setName("Taille");
		Taille.addItemListener(ctrlRech);
		
		Couleur.setName("Couleur");
		Couleur.addItemListener(ctrlRech);
		
		Format.setName("Format");
		Format.addItemListener(ctrlRech);
		
		Taille.setFont(fontbarre);
		Couleur.setFont(fontbarre);
		Format.setFont(fontbarre);
		
		
		
		this.add(lb2);
		this.add(nom);
		this.add(Taille);
		this.add(Couleur);
		this.add(Format);
		this.add(ajoutimage);
		this.add(ajoutDossier);
}

	public void switchComboBoxes() {
		Taille.setEnabled(!modele.Constantes.estengrand);
		Couleur.setEnabled(!modele.Constantes.estengrand);
		Format.setEnabled(!modele.Constantes.estengrand);
	}
	
	
	@Override
	public void update(Observable arg0, Object message) {
		if(message.toString().equals("toggle")) {
			switchComboBoxes();
		}
		
	}}

