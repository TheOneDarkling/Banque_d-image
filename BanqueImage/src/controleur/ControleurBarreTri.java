package controleur;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ControleurBarreTri implements ItemListener{

	@Override
	public void itemStateChanged(ItemEvent event) {
		if(event.getStateChange() == event.SELECTED && !event.getItem().equals("Taille")){
			String[] imgDims = event.getItem().toString().split(" x ");
			int imgDimX = Integer.parseInt(imgDims[0]);
			int imgDimY = Integer.parseInt(imgDims[1]);
			System.out.println(imgDimX+" "+imgDimY);
		}
		
	}

}
