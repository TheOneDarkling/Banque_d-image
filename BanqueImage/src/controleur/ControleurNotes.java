package controleur;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import modele.Biblio;
import modele.ImagePerso;

public class ControleurNotes implements ItemListener{
	Biblio b;
	
	public ControleurNotes(Biblio b) {
		this.b = b;
	}
	
	@Override
	public void itemStateChanged(ItemEvent event) {
		ImagePerso img = b.m_listeImage.get(b.m_listeImageSelection.get(modele.Constantes.numimage));
		System.out.println(String.format("%s avant: %d", img.m_titre, img.m_note));
		img.m_note =  event.getItem().toString().length();
		System.out.println(String.format("%s apres: %d", img.m_titre, img.m_note));
	}
}