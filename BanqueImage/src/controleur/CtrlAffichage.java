package controleur;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modele.Biblio;
import vue.Afficher_images;

public class CtrlAffichage implements MouseListener{
	Biblio b;
	int hauteur =(int) modele.Constantes.h*2/3;
	int largeur=(int) modele.Constantes.w*2/3;
	int pasX = 20;
	int pasY = 30;
	
public CtrlAffichage(Biblio b){
	this.b = b;
}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Canvas zoneFleches = (Canvas)e.getSource();
		int xCoord = e.getX();
		int yCoord = e.getY();
		
		switch(zoneFleches.getName()) {
			case "images":
				int imgDim = (largeur-(pasX*5))/4;
				
				int posX = xCoord/(pasX+imgDim);
				posX = (posX==4)? 3 : posX;
				
				int posY = (yCoord/((pasY+(pasX+imgDim))));
				posY = (posY > 1)? 1: posY;
									
				int imgBorderLeft = (posX+1)*pasX + posX*imgDim;
				int imgBorderRight = (posX+1)*pasX+ (posX+1)*imgDim;
				int imgBorderTop = posY*pasX+(posY+1)*pasY + posY*imgDim;
				int imgBorderBottom = posY*pasX+(posY+1)*pasY+(posY+1)*imgDim;
				
				int indexImage = posX + 4*posY;
				
				if(modele.Constantes.estengrand) {
					b.toggleImage();
				}else if(indexImage+8*modele.Constantes.numdebutdepage<b.m_listeImageSelection.size()
						&& imgBorderLeft <= xCoord && xCoord <= imgBorderRight
						&& imgBorderTop <= yCoord && yCoord <= imgBorderBottom) {
					b.setNumImage(indexImage + 8*modele.Constantes.numdebutdepage);
					b.toggleImage();
				}
				break;
			case "fleches":
				if(xCoord > zoneFleches.getWidth()/2 && modele.Constantes.numdebutdepage < (b.m_listeImageSelection.size()-1) / 8) {
					b.setNumPage(modele.Constantes.numdebutdepage+1);
				}else if(xCoord <= zoneFleches.getWidth()/2 && modele.Constantes.numdebutdepage > 0){
					b.setNumPage(modele.Constantes.numdebutdepage-1);
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