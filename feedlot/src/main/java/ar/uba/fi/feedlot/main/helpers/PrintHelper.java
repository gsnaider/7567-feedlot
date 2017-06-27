package ar.uba.fi.feedlot.main.helpers;

import java.text.DecimalFormat;

import ar.uba.fi.feedlot.main.Corral;

public class PrintHelper {
	public static void printFoodRation(Corral corral) {
		System.out.println("La racion en MS de hoy es de " + round(corral.getKilosMateriaSecaDeHoy()) + " kg - ("
				+ round(corral.getAlimento().getMateriaSeca() * 100) + "%)");
		System.out.println("Dividida en: ");
		System.out.println("Silo Sorgo " + round(corral.getKilosSiloSorgoHoy()) + " kg - ("
				+ round(corral.getAlimento().getSiloSorgo() * 100) + "%)");
		System.out.println(
				"Maiz " + round(corral.getKilosMaizHoy()) + " kg- (" + round(corral.getAlimento().getMaiz() * 100) + "%)");
		System.out.println("Expeller de Soja " + round(corral.getKilosExpellerSojaHoy()) + " kg- ("
				+ round(corral.getAlimento().getExpellerSoja() * 100) + "%)");
		System.out.println("Premezcla Mineral " + round(corral.getKilosPreMezclaMineralHoy()) + " kg - ("
				+ round(corral.getAlimento().getPreMezclaMineral() * 100) + "%)");
		System.out.println(
				"A la materia seca hay que agregarle " + round(corral.getHumedadDeHoy()) + " litros " + "de agua ");
	}

	public static String round(double value) {
		DecimalFormat df = new DecimalFormat("#.00"); 
		return df.format(value);
	}
}
