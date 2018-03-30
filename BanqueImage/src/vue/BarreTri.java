package vue;

import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;

import javax.swing.JComboBox;

public class BarreTri extends Panel {
	public BarreTri(){
		int largeur=(int) modele.Constantes.w*1/12;
		int hauteur=(int) modele.Constantes.h*3/4;
		this.setPreferredSize(new Dimension(largeur,hauteur));
		this.setBackground(Color.BLUE);
		String[] o={"Taille","400 x 300","640 x 480","800 x 600","1024 x 768","1600 x 1200","2272 x 1704","2816 x 2112"};
		JComboBox test= new JComboBox(o);
		/*List listetaille = new List(30);
		listetaille.add("400 x 300");
		listetaille.add("640 x 480");
		listetaille.add("800 x 600");
		listetaille.add("1024 x 768");
		listetaille.add("1600 x 1200");
		listetaille.add("2272 x 1704");
		listetaille.add("2816 x 2112");
		
		this.add(listetaille);
	*/
		this.add(test);
}}

