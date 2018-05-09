package modele;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImagePerso implements Serializable{
	
  public int m_id;
  public String m_titre;
  public String m_format;
  public String m_lien;
  public String m_couleur;
  public ArrayList<String> m_listeTags;
  public double m_hauteur;
  public double m_largeur;
  public double m_byte;
  public int m_note;
 
  public ImagePerso(int id, File image) {
	  m_id = id;
	  m_lien = "images/"+image.getName();
	  m_titre = image.getName().substring(0, image.getName().lastIndexOf("."));
	  m_format = m_lien.substring(m_lien.lastIndexOf("."));
	  
	  m_listeTags= new ArrayList<String>();
	  ajouterTag(m_titre);
	  
	  chargerTaille();
	  
	  m_byte = 0;
	  
	  m_note = -1;
	  
	  m_couleur = "none";
  }
  
  public void ajouterTag(String tag) {
	  this.m_listeTags.add(tag);
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
		m_largeur = img.getWidth();
		m_hauteur = img.getHeight();
		  
		m_byte = imageFile.length()/1000;
	  } catch (IOException e) {e.printStackTrace();}
	  
	  
  }
}
