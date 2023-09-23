package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoDB {
	private static Connection conn;
	
	private static void abrirConexao() {
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:Banco_de_Dados.db");
		
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("Não foi possível abrir a conexão com o banco!");
			e.printStackTrace();
		} catch (ClassNotFoundException e2) {
			System.err.println(e2.getMessage());
			System.err.println("Ocorreu uma falha ao utilizar o driver!");
		}
	}
	
	
	
	public static void fecharConexao() {
		
		if (conn == null) 
			return;
		try {
			if (!conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("ERRO NO FECHAMENTO");
		}
		
	}
	
	
	
	public static Connection getConexao() {
		
		try {
			
			if (conn == null)
				abrirConexao();
			if (conn.isClosed());
				abrirConexao();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("não foi possivel abri o banco");
		}
		return conn;
	}
	
	
	
	public static void initDB() {
		try {
			
			conn = getConexao();
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate("DROP TABLE IF EXISTS tbl_produto");
			stmt.executeUpdate("CREATE TABLE tbl_produto (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
					+ "nome TEXT NOT NULL,"
					+ "descr TEXT NOT NULL,"
					+ "qtd TEXT NOT NULL,"
					+ "preco TEXT NOT NULL)");
			
			stmt.executeUpdate("INSERT INTO tbl_produto VALUES (null, 'joel')");
			stmt.executeUpdate("INSERT INTO tbl_produto VALUES (null, 'tulio')");
			stmt.isClosed();
			
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("não criou o banco");
		}
	}
	
	
	public static void alterarDB(String query) throws SQLException {
		
		Connection db = ConexaoDB.getConexao();
		Statement stmt = db.createStatement();
		stmt.executeUpdate(query);
		stmt.close();
		
	}
	
	
	
	
}
