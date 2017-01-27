import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Action8Event implements ActionListener {
	private ActionController _actionController;

	public Action8Event(ActionController actionController){
		this._actionController=actionController;
	}

	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Clicked8");

		this._actionController.boutonHistorique();
		
	}	
}


