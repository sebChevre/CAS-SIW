package util;

import org.junit.Test;

/**
 * Created by sce on 10.09.14.
 */
public class UtilTest {

	@Test
	public void testAlea1And5(){

		for(int cpt = 0; cpt<100;cpt++){
			System.out.println(Util.getNbreAlesWithMax(1));
		}
	}
}
