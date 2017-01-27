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

		//Création sous panel
		JPanel sousPanelNorth = new JPanel();
		sousPanelNorth.setLayout(new GridLayout(3,2));
		pan.add(sousPanelNorth, BorderLayout.NORTH);

		
		retour=new JButton("Retour");
		pan.add(retour,  BorderLayout.SOUTH);
		retour.addActionListener(new TrajetEvent(trajetController));

		numPatient = new JLabel("Numéro du patient : ");
		sousPanelNorth.add(numPatient);

		numPatientTextField= new JTextField();
		sousPanelNorth.add(numPatientTextField);

		depart = new JLabel("Lieu de départ : ");
		sousPanelNorth.add(depart);

		listeDepart = new JComboBox<String>();
		listeDepart.addItem("RDC-Consultations Gynécologie");
		listeDepart.addItem("RDC-Consultations Cardiologie");
		listeDepart.addItem("RDC-Consultations Chirurgie");
		listeDepart.addItem("RDC-Hall d'arrivée");
		listeDepart.addItem("N1-Maternité");
		listeDepart.addItem("N1-Rhumatologie");
		listeDepart.addItem("N1-Médecine interne");
		listeDepart.addItem("N1-Neurologie");
		listeDepart.addItem("N1-Dialyse");
		listeDepart.addItem("N1-Médecine polyvalente");
		listeDepart.addItem("N1-Anti-tuberculose");
		listeDepart.addItem("N2-Pneumologie");
		listeDepart.addItem("N2-Chirurgie");
		listeDepart.addItem("N2-Chirurgie de la main");
		listeDepart.addItem("N2-Pédiatrie");
		listeDepart.addItem("N3-Cardiologie");
		listeDepart.addItem("N3-Gériatrie");
		listeDepart.addItem("N4-Hématologie");
		
		sousPanelNorth.add(listeDepart);

		arrivee = new JLabel("Lieu d'arrivée : ");
		sousPanelNorth.add(arrivee);

		listeArrivee = new JComboBox<String>();
		listeArrivee.addItem("RDC-Consultations Gynécologie");
		listeArrivee.addItem("RDC-Consultations Cardiologie");
		listeArrivee.addItem("RDC-Consultations Chirurgie");
		listeArrivee.addItem("RDC-Hall d'arrivée");
		listeArrivee.addItem("N1-Maternité");
		listeArrivee.addItem("N1-Rhumatologie");
		listeArrivee.addItem("N1-Médecine interne");
		listeArrivee.addItem("N1-Neurologie");
		listeArrivee.addItem("N1-Dialyse");
		listeArrivee.addItem("N1-Médecine polyvalente");
		listeArrivee.addItem("N1-Anti-tuberculose");
		listeArrivee.addItem("N2-Pneumologie");
		listeArrivee.addItem("N2-Chirurgie");
		listeArrivee.addItem("N2-Chirurgie de la main");
		listeArrivee.addItem("N2-Pédiatrie");
		listeArrivee.addItem("N3-Cardiologie");
		listeArrivee.addItem("N3-Gériatrie");
		listeArrivee.addItem("N4-Hématologie");
		
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