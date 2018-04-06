package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class ControleurImage implements MouseListener, Observer{
	
	
	//Solution temporaire:
	int hauteur =(int) modele.Constantes.h*2/3;
	int largeur=(int) modele.Constantes.w*2/3;
	int pasX = 20;
	int pasY = 30;

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX()/(pasX+(largeur-(pasX*5))/4)+((e.getY()/((pasY+(pasX+(largeur-(pasX*5))/4))))*4));
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
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
