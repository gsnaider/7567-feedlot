package ar.uba.fi.feedlot.main;

public class Corral {

	private int cabezas;
	private int dia;
	private double pesoInicial;
	private double pesoActual;
	private int temperatura;
	private double factor;

	private double porcentajePesoEnMS;
	private Alimento food;

	public Corral(int cabezas, int dia, double pesoInicial, Alimento food, int temperatura) {
		this.cabezas = cabezas;
		this.dia = dia;
		this.pesoInicial = pesoInicial;
		pesoActual = pesoInicial;
		this.food = food;
		this.temperatura = temperatura;
		factor = 1;
	}

	public int getCabezas() {
		return cabezas;
	}

	public Alimento getAlimento() {
		return this.food;
	}

	public void setCabezas(int cabezas) {
		this.cabezas = cabezas;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int d) {
		this.dia = d;
	}

	public double getPesoActual() {
		return (pesoInicial + (this.dia - 21) * 1.2);
	}

	public void setPesoActual() {
		pesoActual = pesoInicial + (this.dia - 25) * 1.2;
	}

	public double getPorcentajePesoEnMS() {
		return porcentajePesoEnMS;
	}

	public void setPorcentajePesoEnMS(double value) {
		porcentajePesoEnMS = value;
	}

	public double getKilosMateriaSecaDeHoy() {
		return pesoActual * porcentajePesoEnMS * cabezas * factor;
	}

	public double getHumedadDeHoy() {
		return (1 - food.getMateriaSeca()) * (getKilosMateriaSecaDeHoy() / food.getMateriaSeca());
	}

	public double getKilosSiloSorgoHoy() {
		return food.getSiloSorgo() * getKilosMateriaSecaDeHoy();
	}

	public double getKilosMaizHoy() {
		return food.getMaiz() * getKilosMateriaSecaDeHoy();
	}

	public double getKilosExpellerSojaHoy() {
		return food.getExpellerSoja() * getKilosMateriaSecaDeHoy();
	}

	public double getKilosPreMezclaMineralHoy() {
		return food.getPreMezclaMineral() * getKilosMateriaSecaDeHoy();
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}

	public double getFactor() {
		return factor;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public int getTemperatura() {
		return temperatura;
	}
}
