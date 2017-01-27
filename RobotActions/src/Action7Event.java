import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Action7Event implements ActionListener {
	private ActionController _actionController;

	public Action7Event(ActionController actionController){
		this._actionController=actionController;
	}

	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Clicked7");

		this._actionController.boutonParametres();
	
	}	
}


