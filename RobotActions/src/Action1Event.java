import java.awt.event.*;
import java.io.IOException;


public class Action1Event implements ActionListener {
	private ActionController _actionController;

	public Action1Event(ActionController actionController){
		this._actionController=actionController;
	}

	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Clicked1");

		try {

			this._actionController.boutonDeconnexion();

		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
}


