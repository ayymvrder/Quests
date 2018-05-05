package fr.plutonia.quests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author SkyDiams
 * @since 4 juin 2017:22:26:16
 * @version 1.1 This class is make 4 juin 2017 This api is public but is is
 *          under Apache License This api is the property of @author Mathieu
 *          Dejoie
 *
 */
public class SQLBase {

	private String urlBase;
	private String host;
	private String database;
	private String username;
	private String password;
	private Connection connection;

	/**
	 * 
	 * @param urlBase
	 * @param host
	 * @param database
	 * @param username
	 * @param password
	 */
	public SQLBase(String urlBase, String host, String database, String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		this.urlBase = urlBase;
		this.host = host;
		this.database = database;
		this.username = username;
		this.password = password;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:28:12
	 * @return Connection
	 * @return
	 * @throws SQLException 
	 */
	public SQLBase init(String table) throws SQLException {
		Statement state = connection.createStatement();
		state.executeUpdate("CREATE TABLE IF NOT EXISTS " + table + " (Player varchar(50) NOT NULL, LastQuest varchar(50), Quest varchar(100) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=latin1;");
		state.close();
		System.out.println("Connexion à la base de donnée réussite !");
		return this;
	}
	
	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:27:59
	 * @return SQLBase
	 * @return
	 */
	public static SQLBase getInstance() {
		return new SQLBase(null, null, null, null, null);
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:28:02
	 * @return String
	 * @return
	 */
	public String getDataBase() {
		return this.database;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:28:05
	 * @return void
	 */
	public void connection() {
		if (!isConnected()) {
			try {
				this.connection = DriverManager.getConnection(this.urlBase + this.host + "/" + this.database,
						this.username, this.password);
				return;
			} catch (SQLException e) {
				System.err.println("Connection a la Database impossible!");
				return;
			}

		}
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:28:07
	 * @return void
	 */
	public void deconnection() {
		if (isConnected()) {
			try {
				this.connection.close();
				return;
			} catch (SQLException e) {
				System.err.println("Deconnection impossible de la Database!");
				return;
			}
		}
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:28:09
	 * @return boolean
	 * @return
	 */
	public boolean isConnected() {
		try {
			if ((this.connection == null) || (this.connection.isClosed()) || (this.connection.isValid(5))) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.err.println("isConnected class Database erronee");
		}
		return false;
	}

	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:28:12
	 * @return Connection
	 * @return
	 */
	public Connection getConnection() {
		return connection;
	}
	
	/**
	 * 
	 * @author SkyDiams aka Mathieu Dejoie
	 * @since 4 juin 2017:22:28:12
	 * @return Connection
	 * @return
	 */
	public SQL make() {
		return new SQL(this);
	}

}
