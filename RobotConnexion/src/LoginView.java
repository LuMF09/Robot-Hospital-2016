import javax.swing.*;

import java.awt.*;


@SuppressWarnings("serial")
public class LoginView extends JFrame {

	private JTextField _loginTextField ;
	private JPasswordField _mdpTextField ;

	public LoginView(LoginController loginController){
		super("Connexion");

		// pan est un panneau
		Container pan = this.getContentPane();
		pan.setLayout(new GridLayout(3,2));

		//Création des boutons

		JLabel login ;
		login = new JLabel("Login");
		pan.add(login);

		_loginTextField = new JTextField();
		pan.add(_loginTextField);

		JLabel mdp ;
		mdp = new JLabel("Mot de passe");
		pan.add(mdp);

		_mdpTextField = new JPasswordField();
		pan.add(_mdpTextField);

		JLabel vide ; 
		vide = new JLabel("");
		pan.add(vide);

		JButton valider ; 
		valider = new JButton("Valider");
		pan.add(valider);
		valider.addActionListener(new LoginEvent(loginController));

		this.pack();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void afficher(boolean ouiounon){
		setVisible(ouiounon);
	}

	public String getLogin(){
		return (_loginTextField.getText());
	}

	public String getPassword(){
		// new string pour créer une nouvelle chaine de caractère
		return new String(_mdpTextField.getPassword());
	}

	protected void afficherMessage(String msg)
	{
		JOptionPane.showMessageDialog(this,
				msg,
				"Information",
				JOptionPane.INFORMATION_MESSAGE);
	}
	public void destroyFrame()
	{
		this.pack();
		this.setVisible(false);
		this.dispose();
	}


}
