package model.characters;

public class Ouro {

	private Integer quantidade;

	public Ouro() {
	}

	public Ouro(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public boolean testarQuantidadeDeOuro(int valorCobrado) {
	   return this.quantidade >= valorCobrado ? true : false;
	}

	public void debitarQuantidadeDeOuro(int valorADebitar) {
		setQuantidade(getQuantidade() - valorADebitar);
	}
	
	public void adicionarQuantidadeDeOuro(int valorAAdicionar) {
		setQuantidade(getQuantidade() + valorAAdicionar);
	}

	public String toString() {
		return "\nOuro: " + getQuantidade();
	}

}
