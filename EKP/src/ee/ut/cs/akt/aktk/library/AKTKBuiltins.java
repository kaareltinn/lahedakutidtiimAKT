package ee.ut.cs.akt.aktk.library;

import java.util.Scanner;

public class AKTKBuiltins {
	private static Scanner systemInScanner = null;
	
	/**
	 * Praegu kasutame booleanide asemel täisarve.
	 */
	public static int not(int x) {
		return ~x;
	}
	
	public static int and(int a, int b) {
		return a & b;
	}
	
	public static int or(int a, int b) {
		return a | b;
	}
	
	
	/**
	 * Kuvab ekraanile näidatud täisarvu.
	 * Ebavajalik tagastusväärtus antakse praegu vaid selleks, 
	 * et kõigi funktsioonide käivitamisel jääks magasini mingi väärtus.
	 */
	public static int printInt(int x) {
		System.out.println(x);
		return x; // lihtsalt selleks, et kõik funktsioonid tagastaksid täisarvu
	}
	
	/**
	 * loeb standardsisendist rea ja teisendab selle täisarvuks 
	 */
	public static int readInt() {
		if (systemInScanner == null) {
			systemInScanner = new Scanner(System.in);
		}
		return Integer.parseInt(systemInScanner.nextLine());			
	}
	
	
	/**
	 * Astendamine
	 */
	public static int power(int x, int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Ainult mittenegatiivne astendaja on lubatud");
		}
		
		int result = 1;
		while (n > 0) {
			result *= x;
			n--;
		}
		return result;
	}
	
	/**
	 * Suurim ühistegur
	 */
	public static int gcd(int a, int b) {
		while(b > 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return a;
	}
	
}
