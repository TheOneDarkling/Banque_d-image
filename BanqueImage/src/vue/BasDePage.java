package vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class BasDePage extends JPanel implements Observer{
	private Afficher_Fleche fleches;
	private Note notes;
	
	public BasDePage(Afficher_Fleche fleches, Note notes) {
		this.fleches = fleches;
		this.notes = notes;
		
		this.add(fleches);
	}
	
	public void change() {
		if(modele.Constantes.estengrand) {
			this.remove(fleches);
			this.add(notes);
		}else {
			this.remove(notes);
			this.add(fleches);
		}
		this.invalidate();
		this.revalidate();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		change();
		
	}
	
}
