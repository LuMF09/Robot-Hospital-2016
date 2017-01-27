import java.io.BufferedInputStream;
import java.io.IOException;


public class CheckUpController {

	public CheckUpController() {
		super();
	}

	private CheckUpView _checkUpView = new CheckUpView(this); /* on met this car le constructeur InteretsView prend pour paramètre interetsController : on choisit l'instance de InteretsController que l'on est entrain de créer */

	public void start() {
		_checkUpView.afficher(true);
	}

	public void boutonRetour() throws IOException { 
		_checkUpView.destroyFrame();

		Process cat = Runtime.getRuntime().exec("java -jar D:/2A/Oriente_Objet/Projet/RobotActions.jar");
		BufferedInputStream catOutput= new BufferedInputStream(cat.getInputStream());
		int read = 0;
		byte[] output = new byte[1024];
		while ((read = catOutput.read(output)) != -1) {
			System.out.println(output[read]);
		}
	}
	public void boutonEnvoie() { 
		_checkUpView.afficherTension();
		_checkUpView.afficherRythme();
	}

	public void boutonEnvoyerResponsable(){
		_checkUpView.afficherMessage("La tension et le rythme cardiaque du patient ont été transmis au responsable.");
	}

}