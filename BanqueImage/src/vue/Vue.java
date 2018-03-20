package vue;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Vue {
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static double w = screenSize.getWidth();
	static double h = screenSize.getHeight();
	
	public static void main(String[] args) {
		System.out.println(w+" "+h);
		
	}

}

