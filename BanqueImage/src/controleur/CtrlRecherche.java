package controleur;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JComboBox;

import modele.Biblio;
import modele.ImagePerso;

public class CtrlRecherche implements TextListener, ItemListener, ActionListener{
	Biblio b;
	Iterator<String> itTags;
	Set<String> searchTags;
	boolean tagFound;
	boolean tagInImage;
	String rechNom;
	int rechLargeur;
	int rechHauteur;
	String rechCouleur;
	String rechExtension;
	boolean[] states;
	
	
	public CtrlRecherche(Biblio b){
		this.b = b;
		this.searchTags = new HashSet<String>();
		this.tagFound = false;
		this.tagInImage = false;
		this.rechNom = "" ;
		this.rechLargeur = 0;
		this.rechHauteur = 0;
		this.rechCouleur = "";
		this.rechExtension = "";
	}
	
	void checkTagFound() {
		ImagePerso img;
		
		this.tagFound = false;
		
		int i=0;
		while(i<b.m_nbImages && !this.tagFound) {
			img = b.m_listeImage.get(i);
			this.itTags = this.searchTags.iterator();
			
			while(this.itTags.hasNext() && !this.tagFound) {
				this.tagFound = img.m_listeTags.contains(this.itTags.next());
			}
			
			i++;
		}
	}
	
	void checkImages() {
		ImagePerso img;
		if(this.tagFound) {
			
			for(int i=0; i<b.m_listeImage.size(); i++) {
				img = b.m_listeImage.get(i);
				this.tagInImage = false;
				this.itTags = this.searchTags.iterator();
				
				while(this.itTags.hasNext() && !this.tagInImage) {
					String tag = this.itTags.next();
					this.tagInImage = img.m_listeTags.contains(tag);
				}
				
				this.states = new boolean[]{
									!this.tagFound || this.tagInImage,
									
									this.rechNom.isEmpty() || img.m_titre.toUpperCase().startsWith(this.rechNom),
								
								   	img.m_largeur >= this.rechLargeur || img.m_hauteur >= this.rechHauteur,
								   	
								   	this.rechCouleur.isEmpty() || img.m_listeTags.contains(this.rechCouleur),
								   	
								   	this.rechExtension.isEmpty() || img.m_format.equals(this.rechExtension)};

				
				b.modifyListeSelection(this.states, i);
				//System.out.println(this.tagFound+"|"+img.m_titre+" "+Arrays.toString(states));
				//System.out.println("-----------------------------");
				
			}
		}else {
			for(int i=0; i<b.m_listeImage.size(); i++) {
				img = b.m_listeImage.get(i);
				
				this.states = new boolean[]{
									this.rechNom.isEmpty() || img.m_titre.toUpperCase().startsWith(this.rechNom),
								
								   	img.m_largeur >= this.rechLargeur || img.m_hauteur >= this.rechHauteur,
								   	
								   	this.rechCouleur.isEmpty() || img.m_listeTags.contains(this.rechCouleur),
								   	
								   	this.rechExtension.isEmpty() || img.m_format.equals(this.rechExtension)};
				
				b.modifyListeSelection(this.states, i);
				//System.out.println(this.tagFound+"|"+img.m_titre+" "+Arrays.toString(states));
				//System.out.println("-----------------------------");
				
			}
		}
		
		b.m_listeImageSelection.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer imgID1, Integer imgID2) {
				return imgID1.compareTo(imgID2);
			}
			
		});
	}
	
	@Override
	public void textValueChanged(TextEvent e) {
		TextField t = (TextField)e.getSource();
		String titre = t.getName();
		ImagePerso img;
		
	
		if(!modele.Constantes.estengrand) {
			switch(titre) {
				case "nom":
					this.rechNom = t.getText().trim().toUpperCase();				
					break;
					
				case "tag":
					this.searchTags.clear();
					
					String txt = t.getText().trim().replaceAll(" +", " ");
					for(String tag: txt.split(" ")) {this.searchTags.add(tag);}	
					checkTagFound();
					
					break;
					
					
			}
			
			checkImages();
		}
		
		
		
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		JComboBox box = (JComboBox)event.getSource();
		String titre = box.getName();
		if(event.getStateChange() == event.SELECTED){
			switch(titre){
				case "Taille":
					if(!event.getItem().toString().startsWith(titre)) {
						String[] imgDims = event.getItem().toString().split(" x ");
						rechLargeur = Integer.parseInt(imgDims[0]);
						rechHauteur = Integer.parseInt(imgDims[1]);
					}else{
						rechLargeur = 0;
						rechHauteur = 0;
					}
					break;
				case "Couleur":
					if(!event.getItem().toString().startsWith(titre)) {
						rechCouleur = box.getSelectedItem().toString().toLowerCase(); 
					}else {
						rechCouleur = "";
					}
					break;
				case "Format":
					if(!event.getItem().toString().startsWith(titre)) {
						rechExtension = box.getSelectedItem().toString();
					}else {
						rechExtension = "";
					}
					break;	
			}
			
			checkImages();
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(modele.Constantes.estengrand) {
			TextField t = (TextField)e.getSource();
			ImagePerso img = b.m_listeImage.get(b.m_listeImageSelection.get(modele.Constantes.numimage));
			String[] imgTags = t.getText().trim().split(" +");
			for(String tag: imgTags) {
				if(!img.m_listeTags.contains(tag) && !tag.isEmpty()) {
					b.addTag(tag);
					System.out.println(String.format("Tag %s ajouté à %s", tag, img.m_titre));
				}
			}
			t.setText("");
			
		}
	}

}