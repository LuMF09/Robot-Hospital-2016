// importation des bibliothèques JDBC
import java.sql.*;


public class InfosModel{

	private Connection _conn;

	public InfosModel(){

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


	public String getNom(int id){ 
		String resNom="lol";
		try {

			String requete = new String ("SELECT nom FROM patient WHERE id=?;");
			PreparedStatement stmt = _conn.prepareStatement(requete);

			// on indique les ? à remplir ! attention ici different de c l'indice commence à 1!
			stmt.setInt(1, id);

			//on execute
			ResultSet rs = stmt.executeQuery();			

			//on lit rs 
			if(rs.next()){
				resNom = rs.getString("nom");

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
		return resNom;
	}

	public String getPrenom(int id){ 
		String resPrenom="lol";
		try {

			String requete = new String ("SELECT prenom FROM patient WHERE id=?;");
			PreparedStatement stmt = _conn.prepareStatement(requete);

			// on indique les ? à remplir ! attention ici different de c l'indice commence à 1!
			stmt.setInt(1, id);

			//on execute
			ResultSet rs = stmt.executeQuery();			

			//on lit rs 
			if(rs.next()){
				resPrenom = rs.getString("prenom");

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
		return resPrenom;
	}

	public int getAge(int id){ 
		int resAge=0;
		try {

			String requete = new String ("SELECT age FROM patient WHERE id=?;");
			PreparedStatement stmt = _conn.prepareStatement(requete);

			// on indique les ? à remplir ! attention ici different de c l'indice commence à 1!
			stmt.setInt(1, id);

			//on execute
			ResultSet rs = stmt.executeQuery();			

			//on lit rs 
			if(rs.next()){
				resAge = rs.getInt("age");

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
		return resAge;
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


	public String getGpSanguin(int id){ 
		String resGpSanguin="lol";
		try {

			String requete = new String ("SELECT gpSanguin FROM patient WHERE id=?;");
			PreparedStatement stmt = _conn.prepareStatement(requete);

			// on indique les ? à remplir ! attention ici different de c l'indice commence à 1!
			stmt.setInt(1, id);

			//on execute
			ResultSet rs = stmt.executeQuery();			

			//on lit rs 
			if(rs.next()){
				resGpSanguin = rs.getString("gpSanguin");

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
		return resGpSanguin;
	}
}