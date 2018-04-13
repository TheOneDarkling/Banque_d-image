package modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;


public class Biblio extends Observable{
	
	/* LISTES DE BASE*/
	
	public ArrayList<ImagePerso> m_listeImage= new ArrayList();
	public int m_nbImages;
	
	/*  OBJETS POUR LA LECTURE DANS LES FICHIERS*/
	
	private File m_fichierTitre = new File("data/nom.txt");
	private File m_fichierFormat = new File("data/format.txt");
	private File m_fichierTags = new File("data/tags.txt");
	private File m_fichierNote = new File("data/note.txt");
	
	
	/* POUR LA SELECTION */
	
	public ArrayList<ImagePerso> m_listeImageSelection= new ArrayList();
	
	
	
	/*
	 *  DEBUT DU CONSTRUCTEUR
	 *  =====================
	 *  
	 * */
	
	
	public Biblio() throws IOException
	{
		File dossierImage = new File("images/");
		m_nbImages = dossierImage.listFiles().length;
		
		
		/* MISE EN PLACE DE LA LECTURE*/
		
		BufferedReader brNom = new BufferedReader(new FileReader(m_fichierTitre));
		String ligneNom;
		BufferedReader brFormat = new BufferedReader(new FileReader(m_fichierFormat));
		String ligneFormat;
		BufferedReader brTags = new BufferedReader(new FileReader(m_fichierTags));
		String ligneTags;
		BufferedReader brNote = new BufferedReader(new FileReader(m_fichierNote));
		String ligneNote;

		
		/* REMPLISSAGE DE LA LISTE D IMAGE*/
		
		for(int i=0; i<m_nbImages;i++)
		{
			ligneNom = brNom.readLine();
			ligneFormat = brFormat.readLine();
			ligneTags = brTags.readLine();
			ligneNote = brNote.readLine();
			
			m_listeImage.add((new ImagePerso(i,ligneNom, ligneFormat ,"images/"+String.valueOf(i)+".jpg", ligneNote)));
			m_listeImage.get(i).associerLesTags(ligneTags);
			
		}
		
		/* FERMETURE DES FLUX */
		
		brFormat.close();
		brNom.close();
	}
	
	/* changement de page */
	
	public void setNumPage(int page){
		this.setChanged();
		this.notifyObservers();
		modele.Constantes.numdebutdepage = page;
		
	}

	public void toggleImage(){
		this.setChanged();
		this.notifyObservers();
		modele.Constantes.estengrand = !modele.Constantes.estengrand;
	}
	
	public void setNumImage(int num){
		this.setChanged();
		this.notifyObservers();
		modele.Constantes.numimage = num;
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
			System.out.println("======================================================================================");
		}
		
	}
	

	 
	
}
