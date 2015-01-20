package data;

import filler.ProduitsFiller;
import org.junit.Test;
import util.Util;

/**
 * Created by sce on 09.09.14.
 */
public class ProduitsFillerTest {

	@Test
	public void testGenerateRandom(){

		for(int cpt=0; cpt<100; cpt++){

			System.out.println(Util.generateMontantAleatoire().toString());
		}
	}
}
