package ar.uba.fi.drools;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class ApplicantTest {

	@Test
	public void testInvalidApplicant() {
		KieServices kieServices = KieServices.Factory.get();
		KieContainer kContainer = kieServices.getKieClasspathContainer();
		StatelessKieSession kSession = kContainer.newStatelessKieSession();
		
		Applicant applicant = new Applicant("JJ", 19);
		assertTrue(applicant.isValid());
		kSession.execute(applicant);
		assertTrue(applicant.isValid());
		assertTrue(applicant.isValidName());
	}

}
