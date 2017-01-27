import java.awt.event.*;
import java.io.IOException;

public class LoginEvent implements ActionListener {
	private LoginController _loginController;
	
	public LoginEvent(LoginController loginController){
		this._loginController=loginController;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Clicked");
		try {
			this._loginController.boutonValider();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
