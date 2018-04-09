package controleur;

import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JComboBox;

import modele.Biblio;
import modele.ImagePerso;

public class ControleurRecherche implements TextListener, ItemListener{
	Biblio b;
	
	public ControleurRecherche(Biblio b){
		this.b = b;
	}
	
	@Override
	public void textValueChanged(TextEvent e) {
		TextField t = (TextField)e.getSource();
		String titre = t.getName();
		switch(titre) {
			case "nom":
				for(ImagePerso img: b.m_listeImage){
					if(img.m_titre.toUpperCase().startsWith(t.getText().toUpperCase())){
						System.out.println(img.m_titre);
					}
				}
				break;
				
			case "tag":
				for(ImagePerso img: b.m_listeImage){
					for(String tag: Arrays.asList(t.getText().split(" "))) {
						if(img.m_listeTags.contains(tag)){
							System.out.println(img.m_titre);
							break;
						}
					}
				}
				break;
				
				
		}
		
		System.out.println("----------------------------------");
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		JComboBox box = (JComboBox)event.getSource();
		String titre = box.getName();
		System.out.println(titre);
		if(event.getStateChange() == event.SELECTED && !event.getItem().toString().startsWith(titre)){
			switch(titre){
				case "Taille":
					String[] imgDims = event.getItem().toString().split(" x ");
					int imgDimX = Integer.parseInt(imgDims[0]);
					int imgDimY = Integer.parseInt(imgDims[1]);
					System.out.println(imgDimX+" "+imgDimY);
					break;
				case "Couleur":
					System.out.println(box.getSelectedItem()); break;
				case "Format":
					for(ImagePerso img: b.m_listeImage){
						if(img.m_lien.endsWith(box.getSelectedItem().toString())){System.out.println(img.m_titre);}
					}
					break;	
			}
			System.out.println("----------------------------------");
		}
	}

}
