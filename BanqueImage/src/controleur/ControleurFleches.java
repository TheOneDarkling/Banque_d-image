package controleur;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class ControleurFleches implements MouseListener, Observer{

	@Override
	public void mouseClicked(MouseEvent e) {
		Canvas zoneFleches = (Canvas)e.getSource();
		if(e.getX() > zoneFleches.getWidth()/2) {
			System.out.println("Page suivante");
		}else {
			System.out.println("Page précédente");
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
