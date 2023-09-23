package negocio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoDB;

public class ProdutoDAO implements InterfaceDAO{
	
	
	@Override
	public void addProduto(Produto produto) {
		try {
			
			String query = "INSERT INTO tbl_produto VALUES (null" + produto.getNome() + ", " + produto.getDescr() + ", "
					+ produto.getQtd() + ", " + produto.getPreco() + ")";
			ConexaoDB.alterarDB(query);
			
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("erro ao add produto");
		}
	}
	
	@Override
	public void removerProduto(Produto produto) {
		
		try {
			
			String query = "DELETE FROM tbl_produto WHERE id = " + produto.getId();
			ConexaoDB.alterarDB(query);
		
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("erro na deletação do produto!!");
		}
		
		
	}
	
	@Override
	public void attProduto(Produto produto) {
		try {
		
			String query = "UPDATE tbl_produto SET nome = " + produto.getNome() + ", descr = " + produto.getDescr() + ", qtd = "
				+ produto.getQtd() + ", preco =" + produto.getPreco();
			ConexaoDB.alterarDB(query);
		
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("erro no atualizaçao do produto!!");
		}
		
		
	}
	
	@Override
	public List<Produto> buscar() {
		try {
			
			Connection db = ConexaoDB.getConexao();
			Statement stmt = db.createStatement();
			String query = "SELECT * FROM tbl_produto";
			
			try (ResultSet rs = stmt.executeQuery(query)) {
				
				List<Produto> produtos = new ArrayList<Produto>();
				
				while (rs.next()) {
					Produto produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("descr"), rs.getString("qtd"), rs.getString("proco"));
					produtos.add(produto);
				}
				return produtos;
				
			} catch (SQLException e) {
				System.err.println("erro na lista de prod");
				System.err.println(e.getMessage());
			}
			
			
		} catch (SQLException e) {
			System.err.println("erro na lista de prod");
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	
	

}
