package ar.uba.fi.feedlot.main;

import org.kie.api.io.ResourceType;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import ar.uba.fi.feedlot.main.helpers.PrintHelper;

public class Main {

	public static void main(String[] args) {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("licenseApplication.drl"), ResourceType.DRL);
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();

		Alimento food = new Alimento();
		Corral c = new Corral(30, 1, 220, food, 29);
		FactHandle factHandler = ksession.insert(c);
		ksession.fireAllRules();
		PrintHelper.printFoodRation(c);
		System.out.println("factor: " + c.getFactor());
		System.out.println(" ");

		c.setDia(10);
		c.setTemperatura(30);
		ksession.update(factHandler, c);
		ksession.fireAllRules();
		PrintHelper.printFoodRation(c);
		System.out.println("factor: " + c.getFactor());
		System.out.println(" ");

		c.setDia(20);
		c.setTemperatura(10);
		ksession.update(factHandler, c);
		ksession.fireAllRules();
		PrintHelper.printFoodRation(c);
		System.out.println("factor: " + c.getFactor());
		System.out.println(" ");

		c.setDia(50);
		ksession.update(factHandler, c);
		ksession.fireAllRules();
		PrintHelper.printFoodRation(c);
		System.out.println("factor: " + c.getFactor());
		
		

		c.setDia(30);
		c.setTemperatura(25);
		ksession.update(factHandler, c);
		ksession.fireAllRules();
		PrintHelper.printFoodRation(c);
		System.out.println("factor: " + c.getFactor());
		System.out.println(" ");
	}

}
