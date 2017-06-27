package ar.uba.fi.feedlot.main;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import ar.uba.fi.feedlot.main.helpers.PrintHelper;

public class FeedlotTest {

	private KnowledgeBuilder kbuilder;
	private KnowledgeBase kbase;
	private StatefulKnowledgeSession ksession;
	private Alimento food;
	
	@Before
	public void setUp() {
		kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("licenseApplication.drl"), ResourceType.DRL);
		kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		ksession = kbase.newStatefulKnowledgeSession();
		food = new Alimento();
	}
	
	@Test
	public void testDia1Caluroso() {
		final int cabezas = 30;
		final int dia = 1;
		final double pesoInicial = 220;
		final int temperatura = 29;
		
		Corral corral = new Corral(cabezas, dia, pesoInicial, food, temperatura);
		ksession.insert(corral);
		ksession.fireAllRules();
		
		final String materiaSecaKg = "62.70";
		final String materiaSecaPct = "62.00";
		final String siloSorgoKg = "30.10";
		final String siloSorgoPct = "48.00";
		final String maizKg = "23.83";
		final String maizPct = "38.00";
		final String expellerSojaKg = "7.77";
		final String expellerSojaPct = "12.40";
		final String premezclaMineralKg = "1.00";
		final String premezclaMineralPct = "1.60";
		final String humedad = "38.43";
		
		assertValues(corral, materiaSecaKg, materiaSecaPct, siloSorgoKg, siloSorgoPct, maizKg, maizPct, expellerSojaKg,
				expellerSojaPct, premezclaMineralKg, premezclaMineralPct, humedad);
	}
	
	@Test
	public void testDia10Caluroso() {
		final int cabezas = 30;
		final int dia = 10;
		final double pesoInicial = 220;
		final int temperatura = 30;
		
		Corral corral = new Corral(cabezas, dia, pesoInicial, food, temperatura);
		ksession.insert(corral);
		ksession.fireAllRules();
		
		final String materiaSecaKg = "62.70";
		final String materiaSecaPct = "62.00";
		final String siloSorgoKg = "30.10";
		final String siloSorgoPct = "48.00";
		final String maizKg = "23.83";
		final String maizPct = "38.00";
		final String expellerSojaKg = "7.77";
		final String expellerSojaPct = "12.40";
		final String premezclaMineralKg = "1.00";
		final String premezclaMineralPct = "1.60";
		final String humedad = "38.43";
		
		assertValues(corral, materiaSecaKg, materiaSecaPct, siloSorgoKg, siloSorgoPct, maizKg, maizPct, expellerSojaKg,
				expellerSojaPct, premezclaMineralKg, premezclaMineralPct, humedad);
	}
	
	@Test
	public void testDia20Frio() {
		final int cabezas = 30;
		final int dia = 20;
		final double pesoInicial = 220;
		final int temperatura = 10;
		
		Corral corral = new Corral(cabezas, dia, pesoInicial, food, temperatura);
		ksession.insert(corral);
		ksession.fireAllRules();
		
		final String materiaSecaKg = "62.70";
		final String materiaSecaPct = "62.00";
		final String siloSorgoKg = "30.10";
		final String siloSorgoPct = "48.00";
		final String maizKg = "23.83";
		final String maizPct = "38.00";
		final String expellerSojaKg = "7.77";
		final String expellerSojaPct = "12.40";
		final String premezclaMineralKg = "1.00";
		final String premezclaMineralPct = "1.60";
		final String humedad = "38.43";
		
		assertValues(corral, materiaSecaKg, materiaSecaPct, siloSorgoKg, siloSorgoPct, maizKg, maizPct, expellerSojaKg,
				expellerSojaPct, premezclaMineralKg, premezclaMineralPct, humedad);
	}
	
	@Test
	public void testDia30() {
		final int cabezas = 30;
		final int dia = 30;
		final double pesoInicial = 220;
		final int temperatura = 25;
		
		Corral corral = new Corral(cabezas, dia, pesoInicial, food, temperatura);
		ksession.insert(corral);
		ksession.fireAllRules();
		
		final String materiaSecaKg = "62.70";
		final String materiaSecaPct = "62.00";
		final String siloSorgoKg = "30.10";
		final String siloSorgoPct = "48.00";
		final String maizKg = "23.83";
		final String maizPct = "38.00";
		final String expellerSojaKg = "7.77";
		final String expellerSojaPct = "12.40";
		final String premezclaMineralKg = "1.00";
		final String premezclaMineralPct = "1.60";
		final String humedad = "38.43";
		
		assertValues(corral, materiaSecaKg, materiaSecaPct, siloSorgoKg, siloSorgoPct, maizKg, maizPct, expellerSojaKg,
				expellerSojaPct, premezclaMineralKg, premezclaMineralPct, humedad);
	}
	
	@Test
	public void testDia50Frio() {
		final int cabezas = 30;
		final int dia = 50;
		final double pesoInicial = 220;
		final int temperatura = 10;
		
		Corral corral = new Corral(cabezas, dia, pesoInicial, food, temperatura);
		ksession.insert(corral);
		ksession.fireAllRules();
		
		final String materiaSecaKg = "62.70";
		final String materiaSecaPct = "62.00";
		final String siloSorgoKg = "30.10";
		final String siloSorgoPct = "48.00";
		final String maizKg = "23.83";
		final String maizPct = "38.00";
		final String expellerSojaKg = "7.77";
		final String expellerSojaPct = "12.40";
		final String premezclaMineralKg = "1.00";
		final String premezclaMineralPct = "1.60";
		final String humedad = "38.43";
		
		assertValues(corral, materiaSecaKg, materiaSecaPct, siloSorgoKg, siloSorgoPct, maizKg, maizPct, expellerSojaKg,
				expellerSojaPct, premezclaMineralKg, premezclaMineralPct, humedad);
	}

	private void assertValues(Corral corral, final String materiaSecaKg, final String materiaSecaPct,
			final String siloSorgoKg, final String siloSorgoPct, final String maizKg, final String maizPct,
			final String expellerSojaKg, final String expellerSojaPct, final String premezclaMineralKg,
			final String premezclaMineralPct, final String humedad) {
		assertEquals(materiaSecaKg, PrintHelper.round(corral.getKilosMateriaSecaDeHoy()));
		assertEquals(materiaSecaPct, PrintHelper.round(corral.getAlimento().getMateriaSeca() * 100));
		assertEquals(siloSorgoKg, PrintHelper.round(corral.getKilosSiloSorgoHoy()));
		assertEquals(siloSorgoPct, PrintHelper.round(corral.getAlimento().getSiloSorgo() * 100));
		assertEquals(maizKg, PrintHelper.round(corral.getKilosMaizHoy()));
		assertEquals(maizPct, PrintHelper.round(corral.getAlimento().getMaiz() * 100));
		assertEquals(expellerSojaKg, PrintHelper.round(corral.getKilosExpellerSojaHoy()));
		assertEquals(expellerSojaPct, PrintHelper.round(corral.getAlimento().getExpellerSoja() * 100));
		assertEquals(premezclaMineralKg, PrintHelper.round(corral.getKilosPreMezclaMineralHoy()));
		assertEquals(premezclaMineralPct, PrintHelper.round(corral.getAlimento().getPreMezclaMineral() * 100));
		assertEquals(humedad, PrintHelper.round(corral.getHumedadDeHoy()));
	}
	
}
