// importation des bibliothèques JDBC
import java.sql.*;


public class CheckUpModel{

	private Connection _conn;

	public CheckUpModel(){

		String nomUser = "root"; // Utilisateur de la BD
		String passwd = ""; // Password de l'utilisateur de la BD
		String url = "jdbc:mysql://localhost/"; // Serveur de la BD
		String nomBase = "estiajdbc"; // Nom de la BD sur laquelle nous allons acceder
		_conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			_conn=DriverManager.getConnection(url+nomBase, nomUser, passwd);
			System.out.println("Je me connecte a la base de donnees: " + nomBase);
		}
		catch (SQLException ex1)
		{
			System.out.println("J'ai détecté une erreur de type SQL: " + ex1.getMessage());
		}
		catch (Exception ex2)
		{
			System.out.println("J'ai détecté une erreur de type lang: " + ex2.getMessage());
		}
		System.out.println("Base de donnée connecté");
	}


	public String getTension(int id){ 
		String resTension="lol";
		try {

			String requete = new String ("SELECT tension FROM patient WHERE id=?;");
			PreparedStatement stmt = _conn.prepareStatement(requete);

			// on indique les ? à remplir ! attention ici different de c l'indice commence à 1!
			stmt.setInt(1, id);

			//on execute
			ResultSet rs = stmt.executeQuery();			

			//on lit rs 
			if(rs.next()){
				resTension = rs.getString("tension");

			}
		}

		catch (SQLException ex3)
		{
			while (ex3 != null){

				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}

		}
		return resTension;
	}

	public String getRythme(int id){ 
		String resRythme="lol";
		try {

			String requete = new String ("SELECT rythmeCardiaque FROM patient WHERE id=?;");
			PreparedStatement stmt = _conn.prepareStatement(requete);

			// on indique les ? à remplir ! attention ici different de c l'indice commence à 1!
			stmt.setInt(1, id);

			//on execute
			ResultSet rs = stmt.executeQuery();			

			//on lit rs 
			if(rs.next()){
				resRythme = rs.getString("rythmeCardiaque");

			}

		}

		catch (SQLException ex3)
		{
			while (ex3 != null){

				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}

		}
		return resRythme;
	}

	public void fermerConnexion(){
		try
		{
			if (_conn != null)
				_conn.close();
		}
		catch (SQLException ex1)
		{
			System.out.println("J'ai détecté une erreur de type SQL: " + ex1.getMessage());
		}
	}

}