package controleur;

import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.io.IOException;

import modele.Biblio;
import modele.ImagePerso;

public class ControleurBarreRecherche implements TextListener{
	Biblio b;
	
	public ControleurBarreRecherche(Biblio b){
		this.b = b;
	}
	
	@Override
	public void textValueChanged(TextEvent e) {
		TextField t = (TextField)e.getSource();
		for(ImagePerso img: b.m_listeImage){
			if(img.m_titre.toUpperCase().startsWith(t.getText().toUpperCase())){
				System.out.println(img.m_titre);
			}
		}
		System.out.println("----------------------------------");
	}

}
