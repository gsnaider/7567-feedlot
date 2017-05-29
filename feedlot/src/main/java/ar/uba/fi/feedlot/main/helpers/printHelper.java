package ar.uba.fi.feedlot.main.helpers;

import ar.uba.fi.feedlot.main.Corral;

public class printHelper {
    public static void printFoodRation(Corral corral) {
        System.out.println("La racion en MS de hoy es de " + round(corral.getKilosMateriaSecaDeHoy()) + " kg - (" +
                round(corral.getMateriaSeca()*100) + "%)");
        System.out.println("Dividida en: ");
        System.out.println("Silo Sorgo " + round(corral.getKilosSiloSorgoHoy()) + " kg - (" + round(corral.getSiloSorgo()
                *100) + "%)");
        System.out.println("Maiz " + round(corral.getKilosMaizHoy()) + " kg- (" + corral.getMaiz()*100 + "%)");
        System.out.println("Expeller de Soja " + round(corral.getKilosExpellerSojaHoy())  + " kg- (" + round(corral
                .getExpellerSoja()*100) + "%)");
        System.out.println("Premezcla Mineral " + round(corral.getKilosPreMezclaMineralHoy()) + " kg - (" +
                round(corral.getPreMezclaMineral()*100) + "%)");
    }

    private static double round(double value) {
        return Math.round(value * 100)/100;
    }
}
