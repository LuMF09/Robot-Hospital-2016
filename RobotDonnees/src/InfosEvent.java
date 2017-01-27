import java.awt.event.*;
import java.io.IOException;

public class InfosEvent implements ActionListener {
	
	/* Variables d’instance */

	private InfosController _infosController;
	
	/* Constructeurs */
	
	public InfosEvent(InfosController infosController) {
		super();
		_infosController = infosController;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Clicked.");
		try {
			_infosController.boutonRetour();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
