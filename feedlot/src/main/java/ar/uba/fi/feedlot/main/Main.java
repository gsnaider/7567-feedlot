package ar.uba.fi.feedlot.main;

import java.util.ArrayList;

import org.kie.api.io.ResourceType;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import ar.uba.fi.feedlot.main.helpers.CsvToCorral;
import ar.uba.fi.feedlot.main.helpers.PrintHelper;

public class Main {

	public static void main(String[] args) {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("licenseApplication.drl"), ResourceType.DRL);
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		String path;
		if (args.length == 0) {
			path = "feedlot\\src\\main\\java\\ar\\uba\\fi\\feedlot\\main\\corrales.csv";
			
		} else {
			path = args[0];
		}
		ArrayList<Corral> listCorrales = CsvToCorral.getCorralesFromCsv(path);
		for (Corral corral : listCorrales) {
			FactHandle factHandler = ksession.insert(corral);
			ksession.fireAllRules();
			PrintHelper.printFoodRation(corral);
			System.out.println("factor: " + corral.getFactor());
			System.out.println(" ");
		}
	}

}
