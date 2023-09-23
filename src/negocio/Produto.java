package negocio;

public class Produto {
	
	private int id;
	private String nome;
	private String descr;
	private String qtd;
	private String preco;
	
	
	
	public Produto(String nome, String descr, String qtd, String preco) {
		this.nome = nome;
		this.descr = descr;
		this.qtd = qtd;
		this.preco = preco;
	}
	
	
	public Produto(int id, String nome, String descr, String qtd, String preco) {
		this.id = id;
		this.nome = nome;
		this.descr = descr;
		this.qtd = qtd;
		this.preco = preco;
	}

	
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescr() {
		return descr;
	}


	public void setDescr(String descr) {
		this.descr = descr;
	}


	public String getQtd() {
		return qtd;
	}


	public void setQtd(String qtd) {
		this.qtd = qtd;
	}


	public String getPreco() {
		return preco;
	}


	public void setPreco(String preco) {
		this.preco = preco;
	}


	
	
	
	
	
	
	
}
