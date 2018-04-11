package controleur;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ControleurNotes implements ItemListener{

	@Override
	public void itemStateChanged(ItemEvent event) {
		System.out.println(event.getItem().toString().length());
		
	}

}
