

package ee.ut.cs.akt.aktk.library;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import ee.ut.cs.akt.aktk.ast.SimpleType;
import ee.ut.cs.akt.aktk.ast.Type;

public class Builtins {

    private static Scanner systemInScanner = null;

    public static double PI = Math.PI;

    public static int MAX_INT = Integer.MAX_VALUE;
    
    public static List<String> getInnerMethods(){
    	return Arrays.asList(new String[]{"trüki"});
    }
    
    public static Map getInnerVariables(){
    	Map map = new HashMap<String, Type>();
    	map.put("PI", new SimpleType("ujukomaarv"));
    	return map;
    }

    public static int trüki(int x) {
        System.out.println(x);
        return 0; // lihtsalt selleks, et kõik funktsioonid tagastaksid täisarvu
    }

    public static int trüki(String x) {
        System.out.println(x);
        return 0; // lihtsalt selleks, et kõik funktsioonid tagastaksid täisarvu
    }


    public static int trüki(float x) {
        System.out.println(x);
        return 0; // lihtsalt selleks, et kõik funktsioonid tagastaksid täisarvu
    }


    /**
     * Kuvab ekraanile näidatud täisarvu.
     * Ebavajalik tagastusväärtus antakse praegu vaid selleks,
     * et kõigi funktsioonide käivitamisel jääks magasini mingi väärtus.
     */
    public static int printInt(int x) {
        System.out.print(x);
        return 0;
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

    public static String readLine() {
        if (systemInScanner == null) {
            systemInScanner = new Scanner(System.in);
        }
        return systemInScanner.nextLine();
    }

    public static void printStr(String s) {
        System.out.print(s);
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

    public static String upper(String s) {
        return s.toUpperCase();
    }

    public static String lower(String s) {
        return s.toLowerCase();
    }

    public static String replicate(String s, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static String intToStr(int x) {
        return String.valueOf(x);
    }

    public static int strToInt(String s) {
        return Integer.parseInt(s);
    }

    public static String doubleToStr(double x) {
        return String.valueOf(x);
    }

    public static double strToDouble(String s) {
        return Double.parseDouble(s);
    }
}
