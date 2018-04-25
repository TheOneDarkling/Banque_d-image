package modele;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImagePerso {
	
  public int m_id;
  public String m_titre;
  public String m_format;
  public String m_lien;
  public ArrayList<String> m_listeTags= new ArrayList();
  public double m_hauteur;
  public double m_largeur;
  public double m_byte;
  public int m_note;
 
  
  public ImagePerso(int id, String titre, String format, String lien, String note)
  {
	  m_id = id;
	  m_titre = titre;
	  m_format = format;
	  m_lien = lien;
	  
	  chargerTaille();
	  
	  m_byte = 0;
	  
	  m_note = Integer.parseInt(note);
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
  
  
  void chargerTaille()
  {
	  File imageFile = new File(m_lien);
	  BufferedImage img = null;
	  
	  try {
		img = ImageIO.read(imageFile);
	  } catch (IOException e) {e.printStackTrace();}
	  
	  m_largeur = img.getWidth();
	  m_hauteur = img.getHeight();
	  
	  m_byte = imageFile.length()/1000;
  }
}
