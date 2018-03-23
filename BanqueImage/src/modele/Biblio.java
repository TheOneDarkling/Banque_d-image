package modele;

import java.util.ArrayList;

public class Biblio {
	
	public ArrayList<String> m_listeNom = new ArrayList();
	public ArrayList<String> m_listeFormat = new ArrayList();
	int m_nbImages = 9;
	
	public Biblio()
	{
		for(int i=0; i<m_nbImages;i++)
		{
			m_listeNom.add("images/"+String.valueOf(i)+".jpg");
			m_listeFormat.add("JPG");
		}
	}
	
	
	
	 
	
}
