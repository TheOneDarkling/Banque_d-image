package vue;

import java.awt.Color;
import java.awt.Panel;
import java.util.Observable;
import java.util.Observer;

public class HautDePages extends Panel implements Observer  {
	private BarreRecherche brb;
	private Ajout_tags tag; 

	public HautDePages(BarreRecherche brb ,Ajout_tags tag){
		this.brb=brb;
		this.tag=tag;
		this.setBackground(new Color(200,200,200));
		this.add(brb);
		
	}
	public void change(){
		if(modele.Constantes.estengrand) {
			this.remove(brb);
			this.add(tag);
		}else {
			this.remove(tag);
			this.add(brb);
		}
		this.invalidate();
		this.revalidate();
		
	}
	public void update(Observable arg0, Object arg1) {
		change();
	
		
	}

}
