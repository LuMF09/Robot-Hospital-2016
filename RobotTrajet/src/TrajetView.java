import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class TrajetView extends JFrame{

	private JLabel numPatient,depart,arrivee, blank;
	private JTextField numPatientTextField;
	private JCheckBox direct,ballade;
	private JButton retour,commencer;
	private JComboBox<String> listeDepart,listeArrivee;


	public TrajetView(TrajetController trajetController){

		super("Effectuer un trajet");
		
		// pan est un panneau
		Container pan = this.getContentPane();
		pan.setLayout(new BorderLayout());

		//Cr�ation sous panel
		JPanel sousPanelNorth = new JPanel();
		sousPanelNorth.setLayout(new GridLayout(3,2));
		pan.add(sousPanelNorth, BorderLayout.NORTH);

		
		retour=new JButton("Retour");
		pan.add(retour,  BorderLayout.SOUTH);
		retour.addActionListener(new TrajetEvent(trajetController));

		numPatient = new JLabel("Num�ro du patient : ");
		sousPanelNorth.add(numPatient);

		numPatientTextField= new JTextField();
		sousPanelNorth.add(numPatientTextField);

		depart = new JLabel("Lieu de d�part : ");
		sousPanelNorth.add(depart);

		listeDepart = new JComboBox<String>();
		listeDepart.addItem("RDC-Consultations Gyn�cologie");
		listeDepart.addItem("RDC-Consultations Cardiologie");
		listeDepart.addItem("RDC-Consultations Chirurgie");
		listeDepart.addItem("RDC-Hall d'arriv�e");
		listeDepart.addItem("N1-Maternit�");
		listeDepart.addItem("N1-Rhumatologie");
		listeDepart.addItem("N1-M�decine interne");
		listeDepart.addItem("N1-Neurologie");
		listeDepart.addItem("N1-Dialyse");
		listeDepart.addItem("N1-M�decine polyvalente");
		listeDepart.addItem("N1-Anti-tuberculose");
		listeDepart.addItem("N2-Pneumologie");
		listeDepart.addItem("N2-Chirurgie");
		listeDepart.addItem("N2-Chirurgie de la main");
		listeDepart.addItem("N2-P�diatrie");
		listeDepart.addItem("N3-Cardiologie");
		listeDepart.addItem("N3-G�riatrie");
		listeDepart.addItem("N4-H�matologie");
		
		sousPanelNorth.add(listeDepart);

		arrivee = new JLabel("Lieu d'arriv�e : ");
		sousPanelNorth.add(arrivee);

		listeArrivee = new JComboBox<String>();
		listeArrivee.addItem("RDC-Consultations Gyn�cologie");
		listeArrivee.addItem("RDC-Consultations Cardiologie");
		listeArrivee.addItem("RDC-Consultations Chirurgie");
		listeArrivee.addItem("RDC-Hall d'arriv�e");
		listeArrivee.addItem("N1-Maternit�");
		listeArrivee.addItem("N1-Rhumatologie");
		listeArrivee.addItem("N1-M�decine interne");
		listeArrivee.addItem("N1-Neurologie");
		listeArrivee.addItem("N1-Dialyse");
		listeArrivee.addItem("N1-M�decine polyvalente");
		listeArrivee.addItem("N1-Anti-tuberculose");
		listeArrivee.addItem("N2-Pneumologie");
		listeArrivee.addItem("N2-Chirurgie");
		listeArrivee.addItem("N2-Chirurgie de la main");
		listeArrivee.addItem("N2-P�diatrie");
		listeArrivee.addItem("N3-Cardiologie");
		listeArrivee.addItem("N3-G�riatrie");
		listeArrivee.addItem("N4-H�matologie");
		
		sousPanelNorth.add(listeArrivee);

		JPanel sousPanelWest = new JPanel();
		sousPanelWest.setLayout(new GridLayout(4,0));
		pan.add(sousPanelWest, BorderLayout.WEST);

		direct= new JCheckBox("Trajet Direct");
		sousPanelWest.add(direct);

		ballade= new JCheckBox("Balade");
		sousPanelWest.add(ballade);

		commencer=new JButton("Lancer le trajet !");
		sousPanelWest.add(commencer);
		commencer.addActionListener(new Trajet2Event(trajetController));

		blank = new JLabel(" ");
		sousPanelWest.add(blank);


		this.pack();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void afficherMessage(String msg)
	{
		JOptionPane.showMessageDialog(this,
				msg,
				"Information",
				JOptionPane.INFORMATION_MESSAGE);
	}


	public void afficher(boolean ouiounon){
		setVisible(ouiounon);
	}

	public void destroyFrame()
	{
		this.pack();
		this.setVisible(false);
		this.dispose();
	}

	public boolean isTick1(){
		if(ballade.isSelected()){
			return true;
			}
		else return false;
	}
	public boolean isTick2(){
		if(direct.isSelected()){
			return true;}
		else return false;
	}
}