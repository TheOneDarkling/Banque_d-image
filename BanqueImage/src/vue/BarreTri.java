package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JComboBox;

import controleur.ControleurRecherche;

public class BarreTri extends Panel {
	
	
	public BarreTri(ControleurRecherche ctrlRech){
	
		int largeur=(int) modele.Constantes.w*1/9;
		int hauteur=(int) modele.Constantes.h*2/3;
		
		this.setPreferredSize(new Dimension(largeur,hauteur));
		this.setBackground(Color.GRAY);
		String[] taille={"Taille superieur a","400 x 300","640 x 480","800 x 600","1024 x 768","1600 x 1200","2272 x 1704","2816 x 2112"};
		String[] couleur={"Couleur dominante","Vert","Bleu","Rouge","Jaune","Marron","Noir","Blanc","Orange","Violet","Rose","Gris"};
		String[] format={"Format ",".jpg",".bmp",".png",".gif",".tiff"};
   
        
		JComboBox<String> Taille= new JComboBox<String>(taille);
		JComboBox<String> Couleur= new JComboBox<String>(couleur);
		JComboBox<String> Format= new JComboBox<String>(format);
		
		Font font = new Font("Arial",Font.BOLD,15);
		Font fontbarre = new Font("Arial",Font.BOLD,13);
		
		TextField date =new TextField();
		date.setColumns(10);
		date.setFont(font);
		
		
		Label lb = new Label("Saisir une annee :");
		lb.setFont(font);
		
		
		
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
		this.add(lb);
		this.add(date);
}}

