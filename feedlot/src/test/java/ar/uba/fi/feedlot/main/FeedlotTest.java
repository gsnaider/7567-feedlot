package ar.uba.fi.feedlot.main;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.io.ResourceType;
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

	@Before
	public void setUp() {
		kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("licenseApplication.drl"), ResourceType.DRL);
		kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		ksession = kbase.newStatefulKnowledgeSession();
	}

	@Test
	public void testDia1Caluroso() {
		final int cabezas = 30;
		final int dia = 1;
		final double pesoInicial = 220;
		final int temperatura = 29;

		Corral corral = new Corral(cabezas, dia, pesoInicial, temperatura);
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

		Corral corral = new Corral(cabezas, dia, pesoInicial, temperatura);
		ksession.insert(corral);
		ksession.fireAllRules();

		final String materiaSecaKg = "125.40";
		final String materiaSecaPct = "62.00";
		final String siloSorgoKg = "60.19";
		final String siloSorgoPct = "48.00";
		final String maizKg = "47.65";
		final String maizPct = "38.00";
		final String expellerSojaKg = "15.55";
		final String expellerSojaPct = "12.40";
		final String premezclaMineralKg = "2.01";
		final String premezclaMineralPct = "1.60";
		final String humedad = "76.86";

		assertValues(corral, materiaSecaKg, materiaSecaPct, siloSorgoKg, siloSorgoPct, maizKg, maizPct, expellerSojaKg,
				expellerSojaPct, premezclaMineralKg, premezclaMineralPct, humedad);
	}

	@Test
	public void testDia20Frio() {
		final int cabezas = 30;
		final int dia = 20;
		final double pesoInicial = 220;
		final int temperatura = 10;

		Corral corral = new Corral(cabezas, dia, pesoInicial, temperatura);
		ksession.insert(corral);
		ksession.fireAllRules();

		final String materiaSecaKg = "207.90";
		final String materiaSecaPct = "67.00";
		final String siloSorgoKg = "76.92";
		final String siloSorgoPct = "37.00";
		final String maizKg = "101.87";
		final String maizPct = "49.00";
		final String expellerSojaKg = "25.47";
		final String expellerSojaPct = "12.25";
		final String premezclaMineralKg = "3.64";
		final String premezclaMineralPct = "1.75";
		final String humedad = "102.40";

		assertValues(corral, materiaSecaKg, materiaSecaPct, siloSorgoKg, siloSorgoPct, maizKg, maizPct, expellerSojaKg,
				expellerSojaPct, premezclaMineralKg, premezclaMineralPct, humedad);
	}

	@Test
	public void testDia20() {
		final int cabezas = 30;
		final int dia = 20;
		final double pesoInicial = 220;
		final int temperatura = 25;

		Corral corral = new Corral(cabezas, dia, pesoInicial, temperatura);
		ksession.insert(corral);
		ksession.fireAllRules();

		final String materiaSecaKg = "198.00";
		final String materiaSecaPct = "67.00";
		final String siloSorgoKg = "73.26";
		final String siloSorgoPct = "37.00";
		final String maizKg = "97.02";
		final String maizPct = "49.00";
		final String expellerSojaKg = "24.25";
		final String expellerSojaPct = "12.25";
		final String premezclaMineralKg = "3.47";
		final String premezclaMineralPct = "1.75";
		final String humedad = "97.52";

		assertValues(corral, materiaSecaKg, materiaSecaPct, siloSorgoKg, siloSorgoPct, maizKg, maizPct, expellerSojaKg,
				expellerSojaPct, premezclaMineralKg, premezclaMineralPct, humedad);
	}

	@Test
	public void testDia20Caluroso() {
		final int cabezas = 30;
		final int dia = 20;
		final double pesoInicial = 220;
		final int temperatura = 30;

		Corral corral = new Corral(cabezas, dia, pesoInicial, temperatura);
		ksession.insert(corral);
		ksession.fireAllRules();

		final String materiaSecaKg = "188.10";
		final String materiaSecaPct = "67.00";
		final String siloSorgoKg = "69.60";
		final String siloSorgoPct = "37.00";
		final String maizKg = "92.17";
		final String maizPct = "49.00";
		final String expellerSojaKg = "23.04";
		final String expellerSojaPct = "12.25";
		final String premezclaMineralKg = "3.29";
		final String premezclaMineralPct = "1.75";
		final String humedad = "92.65";

		assertValues(corral, materiaSecaKg, materiaSecaPct, siloSorgoKg, siloSorgoPct, maizKg, maizPct, expellerSojaKg,
				expellerSojaPct, premezclaMineralKg, premezclaMineralPct, humedad);
	}

	@Test
	public void testDia50Frio() {
		final int cabezas = 30;
		final int dia = 50;
		final double pesoInicial = 220;
		final int temperatura = 10;

		Corral corral = new Corral(cabezas, dia, pesoInicial, temperatura);
		ksession.insert(corral);
		ksession.fireAllRules();

		final String materiaSecaKg = "228.38";
		final String materiaSecaPct = "73.00";
		final String siloSorgoKg = "60.52";
		final String siloSorgoPct = "26.50";
		final String maizKg = "136.57";
		final String maizPct = "59.80";
		final String expellerSojaKg = "27.40";
		final String expellerSojaPct = "12.00";
		final String premezclaMineralKg = "3.88";
		final String premezclaMineralPct = "1.70";
		final String humedad = "84.47";

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
