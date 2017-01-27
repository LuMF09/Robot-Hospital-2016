import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Action9Event implements ActionListener {
	private ActionController _actionController;

	public Action9Event(ActionController actionController){
		this._actionController=actionController;
	}

	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Clicked9");

		this._actionController.boutonMaintenance();
		/*
			else if(source==tension){
				this._actionController.boutonHT();
			}*/


	}	
}


