package controleur;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class ControleurAffichage implements MouseListener, Observer{

	int hauteur =(int) modele.Constantes.h*2/3;
	int largeur=(int) modele.Constantes.w*2/3;
	int pasX = 20;
	int pasY = 30;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Canvas zoneFleches = (Canvas)e.getSource();
		switch(zoneFleches.getName()) {
			case "canvas0":
				System.out.println(e.getX()/(pasX+(largeur-(pasX*5))/4)+((e.getY()/((pasY+(pasX+(largeur-(pasX*5))/4))))*4));
				break;
			case "canvas1":
				if(e.getX() > zoneFleches.getWidth()/2) {
					System.out.println("Page suivante");
				}else {
					System.out.println("Page précédente");
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

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
