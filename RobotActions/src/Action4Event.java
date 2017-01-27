import java.awt.event.*;
import java.io.IOException;


public class Action4Event implements ActionListener {
	private ActionController _actionController;

	public Action4Event(ActionController actionController){
		this._actionController=actionController;
	}

	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Clicked4");

		try {
			this._actionController.boutonCheckUp();

		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
}


