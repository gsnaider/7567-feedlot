package ar.uba.fi.feedlot.main;

import ar.uba.fi.feedlot.main.helpers.printHelper;
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
		printHelper.printFoodRation(c);
		System.out.println(" ");
		
		c.setDia(10);
		kSession.execute(c);
		printHelper.printFoodRation(c);
		System.out.println(" ");
		
		c.setDia(20);
		kSession.execute(c);
		printHelper.printFoodRation(c);
		System.out.println(" ");
		
		c.setDia(50);
		kSession.execute(c);
		printHelper.printFoodRation(c);
	}
}
