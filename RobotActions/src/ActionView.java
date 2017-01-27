import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ActionView extends JFrame{

	private JButton deconnexion,trajet,donnees,check,alerte,harnais,param,historique,maintenance,tension;
	private ActionController _actionController;

	public ActionView(ActionController actionController){

		super("Actions réalisables");
		_actionController=actionController;

		// pan est un panneau
		Container pan = this.getContentPane();
		pan.setLayout(new BorderLayout());

		//Création des boutons
		JLabel quefaire ;
		quefaire = new JLabel("                                                       Que voulez-vous faire ?");
		pan.add(quefaire,BorderLayout.NORTH);

		deconnexion = new JButton("Déconnexion");
		pan.add(deconnexion,BorderLayout.SOUTH);
		//mettre l'action du bouton --> retour à interface connexion
		deconnexion.addActionListener(new Action1Event(_actionController));

		JLabel blanc;
		blanc=new JLabel("              ");
		pan.add(blanc,BorderLayout.CENTER);

		// création des sous panel

		JPanel sousPanelGauche = new JPanel();
		sousPanelGauche.setLayout(new GridLayout(4,1));
		pan.add(sousPanelGauche, BorderLayout.WEST);

		JPanel sousPanelDroit = new JPanel();
		sousPanelDroit.setLayout(new GridLayout(5,1));
		pan.add(sousPanelDroit, BorderLayout.EAST);

		// affectation boutons sous panel gauche

		trajet = new JButton("Programmer un trajet");
		sousPanelGauche.add(trajet);
		trajet.addActionListener(new Action2Event(_actionController));


		donnees = new JButton("Afficher les données du patient");
		sousPanelGauche.add(donnees);
		donnees.addActionListener(new Action3Event(_actionController));

		check = new JButton("Lancer le check-up du patient");
		sousPanelGauche.add(check);
		check.addActionListener(new Action4Event(_actionController));

		alerte = new JButton("Alerter le responsable");
		sousPanelGauche.add(alerte);
		alerte.addActionListener(new Action5Event(_actionController));

		// affectation boutons sous panel droit

		harnais = new JButton("Déconnecter le harnais");
		sousPanelDroit.add(harnais);
		harnais.addActionListener(new Action6Event(_actionController));

		param = new JButton("Modifier les paramètres robot");
		sousPanelDroit.add(param);
		param.addActionListener(new Action7Event(_actionController));

		historique = new JButton("Historique du robot");
		sousPanelDroit.add(historique);
		historique.addActionListener(new Action8Event(_actionController));

		maintenance = new JButton("Mettre en mode maintenance");
		sousPanelDroit.add(maintenance);
		maintenance.addActionListener(new Action9Event(_actionController));

		tension = new JButton("Mettre le robot Hors-Tension");
		sousPanelDroit.add(tension);
		tension.addActionListener(new Action10Event(_actionController));

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


}
