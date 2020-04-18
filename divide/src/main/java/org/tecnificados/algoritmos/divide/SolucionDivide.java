package org.tecnificados.algoritmos.divide;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Juan Carlos Ballesteros (tecnificados.com)
 */
public class SolucionDivide 
{
	
	private static final Logger log = LoggerFactory.getLogger(SolucionDivide.class);

	/*
	 * Devuelve un array de dos enteros. El primero nos dice la posicion donde se
	 * encuentra la moneda falsa y el segundo nos dice q si es -1 la moneda pesa
	 * menos y si es 1 pesa más.
	 * 
	 * La bolsa debe tener más de 2 monedas
	 */
	public static int[] monedaFalsa(int[] bolsa, int i, int j)
	{
		if ((j - i == 3) || (j - i == 4) || (j - i == 5))// si la bolsa tiene 3, 4 o 5 elementos se resuelve
			return sencillo(bolsa, i, j);
		else// si tiene más de 5...
		{
			// Dividimos en dos bolsas
			int m = (i + j) / 2;
			int[] subBolsaA = new int[bolsa.length];// i->(m-1)
			for (int k = i; k < m; k++)
				subBolsaA[k] = bolsa[k];
			int[] subBolsaB = new int[bolsa.length];// m->(j-1)
			for (int k = m; k < j; k++)
				subBolsaB[k] = bolsa[k];
			/*
			 * Vamos a la balanza a ver si la falsa esta en alguna de las dso bolsas, si es
			 * asi...
			 */
			if (balanza(bolsa, i, j, m) != 0) {
				int[] resul = monedaFalsa(subBolsaA, i, m);
				if (resul != null)
					return resul;
				return monedaFalsa(subBolsaB, m, j);
			}
		}
		return null;
	}

	/*
	 * Devuelve un array de dos enteros. El primero nos dice la posicion donde se
	 * encuentra la moneda falsa y el segundo nos dice q si es -1 la moneda pesa
	 * menos y si es 1 pesa más.
	 */
	public static int[] sencillo(int[] bolsa, int i, int j) {
		int[] resul = new int[2];
		switch (j - i) {
		case 3: {
			int a = bolsa[i];
			int b = bolsa[i + 1];
			int c = bolsa[i + 2];
			if ((a > b) && (a > c)) {
				resul[0] = i;
				resul[1] = 1;
				return resul;
			}
			if ((a < b) && (a < c)) {
				resul[0] = i;
				resul[1] = -1;
				return resul;
			}
			if ((b > a) && (b > c)) {
				resul[0] = i + 1;
				resul[1] = 1;
				return resul;
			}
			if ((b < a) && (b < c)) {
				resul[0] = i + 1;
				resul[1] = -1;
				return resul;
			}
			if ((c > b) && (c > a)) {
				resul[0] = i + 2;
				resul[1] = 1;
				return resul;
			}
			if ((c < b) && (c < a)) {
				resul[0] = i + 2;
				resul[1] = -1;
				return resul;
			}
			break;
		}
		case 4: {
			int a = bolsa[i];
			int b = bolsa[i + 1];
			int c = bolsa[i + 2];
			int d = bolsa[i + 3];
			if ((a > b) && (a > c)) {
				resul[0] = i;
				resul[1] = 1;
				return resul;
			}
			if ((a < b) && (a < c)) {
				resul[0] = i;
				resul[1] = -1;
				return resul;
			}
			if ((b > a) && (b > c)) {
				resul[0] = i + 1;
				resul[1] = 1;
				return resul;
			}
			if ((b < a) && (b < c)) {
				resul[0] = i + 1;
				resul[1] = -1;
				return resul;
			}
			if ((c > b) && (c > a)) {
				resul[0] = i + 2;
				resul[1] = 1;
				return resul;
			}
			if ((c < b) && (c < a)) {
				resul[0] = i + 2;
				resul[1] = -1;
				return resul;
			}
			if ((d > b) && (d > a)) {
				resul[0] = i + 3;
				resul[1] = 1;
				return resul;
			}
			if ((d < b) && (d < a)) {
				resul[0] = i + 3;
				resul[1] = -1;
				return resul;
			}
			break;
		}
		case 5:
			int a = bolsa[i];
			int b = bolsa[i + 1];
			int c = bolsa[i + 2];
			int d = bolsa[i + 3];
			int e = bolsa[i + 4];
			if ((a > b) && (a > c)) {
				resul[0] = i;
				resul[1] = 1;
				return resul;
			}
			if ((a < b) && (a < c)) {
				resul[0] = i;
				resul[1] = -1;
				return resul;
			}
			if ((b > a) && (b > c)) {
				resul[0] = i + 1;
				resul[1] = 1;
				return resul;
			}
			if ((b < a) && (b < c)) {
				resul[0] = i + 1;
				resul[1] = -1;
				return resul;
			}
			if ((c > b) && (c > a)) {
				resul[0] = i + 2;
				resul[1] = 1;
				return resul;
			}
			if ((c < b) && (c < a)) {
				resul[0] = i + 2;
				resul[1] = -1;
				return resul;
			}
			if ((d > b) && (d > a)) {
				resul[0] = i + 3;
				resul[1] = 1;
				return resul;
			}
			if ((d < b) && (d < a)) {
				resul[0] = i + 3;
				resul[1] = -1;
				return resul;
			}
			if ((e > b) && (e > a)) {
				resul[0] = i + 4;
				resul[1] = 1;
				return resul;
			}
			if ((e < b) && (e < a)) {
				resul[0] = i + 4;
				resul[1] = -1;
				return resul;
			}
			break;
		}
		return null;
	}

	public static int balanza(int[] bolsa, int i, int j, int m)
	/*
	 * Toma una bolsa dividida en 2 por la mitad. Devuelve 0 si la moneda falsa esta
	 * en alguna de las bolsas.
	 */
	{
		// si las dos bolsas tienen el mismo numero de monedas
		if ((j - i) % 2 == 0) {
			int sumaA = 0;
			for (int k = i; k < m; k++)
				sumaA += bolsa[k];
			int sumaB = 0;
			for (int k = m; k < j; k++)
				sumaB += bolsa[k];
			return sumaA - sumaB;
		} else {
			/*
			 * La bolsa de la derecha tendra una moneda más asi q la saco y si pesan las dos
			 * bolsas lo mismo y además la moneda q habia sacado pesa lo mismo que cualquier
			 * otra (por ejemplo la primera de la bolsa A)entonces es q la falsa no esta en
			 * ninguna de esas dos bolsas.
			 */
			int sumaA = 0;
			for (int k = i; k < m; k++)
				sumaA += bolsa[k];
			int sumaB = 0;
			for (int k = m + 1; k < j; k++)
				sumaB += bolsa[k];
			if ((sumaA == sumaB) && (bolsa[i] == bolsa[m]))
				return 0;
			else
				return 1;
		}
	}

	public static void main(String[] args)// Ejemplo
	{				 //  1 2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20
		int[] bolsa = { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 6, 4, 4, 4, 4 };
		int[] resul = monedaFalsa(bolsa, 0, bolsa.length);
		log.info("La moneda false es la numero " + (resul[0] + 1));
		if (resul[1] == 1)
			log.info("Es de mayor peso q las demás");
		else
			log.info("Es de menor peso q las demás");
	}
}
