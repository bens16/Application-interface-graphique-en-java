package td.cbs.package_;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Formulaire extends JFrame{
	
	//instanciation des objets jpanel
	private JPanel pan=new JPanel();
	private JLabel titre=new JLabel("Saisie Note Etudiant");
	private JLabel t1=new JLabel("Nom :");
	private JLabel t2=new JLabel("Prénom :");
	private JLabel t3=new JLabel("UE :");
	private JLabel t4=new JLabel("EC :");
	private JLabel t5=new JLabel("NOTE DEVOIR :");
	private JLabel t6=new JLabel("NOTE EXAMEN :");
	private JTextField nom=new JTextField();
	private JTextField prenom=new JTextField();
	private JTextField ue=new JTextField();
	private JTextField ec=new JTextField();
	private JTextField noteD=new JTextField();
	private JTextField noteE=new JTextField();
	private JButton calculMoy=new JButton("Calculer Moyenne");
	private JButton annuler=new JButton("Annuler");
	private double noteDevoir;
	private double noteExamen;
	private double moy;
	
	
	/*
	try
	{
		MaskFormatter deci=new MaskFormatter("##.###");
		private JFormattedTextField noteD = new JFormattedTextField(deci);
		private JFormattedTextField noteE = new JFormattedTextField(deci);
		
	}
	catch(ParseException pa) {pa.printStackTrace();}
	*/
	
	public Formulaire() // Constructeur par défaut
	{
		
	}
	
	public Formulaire(int height,int width,int x,int y)// Constructeur d'initialisation
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Gestion des notes");
		this.setSize(width,height); 
		this.setLocation(x,y);  // on spécifie là où doit se positionner la fenêtre à l'écran
		
		//Nous ajoutons notre fenêtre à la liste des auditeurs de notre bouton
		calculMoy.addActionListener(new CalculMoyListener());
		annuler.addActionListener(new AnnulerListener());
		
		
		JPanel p_nord=new JPanel();
		JPanel p_sud=new JPanel();
		JPanel p_center=new JPanel();
		
		
		pan.setLayout(new BorderLayout());
		
		pan.add(p_center,BorderLayout.CENTER);
		pan.add(p_sud,BorderLayout.SOUTH);
	    pan.add(p_nord,BorderLayout.NORTH);
	    
	   
	    
	    p_nord.add(titre);
	    titre.setForeground(new Color(255,0,0));
	    Font police=new Font("Arial",Font.BOLD,22);
	    titre.setFont(police);
	    
	    p_center.setLayout(new GridLayout(6,2));
	    
	    nom.setPreferredSize(new Dimension(20,20));
	    prenom.setPreferredSize(new Dimension(20,20));
	    ue.setPreferredSize(new Dimension(20,20));
	    ec.setPreferredSize(new Dimension(20,20));
	    noteD.setPreferredSize(new Dimension(20,20));
	    noteE.setPreferredSize(new Dimension(20,20));
	    
	    p_center.add(t1);
	    p_center.add(nom);
	    p_center.add(t2);
	    p_center.add(prenom);
	    p_center.add(t3);
	    p_center.add(ue);
	    p_center.add(t4);
	    p_center.add(ec);
	    p_center.add(t5);
	    p_center.add(noteD);
	    p_center.add(t6);
	    p_center.add(noteE);
	    
	    
	    p_sud.add(calculMoy);
	    p_sud.add(annuler);
	    
	    
	    this.setContentPane(pan);
		
	}
	
	
	private void calcul() //fonction de calcul de la moyenne
	{
		try
		{

			noteDevoir=Double.parseDouble(noteD.getText());
			noteExamen=Double.parseDouble(noteE.getText());
			moy=(noteDevoir*0.4)+(noteExamen*0.6);
			
			
		}
		catch(Exception ex)
		{
			JOptionPane jop1;
			//Boîte du message d'information
			jop1 = new JOptionPane();
			jop1.showMessageDialog(null, "Erreur Format", "Message",JOptionPane.INFORMATION_MESSAGE);
					
		}
			
	}
	
	//Classe écoutant le bouton calculMOy
	class CalculMoyListener implements ActionListener{
		//Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent e)
		{			
			    calcul();
			    JOptionPane jop2;
				//Boîte du message d'information
				jop2 = new JOptionPane(); 
				jop2.showMessageDialog(null, "L'étudiant "+prenom.getText()+"  "+nom.getText()+" a une moyenne: "+moy,"Message",JOptionPane.INFORMATION_MESSAGE);
				
	     }
		
	}
	
	class AnnulerListener implements ActionListener{
		//Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent ev)
		{
			System.exit(0);
		}
	}
	
	
}


