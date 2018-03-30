package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class ControleurImage implements MouseListener, Observer{
	
	
	//Solution temporaire:
	int resizedX = 250;
	int resizedY = 200;
	//int hauteur = 250;
	//int largeur = 200;
	int pas = 50;
	int startX = 50;
	int startY = 20;

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX()/(startX+resizedX)+(e.getY()/(startY+resizedY))*4);
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
