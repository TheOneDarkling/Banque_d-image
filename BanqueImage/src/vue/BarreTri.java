package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JComboBox;

public class BarreTri extends Panel {
	
	
	public BarreTri(){
	
		int largeur=(int) modele.Constantes.w*1/10;
		int hauteur=(int) modele.Constantes.h*3/4;
		this.setPreferredSize(new Dimension(largeur,hauteur));
		this.setBackground(Color.GRAY);
		String[] taille={"Taille sup�rieur �","400 x 300","640 x 480","800 x 600","1024 x 768","1600 x 1200","2272 x 1704","2816 x 2112"};
		String[] couleur={"Couleur dominante","Vert","Bleu","Rouge","Jaune","Marron","Noir","Blanc","Orange","Violet","Rose","Gris"};
		String[] format={"Format ",".jpg",".bmp",".png",".gif",".tiff"};
		JComboBox<String> Taille= new JComboBox<String>(taille);
		JComboBox<String> Couleur= new JComboBox<String>(couleur);
		JComboBox<String> Format= new JComboBox<String>(format);
		TextField date =new TextField("    ");
		Label lb = new Label("Saisir une ann�e :");
		
		this.add(Taille);
		this.add(Couleur);
		this.add(Format);
		this.add(lb);
		this.add(date);
}}

