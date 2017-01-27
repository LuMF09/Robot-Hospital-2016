
/* Classe principale qui permet de configurer ce qui apparait */

import javax.swing.*;

import java.awt.*;

public class InfosView extends JFrame {

	/* Variables d’instance */

	private static final long serialVersionUID = 1L;
	private JLabel idLabel, nomLabel, prenomLabel, ageLabel, vide1Label, vide2Label, blank1,gpSanguinLabel,_nomRes,_prenomRes,_ageRes,_gpSanguinRes;
	private JTextField _idTextField;
	private JButton retourButton, envoie;

	/* Constructeurs */

	public InfosView(InfosController infosController) {
		super();


		this.setTitle("Informations du patient");


		/* Labels */
		idLabel = new JLabel("ID Patient :                                  ");
		nomLabel = new JLabel("Nom : ");
		prenomLabel = new JLabel("Prénom :");
		ageLabel = new JLabel ("Age : ");
		gpSanguinLabel=new JLabel ("Groupe Sanguin : ");
		vide1Label = new JLabel("");
		vide2Label = new JLabel("");
		blank1 = new JLabel("");
		_nomRes = new JLabel("");
		_prenomRes = new JLabel("");
		_ageRes = new JLabel("");
		_gpSanguinRes = new JLabel("");		
		_idTextField = new JTextField("");

		/* Button */
		retourButton = new JButton("Retour");
		retourButton.addActionListener(new InfosEvent(infosController));
		envoie = new JButton("Envoyer");
		envoie.addActionListener(new Infos2Event(infosController));

		/* Création de la grille et positionnement des éléments */
		Container pan = this.getContentPane();
		pan.setLayout(new BorderLayout());
		JPanel c = new JPanel();
		c.setLayout(new GridLayout(8,2));
		pan.add(c, BorderLayout.CENTER);

		c.add(idLabel); c.add(_idTextField);
		c.add(blank1); c.add(envoie);
		c.add(nomLabel); c.add(_nomRes);
		c.add(prenomLabel); c.add(_prenomRes);
		c.add(ageLabel); c.add (_ageRes);
		c.add(vide1Label); c.add(vide2Label);
		c.add(gpSanguinLabel);c.add(_gpSanguinRes);


		pan.add(retourButton,BorderLayout.SOUTH);

		this.pack(); /* pack() sert à dimensionner le container au format des éléments qu'il contient. C'est une sorte d'autofit */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* Redonner le contrôle à la console lors de la fermeture de la fenêtre */
	}

	private InfosModel _infosModel = new InfosModel();
	/* Définir les fonctions qui permettent de récupérer les valeurs et de les convertir si besoin */


	public void afficher (boolean b) {
		this.setVisible(b);
	}

	public void destroyFrame()
	{
		this.pack();
		this.setVisible(false);
		this.dispose();
	}

	public int getId(){
		return Integer.parseInt(_idTextField.getText());
	}

	public void afficherNom(){
		String nomFinal = String.valueOf(_infosModel.getNom(this.getId()));
		_nomRes.setText(nomFinal);
	}

	public void afficherPrenom(){
		String prenomFinal = String.valueOf(_infosModel.getPrenom(this.getId()));
		_prenomRes.setText(prenomFinal);
	}

	public void afficherAge(){
		String ageFinal = String.valueOf(_infosModel.getAge(this.getId()));
		_ageRes.setText(ageFinal);
	}

	public void afficherGpSanguin(){
		String gpSanguinFinal = String.valueOf(_infosModel.getGpSanguin(this.getId()));
		_gpSanguinRes.setText(gpSanguinFinal);
	}
}