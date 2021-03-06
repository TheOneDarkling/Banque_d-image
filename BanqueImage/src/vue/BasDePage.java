package vue;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class BasDePage extends JPanel implements Observer{
	private Afficher_Fleche fleches;
	private Note notes;
	
	public BasDePage(Afficher_Fleche fleches, Note notes) {
		this.fleches = fleches;
		this.notes = notes;
		this.setBackground(Color.white);
		
		this.add(fleches);
	}
	
	public void change() {
		if(modele.Constantes.estengrand) {
			this.remove(fleches);
			this.add(notes);
			notes.initCheckbox();
		}else {
			this.remove(notes);
			this.add(fleches);
		}
		this.invalidate();
		this.revalidate();
	}

	@Override
	public void update(Observable arg0, Object message) {
		if(message.toString().equals("toggle")) {
			change();
		}
		
	}
	
}
