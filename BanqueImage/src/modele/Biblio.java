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
	public int m_nbImages = 9;
	
	/*  OBJETS POUR LA LECTURE DANS LES FICHIERS*/
	
	private File m_fichierTitre = new File("data/nom.txt");
	private File m_fichierFormat = new File("data/format.txt");
	
	
	/* POUR LA SELECTION */
	
	
	
	public Biblio() throws IOException
	{

		
		/// LECTURE DU FICHIER NOM
		
		BufferedReader brNom = new BufferedReader(new FileReader(m_fichierTitre));
		String ligneNom;
	
		BufferedReader brFormat = new BufferedReader(new FileReader(m_fichierFormat));
		String ligneFormat;

		for(int i=0; i<m_nbImages;i++)
		{
			ligneNom = brNom.readLine();
			ligneFormat = brFormat.readLine();
			m_listeImage.add((new ImagePerso(i,ligneNom, ligneFormat ,"images/"+String.valueOf(i)+".jpg")));
			
		}
		
		brFormat.close();
		brNom.close();
	}
	
	
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
			System.out.println("==========================================");
		}
		
	}
	

	 
	
}
