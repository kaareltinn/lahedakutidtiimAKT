

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
        return 0; // lihtsalt selleks, et kõik funktsioonid tagastaksid midagi
    }

    public static int trüki(String x) {
        System.out.println(x);
        return 0; // lihtsalt selleks, et kõik funktsioonid tagastaksid midagi
    }


    public static int trüki(double x) {
        System.out.println(x);
        return 0; // lihtsalt selleks, et kõik funktsioonid tagastaksid midagi
    }

    public static void voidTest(){
        System.out.println("proov");
    }

    /**
     * Astendamine
     */
    public static int astenda(int x, int n) {
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
    public static int leiaSÜ(int a, int b) {
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

    public static String suuredtähed(String s) {
        return s.toUpperCase();
    }

    public static String väikesedtähed(String s) {
        return s.toLowerCase();
    }

    public static String paljunda(String s, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static String TAsõneks(int x) {
        return String.valueOf(x);
    }

    public static int sõneTAks(String s) {
        return Integer.parseInt(s);
    }

    public static String UKASõneks(double x) {
        return String.valueOf(x);
    }

    public static double sõneUKAks(String s) {
        return Double.parseDouble(s);
    }
}
