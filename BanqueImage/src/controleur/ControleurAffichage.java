package controleur;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modele.Biblio;

public class ControleurAffichage implements MouseListener{
	Biblio b;
	int hauteur =(int) modele.Constantes.h*2/3;
	int largeur=(int) modele.Constantes.w*2/3;
	int pasX = 20;
	int pasY = 30;
	
public ControleurAffichage(Biblio b){
	this.b = b;
}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Canvas zoneFleches = (Canvas)e.getSource();
		switch(zoneFleches.getName()) {
			case "images":
				System.out.println(e.getX()/(pasX+(largeur-(pasX*5))/4)+((e.getY()/((pasY+(pasX+(largeur-(pasX*5))/4))))*4));
				break;
			case "fleches":
				if(e.getX() > zoneFleches.getWidth()/2 && modele.Constantes.numdebutdepage < (b.m_listeImage.size()-1) / 8) {
					b.setNumImage(modele.Constantes.numdebutdepage+1);
				}else if(e.getX() <= zoneFleches.getWidth()/2 && modele.Constantes.numdebutdepage > 0){
					b.setNumImage(modele.Constantes.numdebutdepage-1);
				}
				break;
				
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

		
}
