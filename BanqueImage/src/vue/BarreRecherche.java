package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;

import controleur.ControleurRecherche;

public class BarreRecherche extends Panel implements Observer {
	Font font = new Font("Arial",Font.BOLD,15);
	Label lb2= new Label("Recherche par tags");
	TextField tag = new TextField();
	
	public BarreRecherche(ControleurRecherche ctrlRech){
		int largeur=(int) modele.Constantes.w*2/3+(int) modele.Constantes.w*1/10;;
		int hauteur=(int) modele.Constantes.h*1/12;
		this.setPreferredSize(new Dimension(largeur,hauteur));
		//this.setBackground(Color.RED);
		this.setBackground(new Color(200,200,200));
		
		tag.setColumns(50);
		tag.setName("tag");
		tag.addTextListener(ctrlRech);
		tag.addActionListener(ctrlRech);
		lb2.setFont(font);
		this.add(lb2);
		this.add(tag);

		
		
	}
	public void change(){
		if(modele.Constantes.estengrand) {
			tag.setText("");
			lb2.setText("Ajout de tags");
		}
		else{
			lb2.setText("Recherche par tags");
			
		}
	
	}
	@Override
	public void update(Observable arg0, Object message) {
		if(message.toString().equals("toggle")) {
			change();
		}
		
	}

}
