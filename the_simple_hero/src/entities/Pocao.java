package entities;

public class Pocao {

	private Integer quantidade;
	
	public Pocao() {
	}

	public Pocao(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public String toString() {
		return "\nQuantidade de poções: " + getQuantidade();
	}
	
	public void comprarPocao(int quantidadeComprada) {
		setQuantidade(getQuantidade() + quantidadeComprada);
	}
	
}
