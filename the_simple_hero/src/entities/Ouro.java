package entities;

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
	    return getQuantidade() >= valorCobrado;
	}

	public void debitarQuantidadeDeOuro(int valorADebitar) {
		setQuantidade(getQuantidade() - valorADebitar);
	}

	public String toString() {
		return "\nOuro: " + getQuantidade();
	}

}
