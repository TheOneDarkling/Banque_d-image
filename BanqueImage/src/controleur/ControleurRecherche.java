package controleur;

import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JComboBox;

import modele.Biblio;
import modele.ImagePerso;

public class ControleurRecherche implements TextListener, ItemListener{
	Biblio b;
	Set<String> tags;
	String rechNom;
	
	
	public ControleurRecherche(Biblio b){
		this.b = b;
		this.tags = new HashSet<String>();
		this.rechNom = "" ;
	}
	
	public void modifyListeSelection(boolean condition, int imgID) {
		if(condition && !b.m_listeImageSelection.contains(imgID)) {
			b.m_listeImageSelection.add((Integer)imgID);
		}else if(!condition && b.m_listeImageSelection.contains(imgID)) {
			b.m_listeImageSelection.remove((Integer)imgID);
		}
	}
	@Override
	public void textValueChanged(TextEvent e) {
		TextField t = (TextField)e.getSource();
		String titre = t.getName();
		Iterator<String> itTags;
		ImagePerso img;
		boolean tagFound = false;
		boolean tagInImage;
		
		
		switch(titre) {
			case "nom":
				this.rechNom = t.getText().trim().toUpperCase();				
				break;
				
			case "tag":
				this.tags.clear();
				
				String txt = t.getText().trim().replaceAll(" +", " ");
				for(String tag: txt.split(" ")) {this.tags.add(tag);}	
			
				
				break;
				
				
		}
		
		int i=0;
		while(i<b.m_nbImages && !tagFound) {
			img = b.m_listeImage.get(i);
			itTags = this.tags.iterator();
			
			while(itTags.hasNext() && !tagFound) {
				tagFound = img.m_listeTags.contains(itTags.next());
			}
			
			i++;
		}
		
		if(tagFound) {
		
			for(i=0; i<b.m_listeImage.size(); i++) {
				img = b.m_listeImage.get(i);
				tagInImage = false;
				itTags = this.tags.iterator();
				
				while(itTags.hasNext() && !tagInImage) {
					String tag = itTags.next();
					tagInImage = img.m_listeTags.contains(tag);
				}
				
				if(!this.rechNom.isEmpty()) {
					this.modifyListeSelection(tagInImage && img.m_titre.toUpperCase().startsWith(this.rechNom), i);
				}else{
					this.modifyListeSelection(tagInImage, i);
				}
			}
		}else if(!this.rechNom.isEmpty()) {
			for(i=0; i<b.m_listeImage.size(); i++) {
				img = b.m_listeImage.get(i);
				this.modifyListeSelection(img.m_titre.toUpperCase().startsWith(this.rechNom), i);
			}
		}else {
			b.m_listeImageSelection.clear();
			for(i=0; i<b.m_nbImages; i++) {
				b.m_listeImageSelection.add(i);
			}
			
		}
		for(int id: b.m_listeImageSelection) {System.out.println(b.m_listeImage.get(id).m_titre);}
		System.out.println("----------------------------------");
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