package modele;

import java.util.ArrayList;

public class ImagePerso {
	
  public int m_id;
  public String m_titre;
  public String m_format;
  public String m_lien;
  public ArrayList<String> m_listeTags= new ArrayList();
 
  
  public ImagePerso(int id, String titre, String format, String lien)
  {
	  m_id = id;
	  m_titre = titre;
	  m_format = format;
	  m_lien = lien;
  }
  
  void associerLesTags(String tags)
  {
	  String[] tagsTab = tags.split("\\+");  
	  
	  for(int i=0; i<tagsTab.length; i++)
	  {
		  m_listeTags.add(tagsTab[i]);
	  }
  }
  
  String afficherLesTags()
  {
	  String phraseAff= "";
	  for(int i=0; i<m_listeTags.size(); i++)
	  {
		  phraseAff += m_listeTags.get(i)+", ";
	  }
	  return phraseAff;
  }
}
