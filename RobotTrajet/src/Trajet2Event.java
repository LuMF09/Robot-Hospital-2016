import java.awt.event.*;
import java.io.IOException;


public class Trajet2Event implements ActionListener {
	private TrajetController _trajetController;

	public Trajet2Event(TrajetController trajetController){
		this._trajetController=trajetController;
	}

	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Clicked2");

		try {
			this._trajetController.boutonLancer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
}


