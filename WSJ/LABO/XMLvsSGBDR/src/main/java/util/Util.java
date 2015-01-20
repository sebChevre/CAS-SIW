package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by sce on 10.09.14.
 */
public class Util {
	public static BigDecimal generateMontantAleatoire(){

		float monta = (float)Math.random()*100;
		return new BigDecimal(monta).setScale(2, RoundingMode.CEILING);

	}

	public static int getNbreAlesWithMax(int max){
		return (int)(Math.random()*max)+1;
	}
}
