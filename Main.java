package td.cbs.package_;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		int w=screenSize.width;
		int h=screenSize.height;
		
		Formulaire f=new Formulaire(h/2,w/2,w/4,h/4);
		f.setVisible(true);
	}
		


}
