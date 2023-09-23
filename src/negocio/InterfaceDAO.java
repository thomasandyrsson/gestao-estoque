package negocio;

import java.util.List;

public interface InterfaceDAO {
	
	void addProduto(Produto produto);
	void removerProduto(Produto produto);
	void attProduto(Produto produto);
	List<Produto> buscar();
	
}
