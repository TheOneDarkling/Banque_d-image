package modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;


public class Biblio extends Observable{
	
	/* LISTES DE BASE*/
	
	public ArrayList<ImagePerso> m_listeImage;
	public int m_nbImages;
	
	public int m_idImageModif;
	
	
	/* POUR LA SELECTION */
	
	public ArrayList<Integer> m_listeImageSelection= new ArrayList();
	
	
	
	/*
	 *  DEBUT DU CONSTRUCTEUR
	 *  =====================
	 *  
	 * */
	
	
	public Biblio() throws IOException
	{		
		m_idImageModif = 0;
		load();

	}
	
	
	public void save() {
		try {
			File saveFile = new File("data/save");
			if(!saveFile.exists()) {
				saveFile.createNewFile();
			}
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFile));
			oos.writeObject(this.m_listeImage);
			oos.close();
			System.out.println("Sauvegarde réussie");
		} catch (IOException e) {
			System.out.println("Problème lors de la sauvegarde");
			System.exit(-1);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void load() {
		try {
			File saveFile = new File("data/save");
			if(saveFile.exists()) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFile));
				this.m_listeImage = (ArrayList<ImagePerso>)ois.readObject();
				this.m_nbImages = this.m_listeImage.size();
				this.m_listeImageSelection = new ArrayList<Integer>();
				for(ImagePerso img: this.m_listeImage) {
					this.m_listeImageSelection.add(img.m_id);
				}
				ois.close();
				System.out.println("Chargement réussi");
			}else {
				System.out.println("Initialisation en cours...");
				initListeImages();
			}
			
		} catch (IOException|ClassNotFoundException e) {
			System.out.println("Problème lors du chargement. Réinitialisation...");
			initListeImages();
		}
	}
	
	private void initListeImages() {
		m_listeImage = new ArrayList<ImagePerso>();
		
		File[] dossierImage = new File("images/").listFiles();
		m_nbImages = dossierImage.length;
		for(int i=0; i<m_nbImages; i++) {		
			m_listeImage.add((new ImagePerso(i, dossierImage[i])));
			
			/* initialisation liste de sélection d'images */
			m_listeImageSelection.add(i);
		
		}

	}
	/* changement de page */
	
	public void setNumPage(int page){
		modele.Constantes.numdebutdepage = page;
		this.setChanged();
		this.notifyObservers("page");
		
	}

	public void toggleImage(){
		
		if(!modele.Constantes.estengrand)
		{
			m_idImageModif = modele.Constantes.numimage;
		}
				
		modele.Constantes.estengrand = !modele.Constantes.estengrand;
		this.setChanged();
		this.notifyObservers("toggle");
		
	}
	
	public void setNumImage(int num){
		modele.Constantes.numimage = num;
	}
	

	
	public void addTag(String tag)
	{
		this.m_listeImage.get(this.m_listeImageSelection.get(modele.Constantes.numimage)).ajouterTag(tag);
		this.setChanged();
		this.notifyObservers("addTag");
	}
	
	/* Ajout/Enlèvement/Réinitialisation d'images de la liste de sélection */
	public void addImgIndex(Integer i) {
		this.m_listeImageSelection.add(i);
		this.setChanged();
		this.notifyObservers("addImg");
	}
	
	public void removeImgIndex(Integer i) {
		this.m_listeImageSelection.remove(i);
	}

	
	public void modifyListeSelection(boolean[] conditions, Integer imgID) {
		
		
		if(conditions[0] && !this.m_listeImageSelection.contains(imgID)) {
			this.addImgIndex(imgID);
			this.setChanged();
		}else if(!conditions[0] && this.m_listeImageSelection.contains(imgID)) {
			this.removeImgIndex(imgID);
			this.setChanged();
		}
	
		
		for(int i=1; i<conditions.length; i++) {
			if(!conditions[i] && this.m_listeImageSelection.contains(imgID)) {
				this.removeImgIndex(imgID);
				this.setChanged();
			}
			
		}
		
		modele.Constantes.numdebutdepage = 0;
		this.notifyObservers("modifyListeSelection");	
	}
	
	
	public void nouvelleImage(File selected)
	{		
		try {
			Files.copy(selected.toPath(), new File("images/"+selected.getName()).toPath());
			m_listeImage.add((new ImagePerso(m_nbImages,selected)));
		
			m_listeImageSelection.add(m_nbImages);
			m_nbImages++;
			
			this.setChanged();
			this.notifyObservers("newImage");
		} catch (IOException e) {
			System.out.println("ERREUR: Ajout impossible");
		}
		
	}
	
	public void deleteImage(Integer imgIndex) {
		this.m_listeImage.remove(this.m_listeImage.get(this.m_listeImageSelection.get(imgIndex)));
		this.removeImgIndex(imgIndex);
		
		this.m_nbImages--;
		this.setChanged();
		this.notifyObservers("modifyListeSelection");
	}
	
	/*
	 *  LE MAIN (POUR LES TEST)
	 *  ========================
	 *  
	 * */
	
	public static void main(String[] args) throws IOException
	{
		Biblio b = new Biblio();
		
		
		/* AFFICHER TOUTES LES IMAGE */
		
		for(int i=0; i<b.m_nbImages; i++)
		{
			System.out.println("ID     : " + b.m_listeImage.get(i).m_id);
			System.out.println("Titre  : " + b.m_listeImage.get(i).m_titre);
			System.out.println("Format : " + b.m_listeImage.get(i).m_format);
			System.out.println("Lien : " + b.m_listeImage.get(i).m_lien);
			System.out.println("Tags : " + b.m_listeImage.get(i).afficherLesTags());
			System.out.println("Proportions : Longeur = " + b.m_listeImage.get(i).m_largeur + "     +  Hauteur = " + b.m_listeImage.get(i).m_hauteur);
			System.out.println("Taille : " + b.m_listeImage.get(i).m_byte + " ko");
			System.out.println("Note(6 = pas de note) : " + b.m_listeImage.get(i).m_note);
			System.out.println("Couleur dom : " + b.m_listeImage.get(i).m_couleur);
			System.out.println("======================================================================================");
		}
		
	}
	

	 
	
}
