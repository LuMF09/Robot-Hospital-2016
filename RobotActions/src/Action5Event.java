import java.awt.event.*;


public class Action5Event implements ActionListener {
	private ActionController _actionController;

	public Action5Event(ActionController actionController){
		_actionController=actionController;
	}
	
	public Action5Event() {
			_actionController= new ActionController();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Clicked5");

		_actionController.boutonAlerte();
	}	
}


