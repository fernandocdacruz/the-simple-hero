package entities;

public class Energia {

	private Integer energiaTotal;
	private Integer energiaAtual;

	public Energia() {
	}

	public Energia(Integer energiaTotal, Integer energiaAtual) {
		this.energiaTotal = energiaTotal;
		this.energiaAtual = energiaAtual;
	}

	public Integer getEnergiaTotal() {
		return energiaTotal;
	}

	public void setEnergiaTotal(Integer energiaTotal) {
		this.energiaTotal = energiaTotal;
	}

	public Integer getEnergiaAtual() {
		return energiaAtual;
	}

	public void setEnergiaAtual(Integer energiaAtual) {
		this.energiaAtual = energiaAtual;
	}

	public String toString() {
		return "\nEnergia: " + getEnergiaTotal();
	}

	public String mostrarDiferencaEnergia() {
		return getEnergiaTotal() + " / " + getEnergiaAtual();
	}

	public boolean compararEnergiaTotalEAtual() {
		return getEnergiaAtual() == getEnergiaTotal() ? true : false;
	}

	public void completarEnergia() {
		setEnergiaAtual(getEnergiaTotal());
	}
	
	public void aumentarEnergiaAtual(int aumento) {
		setEnergiaTotal(energiaTotal + aumento);
	}
	
	public boolean checarEnergia() {
		return energiaAtual <= 0 ? true : false;
	}
	
	public void receberDano(int dano) {
		setEnergiaAtual(energiaAtual - dano);
	}

}
