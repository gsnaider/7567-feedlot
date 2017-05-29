package ar.uba.fi.feedlot.main;

import ar.uba.fi.feedlot.main.helpers.printHelper;
import org.drools.core.marshalling.impl.ProtobufMessages;
import org.kie.api.KieServices;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

//import ar.uba.fi.feedlot.main.Corral.Weather;


public class Main {

	public static void main(String[] args) {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("licenseApplication.drl"), ResourceType.DRL);
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();


		Corral c = new Corral(30,1,220);//,Weather.FRIO);
		FactHandle factHandler = ksession.insert(c);
		ksession.fireAllRules();
		printHelper.printFoodRation(c);
		System.out.println(" ");


		c.setDia(10);
		ksession.update(factHandler ,c);
		ksession.fireAllRules();
		printHelper.printFoodRation(c);
		System.out.println(" ");
		
		c.setDia(20);
		ksession.update(factHandler ,c);
		ksession.fireAllRules();
		printHelper.printFoodRation(c);
		System.out.println(" ");
		
		c.setDia(50);
		ksession.update(factHandler ,c);
		ksession.fireAllRules();
		printHelper.printFoodRation(c);
	}


}
