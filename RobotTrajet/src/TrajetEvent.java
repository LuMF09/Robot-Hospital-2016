import java.awt.event.*;
import java.io.IOException;


public class TrajetEvent implements ActionListener {
	private TrajetController _trajetController;

	public TrajetEvent(TrajetController trajetController){
		this._trajetController=trajetController;
	}

	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Clicked1");

		try {

			this._trajetController.boutonRetour();

		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
}


