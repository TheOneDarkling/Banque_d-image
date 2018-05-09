package controleur;

import java.awt.Button;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
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
		Button button = (Button)e.getSource();
		
		JFileChooser jfc = new JFileChooser();
		
		jfc.setAcceptAllFileFilterUsed(false);
		jfc.setApproveButtonText("Ajouter");
		jfc.setApproveButtonMnemonic(KeyEvent.VK_ENTER);
		
		if(button.getName() == "ajoutImage") {
			jfc.setDialogTitle("Veuillez choisir le ou les fichiers à importer");
			
			jfc.addChoosableFileFilter(all);
			jfc.addChoosableFileFilter(jpg);
			jfc.addChoosableFileFilter(png);
			jfc.addChoosableFileFilter(bmp);
			jfc.addChoosableFileFilter(gif);
			jfc.addChoosableFileFilter(tiff);
			
			jfc.setFileFilter(all);
			jfc.setMultiSelectionEnabled(true);
			
			int state = jfc.showOpenDialog(null);
			
			File[] selected = jfc.getSelectedFiles();
			
			
			if(state == JFileChooser.APPROVE_OPTION) {
				for(File newImg: selected) {
					if(! new File("images/"+newImg.getName()).exists()) {
						b.nouvelleImage(newImg);
					}else {
						JOptionPane.showMessageDialog(null, newImg.toString()+" est déjà présent dans la banque d'images", "Fichier déjà présent", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		
		}else if(button.getName() == "ajoutDossier") {
			jfc.setDialogTitle("Veuillez choisir le dossier à importer");
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
			int state = jfc.showOpenDialog(null);
			
			if(state == JFileChooser.APPROVE_OPTION) {
				File[] folder = jfc.getSelectedFile().listFiles();
				if(folder == null) {
					JOptionPane.showMessageDialog(null, "Le dossier sécifié ne contient pas d'images", "Pas d'image", JOptionPane.WARNING_MESSAGE);
				}else {
					for(File newImg: folder){
						String extension = "";
						
						if(newImg.getName().lastIndexOf(".") != -1) {
							extension = newImg.getName().substring(newImg.getName().lastIndexOf(".")+1);
						}
						
						
						boolean isAnImage = (extension.equals("jpg") ||
											extension.equals("jpeg") ||
											extension.equals("gif") ||
											extension.equals("bmp") ||
											extension.equals("tiff") ||
											extension.equals("png"));
						
						if(! new File("images/"+newImg.getName()).exists() && newImg.isFile() && isAnImage) {
							b.nouvelleImage(newImg);
						}else if(new File("images/"+newImg.getName()).exists()){
							JOptionPane.showMessageDialog(null, newImg.getName()+" est déjà présent dans la banque d'images", "Fichier déjà présent", JOptionPane.WARNING_MESSAGE);
						}
					
				}
}
			}
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
