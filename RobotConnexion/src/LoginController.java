import java.io.BufferedInputStream;
import java.io.IOException;

public class LoginController {

	private LoginView _loginView;
	private LoginModel _loginModel;

	public LoginController(){
		_loginView=new LoginView(this);
		_loginModel=new LoginModel();
	}

	public void start(){
		_loginView.afficher(true);
	}

	public void boutonValider() throws IOException
	{
		if(_loginModel.estValide(_loginView.getLogin(), _loginView.getPassword())){
			_loginView.afficherMessage("Login correct");
			_loginView.destroyFrame();
			Process cat = Runtime.getRuntime().exec("java -jar D:/2A/Oriente_Objet/Projet/RobotActions.jar");
			BufferedInputStream catOutput= new BufferedInputStream(cat.getInputStream());
			int read = 0;
			byte[] output = new byte[1024];
			while ((read = catOutput.read(output)) != -1) {
				System.out.println(output[read]);
			}
		}
		else 
			_loginView.afficherMessage("Login incorrect"
					+ "      Cliquer sur ok pour réessayer");

	}
}
