import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckUp3Event implements ActionListener {

	/* Variables d’instance */

	private CheckUpController _checkUpController;

	/* Constructeurs */

	public CheckUp3Event(CheckUpController checkUpController) {
		super();
		_checkUpController = checkUpController;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Clicked.");
		_checkUpController.boutonEnvoie();
	}
}
