import java.awt.event.*;
import java.io.IOException;


public class Action2Event implements ActionListener {
	private ActionController _actionController;

	public Action2Event(ActionController actionController){
		this._actionController=actionController;
	}

	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Clicked2");

		try {
			this._actionController.boutonTrajet();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
}


