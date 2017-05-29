package ar.uba.fi.feedlot.main;

public class Corral {
	
	/*public enum Weather {
		LLUVIOSO, CALUROSO, FRIO
	}*/
		
	//private Weather clima; 
	private int cabezas;
	private int dia;
	private double pesoInicial;
	//private double racion;
	private double pesoActual;
	
	private double siloSorgo;
	private double maiz;
	private double expellerSoja;
	private double preMezclaMineral;
	private double materiaSeca;
	//private double humedad;
	private double porcentajePesoEnMS;
	
	public Corral(int cabezas, int dia, double pesoInicial){//, Weather w) {
		this.cabezas = cabezas;
		this.dia = dia;
		this.pesoInicial = pesoInicial;
		pesoActual = pesoInicial;
		//clima = w;
		//racion = 0;
	}
	
	public int getCabezas() {
		return cabezas;
	}
	
	/*public Weather getClima() {
		return clima;
	}*/
	
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
		return (pesoInicial + (this.dia - 21)*1.2);
	}
	
	public void setPesoActual() {
		pesoActual = pesoInicial + (this.dia - 25)*1.2;
	}
	
	public double getSiloSorgo() {
		return siloSorgo;
	}
	public double getMaiz() {
		return maiz;
	}
	public double getExpellerSoja() {
		return expellerSoja;
	}
	
	public double getPreMezclaMineral() {
		return preMezclaMineral;
	}
	public double getMateriaSeca() {
		return materiaSeca;
	}
	/*public double getHumedad() {
		return humedad;
	}*/
	public double getPorcentajePesoEnMS() {
		return porcentajePesoEnMS;
	}
	
	public void setMaiz(double value){
		maiz = value;
	}
	
	public void setExpellerSoja(double value){
		expellerSoja = value;
	}
	public void setPreMezclaMineral(double value){
		preMezclaMineral = value;
	}
	public void setMateriaSeca(double value){
		materiaSeca = value;
	}
	
	/*public void setHumedad(double value){
		humedad = value;
	}*/
	
	public void setPorcentajePesoEnMS(double value){
		porcentajePesoEnMS = value;
	}
	public void setSiloSorgo(double value){
		siloSorgo = value;
	}
	
		
	public double getKilosMateriaSecaDeHoy() {
		return (pesoActual*porcentajePesoEnMS*cabezas);
	}
	
	public double getHumedadDeHoy() {
		return (1 - materiaSeca)*(getKilosMateriaSecaDeHoy()/materiaSeca);
	}
	
	public double getKilosSiloSorgoHoy() {
		return siloSorgo*getKilosMateriaSecaDeHoy();
	}
	public double getKilosMaizHoy() {
		return maiz*getKilosMateriaSecaDeHoy();
	}
	public double getKilosExpellerSojaHoy() {
		return expellerSoja*getKilosMateriaSecaDeHoy();
	}
	
	public double getKilosPreMezclaMineralHoy() {
		return preMezclaMineral*getKilosMateriaSecaDeHoy();
	}
}
