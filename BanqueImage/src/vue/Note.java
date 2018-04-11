package vue;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Note extends JPanel {
	Checkbox[] étoiles = new Checkbox[5];
	int largeur = (int) modele.Constantes.w * 2 / 3 + (int) modele.Constantes.w * 1 / 10;
	int hauteur = (int) modele.Constantes.h * 1 / 12;

	public static String[] libellés = { "*", "**", "***", "****", "*****" };
	public Note() {
		this.setPreferredSize(new Dimension(largeur, hauteur));
			CheckboxGroup cg = new CheckboxGroup();
			for (int i = 0; i < 5; i++) {
				this.étoiles[i] = new Checkbox(libellés[i], false, cg);
				this.add(this.étoiles[i]);
			}
		}
			
		


	public static void main(String[] args) {

	}

}
