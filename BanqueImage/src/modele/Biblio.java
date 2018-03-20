package modele;

import java.util.ArrayList;

public class Biblio {
	
	public ArrayList<String> m_listeNom = new ArrayList();
	
	public Biblio()
	{
		for(int i=0; i<m_listeNom.size();i++)
		{
			m_listeNom.add("images/"+String.valueOf(i)+".jpg");
		}
	}
	
	 
	
}
