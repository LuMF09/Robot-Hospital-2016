import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Action6Event implements ActionListener {
	private ActionController _actionController;

	public Action6Event(ActionController actionController){
		this._actionController=actionController;
	}

	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Clicked6");

		this._actionController.boutonHarnais();
	}	
}


