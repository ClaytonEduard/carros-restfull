package br.com.livro.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {

	public BaseDAO() {
		try {
			// necessario para utilizar o drive do JDBC do MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// erro de driver JDBC
			e.printStackTrace();
		}
	}

	protected Connection getConnection() throws SQLException {
		// url de conexao com o banco de dados
		String URL = "jdbc:mysql://localhost/livro";
		// Conecta utilizando a url, usuario e senha;
		Connection conn = DriverManager.getConnection(URL, "livro", "livro123");
		return conn;
	}

	public static void main(String[] args) throws SQLException {
		BaseDAO db = new BaseDAO();
		//testa conexao
		Connection connection =db.getConnection();
		System.out.println(connection);
	}
}
