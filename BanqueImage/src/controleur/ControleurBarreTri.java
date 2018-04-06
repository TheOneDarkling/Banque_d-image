package controleur;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.JComboBox;

import modele.Biblio;
import modele.ImagePerso;

public class ControleurBarreTri implements ItemListener{
	Biblio b;
	
	public ControleurBarreTri(Biblio b){
		this.b = b;
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		JComboBox box = (JComboBox)event.getSource();
		String titre = box.getName();
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
