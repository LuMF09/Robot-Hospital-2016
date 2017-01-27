
/* Classe principale qui permet de configurer ce qui apparait */

import javax.swing.*;

import java.awt.*;

public class CheckUpView extends JFrame {

	/* Variables d’instance */

	private static final long serialVersionUID = 1L;
	private JLabel idLabel, tensionLabel, rythmeLabel, _resTension,_resRythme,blank1,blank2,blank3,blank4,blank5,blank6;
	private JTextField _idTextField;
	private JButton retourButton, envoie,envoieResponsable;

	/* Constructeurs */

	public CheckUpView(CheckUpController checkUpController) {
		super();


		this.setTitle("Informations du patient");


		/* Labels */
		idLabel = new JLabel("ID Patient :                                  ");	
		_idTextField = new JTextField("");
		
		tensionLabel = new JLabel("Tension:");
		_resTension = new JLabel("");
		
		rythmeLabel = new JLabel("Rythme cardiaque:");
		_resRythme = new JLabel("");
		
		blank1 = new JLabel("");
		blank2 = new JLabel("");
		blank3 = new JLabel("");
		blank4 = new JLabel("");
		blank5 = new JLabel("");
		blank6 = new JLabel("");
		

		/* Button */
		retourButton = new JButton("Retour");
		retourButton.addActionListener(new CheckUpEvent(checkUpController));
		envoie = new JButton("Envoyer");
		envoie.addActionListener(new CheckUp3Event(checkUpController));
		envoieResponsable=new JButton("Envoyer les données au responsable");
		envoieResponsable.addActionListener(new CheckUp2Event(checkUpController));

		/* Création de la grille et positionnement des éléments */
		Container pan = this.getContentPane();
		pan.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		north.setLayout(new GridLayout(6,2));
		pan.add(north, BorderLayout.NORTH);

		north.add(idLabel); north.add(_idTextField);
		north.add(blank1); north.add(envoie);
		north.add(blank2); north.add(blank3);
		north.add(tensionLabel); north.add(_resTension);
		north.add(rythmeLabel); north.add (_resRythme);
		north.add(blank4); north.add(blank5);
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,0));
		pan.add(center, BorderLayout.CENTER);
		
		center.add(envoieResponsable); 
		center.add(blank6);

		pan.add(retourButton,BorderLayout.SOUTH);

		this.pack(); /* pack() sert à dimensionner le container au format des éléments qu'il contient. C'est une sorte d'autofit */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* Redonner le contrôle à la console lors de la fermeture de la fenêtre */
	}

	private CheckUpModel _checkUpModel = new CheckUpModel();
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

	public void afficherTension(){
		String tensionFinal = String.valueOf(_checkUpModel.getTension(this.getId()));
		_resTension.setText(tensionFinal);
	}

	public void afficherRythme(){
		String rythmeFinal = String.valueOf(_checkUpModel.getRythme(this.getId()));
		_resRythme.setText(rythmeFinal);
	}

	protected void afficherMessage(String msg)
	{
		JOptionPane.showMessageDialog(this,
				msg,
				"Information",
				JOptionPane.INFORMATION_MESSAGE);
	}
}