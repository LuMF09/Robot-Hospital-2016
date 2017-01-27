import java.io.BufferedInputStream;
import java.io.IOException;


public class TrajetController {
	private TrajetView _trajetView;

	public TrajetController(){
		_trajetView=new TrajetView(this);

	}

	public void start(){
		_trajetView.afficher(true);
	}

	public void boutonRetour() throws IOException{

		_trajetView.destroyFrame();

		Process cat = Runtime.getRuntime().exec("java -jar D:/2A/Oriente_Objet/Projet/RobotActions.jar");
		BufferedInputStream catOutput= new BufferedInputStream(cat.getInputStream());
		int read = 0;
		byte[] output = new byte[1024];
		while ((read = catOutput.read(output)) != -1) {
			System.out.println(output[read]);
		}
	}

	public void boutonLancer() throws IOException{

		if(!_trajetView.isTick1() && ! _trajetView.isTick2()){
			_trajetView.afficherMessage("Veuillez cocher une case et effectuer votre choix");
			_trajetView.destroyFrame();

			Process cat = Runtime.getRuntime().exec("java -jar D:/2A/Oriente_Objet/Projet/RobotTrajet.jar");
			BufferedInputStream catOutput= new BufferedInputStream(cat.getInputStream());
			int read = 0;
			byte[] output = new byte[1024];
			while ((read = catOutput.read(output)) != -1) {
				System.out.println(output[read]);
			}
	
		}
		else if(_trajetView.isTick1() && _trajetView.isTick2()){
			_trajetView.afficherMessage("Veuillez décocher une case et effectuer votre choix");
			_trajetView.destroyFrame();

			Process cat = Runtime.getRuntime().exec("java -jar D:/2A/Oriente_Objet/Projet/RobotTrajet.jar");
			BufferedInputStream catOutput= new BufferedInputStream(cat.getInputStream());
			int read = 0;
			byte[] output = new byte[1024];
			while ((read = catOutput.read(output)) != -1) {
				System.out.println(output[read]);
			}

		}
		else if(_trajetView.isTick1()){
			_trajetView.afficherMessage("L'itinéraire se calcule ...");
			_trajetView.afficherMessage("Le robot effectue une balade paisible");
			_trajetView.destroyFrame();

			Process cat = Runtime.getRuntime().exec("java -jar D:/2A/Oriente_Objet/Projet/RobotActions.jar");
			BufferedInputStream catOutput= new BufferedInputStream(cat.getInputStream());
			int read = 0;
			byte[] output = new byte[1024];
			while ((read = catOutput.read(output)) != -1) {
				System.out.println(output[read]);
			}

		}
		else if(_trajetView.isTick2()){
			_trajetView.afficherMessage("L'itinéraire se calcule ...");
			_trajetView.afficherMessage("Le robot effectue son trajet de façon optimisée");
			_trajetView.destroyFrame();

			Process cat = Runtime.getRuntime().exec("java -jar D:/2A/Oriente_Objet/Projet/RobotActions.jar");
			BufferedInputStream catOutput= new BufferedInputStream(cat.getInputStream());
			int read = 0;
			byte[] output = new byte[1024];
			while ((read = catOutput.read(output)) != -1) {
				System.out.println(output[read]);
			}

		}		

	}
}


