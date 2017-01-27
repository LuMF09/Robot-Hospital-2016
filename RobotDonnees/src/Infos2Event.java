import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Infos2Event implements ActionListener {
	
	/* Variables d’instance */

	private InfosController _infosController;
	
	/* Constructeurs */
	
	public Infos2Event(InfosController infosController) {
		super();
		_infosController = infosController;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Clicked.");
		_infosController.boutonEnvoie();
	}
}
