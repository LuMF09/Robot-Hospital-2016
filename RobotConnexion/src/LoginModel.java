import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
	private Connection _conn;

	public LoginModel(){

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
	public boolean estValide(String log, String mdp){
		boolean trouve= false;
		try
		{
			String requete = new String("SELECT id, nom, login FROM employe WHERE login=? AND mdp=MD5(?);");

			PreparedStatement stmt = _conn.prepareStatement(requete);
			stmt.setString(1, log);
			stmt.setString(2, mdp);
			ResultSet rs = stmt.executeQuery();

			if (rs.next ()) /* s'il y a au moins un enregistrement */
			{
				trouve = true;

			}

			rs.close();
			stmt.close();
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		return trouve;
	}
}
