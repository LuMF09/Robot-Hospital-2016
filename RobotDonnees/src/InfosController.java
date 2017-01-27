import java.io.BufferedInputStream;
import java.io.IOException;


public class InfosController {

	public InfosController() {
		super();
	}

	private InfosView _infosView = new InfosView(this); /* on met this car le constructeur InteretsView prend pour paramètre interetsController : on choisit l'instance de InteretsController que l'on est entrain de créer */

	public void start() {
		_infosView.afficher(true);
	}

	public void boutonRetour() throws IOException { 
		_infosView.destroyFrame();

		Process cat = Runtime.getRuntime().exec("java -jar D:/2A/Oriente_Objet/Projet/RobotActions.jar");
		BufferedInputStream catOutput= new BufferedInputStream(cat.getInputStream());
		int read = 0;
		byte[] output = new byte[1024];
		while ((read = catOutput.read(output)) != -1) {
			System.out.println(output[read]);
		}
	}
	public void boutonEnvoie() { 
		_infosView.afficherNom();
		_infosView.afficherPrenom();
		_infosView.afficherAge();
		_infosView.afficherGpSanguin();

	}

}