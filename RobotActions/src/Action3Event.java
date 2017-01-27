import java.awt.event.*;
import java.io.IOException;


public class Action3Event implements ActionListener {
	private ActionController _actionController;

	public Action3Event(ActionController actionController){
		this._actionController=actionController;
	}

	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Clicked3");

		try {
			this._actionController.boutonDonneesPatient();

		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
}


