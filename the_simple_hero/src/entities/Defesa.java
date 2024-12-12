package entities;

public class Defesa {

	private Integer defesa;
	
	public Defesa() {
	}

	public Defesa(Integer defesa) {
		this.defesa = defesa;
	}

	public Integer getDefesa() {
		return defesa;
	}

	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}
	
	public String toString() {
		return "\nDefesa: " + getDefesa();
	}
	
	public void aumentarDefesaAtual(int valor) {
		setDefesa(getDefesa() + valor);
	}
	
}
