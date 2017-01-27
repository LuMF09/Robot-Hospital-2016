import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CheckUpEvent implements ActionListener {

	/* Variables d’instance */

	private CheckUpController _checkUpController;

	/* Constructeurs */

	public CheckUpEvent(CheckUpController checkUpController) {
		super();
		_checkUpController = checkUpController;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Clicked.");
		try {
			_checkUpController.boutonRetour();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
