package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import modele.Biblio;

public class MenuClicDroit extends JPopupMenu{
	
	public MenuClicDroit(final Biblio b, final int imgIndex) {
		
		JMenuItem delete = new JMenuItem("Supprimer cette image");
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Etes-vous sûr de vouloir supprimer cette image?", "Suppression d'image", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					b.deleteImage(imgIndex);
				}
				
				
			}
			
		});
		
		
		this.add(delete);
	}

}
