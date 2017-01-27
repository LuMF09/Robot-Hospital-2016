import java.io.BufferedInputStream;
import java.io.IOException;


public class ActionController {

	private ActionView _actionView;

	public ActionController(){
		_actionView=new ActionView(this);
		
	}

	public void start(){
		_actionView.afficher(true);
	}

	public void boutonTrajet() throws IOException{

		_actionView.destroyFrame();

		Process cat = Runtime.getRuntime().exec("java -jar D:/2A/Oriente_Objet/Projet/RobotTrajet.jar");
		BufferedInputStream catOutput= new BufferedInputStream(cat.getInputStream());
		int read = 0;
		byte[] output = new byte[1024];
		while ((read = catOutput.read(output)) != -1) {
			System.out.println(output[read]);
		}
	}

	public void boutonDonneesPatient() throws IOException{

		_actionView.destroyFrame();

		Process cat = Runtime.getRuntime().exec("java -jar D:/2A/Oriente_Objet/Projet/RobotDonnees.jar");
		BufferedInputStream catOutput= new BufferedInputStream(cat.getInputStream());
		int read = 0;
		byte[] output = new byte[1024];
		while ((read = catOutput.read(output)) != -1) {
			System.out.println(output[read]);
		}
	}

	public void boutonCheckUp() throws IOException{

		_actionView.destroyFrame();

		Process cat = Runtime.getRuntime().exec("java -jar D:/2A/Oriente_Objet/Projet/RobotCheckUp.jar");
		BufferedInputStream catOutput= new BufferedInputStream(cat.getInputStream());
		int read = 0;
		byte[] output = new byte[1024];
		while ((read = catOutput.read(output)) != -1) {
			System.out.println(output[read]);
		}
	}

	public void boutonAlerte(){
		_actionView.afficherMessage("Le responsable est alerté!");

	}

	public void boutonHarnais(){
		_actionView.afficherMessage("Le harnais est déconnecté!");
	}
	public void boutonParametres(){
		_actionView.afficherMessage("Les paramètres robots ont été modifiés.");

	}
	public void boutonHistorique(){
		_actionView.afficherMessage("L'historique du robot est affiché.");

	}
	public void boutonMaintenance(){
		_actionView.afficherMessage("Le robot est en mode maintenance.");

	}
	public void boutonHT(){
		_actionView.afficherMessage("Le robot est mis hors tension.");
	}
	public void boutonDeconnexion() throws IOException{

		_actionView.destroyFrame();
		Process cat = Runtime.getRuntime().exec("java -jar D:/2A/Oriente_Objet/Projet/RobotConnexion.jar");
		BufferedInputStream catOutput= new BufferedInputStream(cat.getInputStream());
		int read = 0;
		byte[] output = new byte[1024];
		while ((read = catOutput.read(output)) != -1) {
			System.out.println(output[read]);
		}
		
	}

	/*private void setDfaultCloseOperation(int exitOnClose){
	//TODO Auto-generated function
}*/

}
