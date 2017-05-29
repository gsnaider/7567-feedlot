package ar.uba.fi.feedlot.main.helpers;

import ar.uba.fi.feedlot.main.Corral;

public class printHelper {
    public static void printFoodRation(Corral corral) {
        System.out.println("La racion en MS de hoy es de " + round(corral.getKilosMateriaSecaDeHoy()) + " kg - (" +
                round(corral.getAlimento().getMateriaSeca()*100) + "%)");
        System.out.println("Dividida en: ");
        System.out.println("Silo Sorgo " + round(corral.getKilosSiloSorgoHoy()) + " kg - (" + round(corral
                .getAlimento().getSiloSorgo()
                *100) + "%)");
        System.out.println("Maiz " + round(corral.getKilosMaizHoy()) + " kg- (" + corral.getAlimento().getMaiz()*100
                + "%)");
        System.out.println("Expeller de Soja " + round(corral.getKilosExpellerSojaHoy())  + " kg- (" + round(corral
                .getAlimento().getExpellerSoja()*100) + "%)");
        System.out.println("Premezcla Mineral " + round(corral.getKilosPreMezclaMineralHoy()) + " kg - (" +
                round(corral.getAlimento().getPreMezclaMineral()*100) + "%)");
    }

    private static double round(double value) {
        return Math.round(value * 100)/100;
    }
}
