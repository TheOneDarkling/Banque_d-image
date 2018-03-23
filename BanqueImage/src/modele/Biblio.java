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
	
	public ArrayList<String> m_listeNom = new ArrayList();
	public ArrayList<String> m_listeTitre = new ArrayList();
	public ArrayList<String> m_listeFormat = new ArrayList();
	public int m_nbImages = 9;
	
	/*  OBJETS POUR LA LECTURE DANS LES FICHIERS*/
	
	private File m_fichierTitre = new File("data/nom.txt");
	private File m_fichierFormat = new File("data/format.txt");
	
	
	/* POUR LA SELECTION */
	
	
	
	public Biblio() throws IOException
	{
		for(int i=0; i<m_nbImages;i++)
		{
			m_listeNom.add("images/"+String.valueOf(i)+".jpg");
			
		}
		
		/// LECTURE DU FICHIER NOM
		
		BufferedReader brNom = new BufferedReader(new FileReader(m_fichierTitre));
		String ligne;
		
		while ((ligne = brNom.readLine()) != null) {
		   m_listeTitre.add(ligne);
		}
		brNom.close();
		
		/// LECTURE DU FICHIER FORMAT
		
		BufferedReader brFormat = new BufferedReader(new FileReader(m_fichierFormat));
		String ligneF;
		
		while ((ligneF = brFormat.readLine()) != null) {
		   m_listeFormat.add(ligneF);
		}
		brFormat.close();
	}
	
	
	public static void main(String[] args) throws IOException
	{
		Biblio b = new Biblio();
		
		for(int i=0; i<b.m_nbImages; i++)
		{
			System.out.println("ID     : " + i);
			System.out.println("Titre  : " + b.m_listeTitre.get(i));
			System.out.println("Format : " + b.m_listeFormat.get(i));
			System.out.println("Lien : " + b.m_listeNom.get(i));
			System.out.println("==========================================");
		}
		
	}
	

	 
	
}
