package controleur;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import modele.Biblio;
import modele.ImagePerso;

public class CtrlAjoutImages implements MouseListener{
	Biblio b;
	FileNameExtensionFilter jpg, png, bmp, gif, tiff, all;
	
	public CtrlAjoutImages(Biblio b) {
		this.b = b;
		jpg = new FileNameExtensionFilter("JPEG files (*.jpg, *.jpeg)", "jpg", "jpeg");
		png = new FileNameExtensionFilter("PNG files (*.png)", "png");
		bmp = new FileNameExtensionFilter("BMP files (*.bmp)", "bmp");
		gif = new FileNameExtensionFilter("GIF files (*.gif)", "gif");
		tiff = new FileNameExtensionFilter("TIFF files (*.tiff)", "tiff");
		all = new FileNameExtensionFilter("Tous les types d'images", "jpg", "jpeg", "png", "bmp", "gif", "tiff");
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JFileChooser jfc = new JFileChooser();
		
		jfc.setAcceptAllFileFilterUsed(false);
		jfc.addChoosableFileFilter(all);
		jfc.addChoosableFileFilter(jpg);
		jfc.addChoosableFileFilter(png);
		jfc.addChoosableFileFilter(bmp);
		jfc.addChoosableFileFilter(gif);
		jfc.addChoosableFileFilter(tiff);
		
		jfc.setFileFilter(all);
		int state = jfc.showOpenDialog((Component) e.getSource());
		
		File selected = jfc.getSelectedFile();
		
		
		if(state == JFileChooser.APPROVE_OPTION) {
			b.nouvelleImage(selected);
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
