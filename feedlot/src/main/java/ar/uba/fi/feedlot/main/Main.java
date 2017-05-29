package ar.uba.fi.feedlot.main;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

//import ar.uba.fi.feedlot.main.Corral.Weather;


public class Main {

	public static void main(String[] args) {
		KieServices kieServices = KieServices.Factory.get();
		KieContainer kContainer = kieServices.getKieClasspathContainer();
		StatelessKieSession kSession = kContainer.newStatelessKieSession();
		
		Corral c = new Corral(30,1,220);//,Weather.FRIO);
		kSession.execute(c);
		System.out.println("La racion en MS de hoy es de " + c.getKilosMateriaSecaDeHoy() + " kg - (" + c.getMateriaSeca()*100 + "%)");
		System.out.println("Dividida en: ");
		System.out.println("Silo Sorgo " + c.getKilosSiloSorgoHoy() + " kg - (" + c.getSiloSorgo()*100 + "%)");
		System.out.println("Maiz " + c.getKilosMaizHoy() + " kg- (" + c.getMaiz()*100 + "%)");
		System.out.println("Expeller de Soja " + c.getKilosExpellerSojaHoy()  + " kg- (" + c.getExpellerSoja()*100 + "%)");
		System.out.println("Premezcla Mineral " + c.getKilosPreMezclaMineralHoy() + " kg - (" + c.getPreMezclaMineral()*100 + "%)");
		System.out.println("A la materia seca hay que agregarle " + c.getHumedadDeHoy() + " litros de agua ");
		System.out.println(" ");
		
		c.setDia(10);
		kSession.execute(c);
		System.out.println("La racion en MS de hoy es de " + c.getKilosMateriaSecaDeHoy() + " kg - (" + c.getMateriaSeca()*100 + "%)");
		System.out.println("Dividida en: ");
		System.out.println("Silo Sorgo " + c.getKilosSiloSorgoHoy() + " kg - (" + c.getSiloSorgo()*100 + "%)");
		System.out.println("Maiz " + c.getKilosMaizHoy() + " kg- (" + c.getMaiz()*100 + "%)");
		System.out.println("Expeller de Soja " + c.getKilosExpellerSojaHoy()  + " kg- (" + c.getExpellerSoja()*100 + "%)");
		System.out.println("Premezcla Mineral " + c.getKilosPreMezclaMineralHoy() + " kg - (" + c.getPreMezclaMineral()*100 + "%)");
		System.out.println("A la materia seca hay que agregarle " + c.getHumedadDeHoy() + " litros de agua ");
		System.out.println(" ");
		
		c.setDia(20);
		kSession.execute(c);
		System.out.println("La racion en MS de hoy es de " + c.getKilosMateriaSecaDeHoy() + " kg - (" + c.getMateriaSeca()*100 + "%)");
		System.out.println("Dividida en: ");
		System.out.println("Silo Sorgo " + c.getKilosSiloSorgoHoy() + " kg - (" + c.getSiloSorgo()*100 + "%)");
		System.out.println("Maiz " + c.getKilosMaizHoy() + " kg- (" + c.getMaiz()*100 + "%)");
		System.out.println("Expeller de Soja " + c.getKilosExpellerSojaHoy()  + " kg- (" + c.getExpellerSoja()*100 + "%)");
		System.out.println("Premezcla Mineral " + c.getKilosPreMezclaMineralHoy() + " kg - (" + c.getPreMezclaMineral()*100 + "%)");
		System.out.println("A la materia seca hay que agregarle " + c.getHumedadDeHoy() + " litros de agua ");
		System.out.println(" ");
		
		c.setDia(50);
		kSession.execute(c);
		System.out.println("La racion en MS de hoy es de " + c.getKilosMateriaSecaDeHoy() + " kg - (" + c.getMateriaSeca()*100 + "%)");
		System.out.println("Dividida en: ");
		System.out.println("Silo Sorgo " + c.getKilosSiloSorgoHoy() + " kg - (" + c.getSiloSorgo()*100 + "%)");
		System.out.println("Maiz " + c.getKilosMaizHoy() + " kg- (" + c.getMaiz()*100 + "%)");
		System.out.println("Expeller de Soja " + c.getKilosExpellerSojaHoy()  + " kg- (" + c.getExpellerSoja()*100 + "%)");
		System.out.println("Premezcla Mineral " + c.getKilosPreMezclaMineralHoy() + " kg - (" + c.getPreMezclaMineral()*100 + "%)");
		System.out.println("A la materia seca hay que agregarle " + c.getHumedadDeHoy() + " litros de agua ");
	}
}
