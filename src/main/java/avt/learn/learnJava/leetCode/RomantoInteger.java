package src.main.java.learnjava.leetCode;
import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
    // Roman numerals are represented by seven different symbols: I, V, X, L, C, D
    // and M.

    // Symbol Value
    // I 1
    // V 5
    // X 10
    // L 50
    // C 100
    // D 500
    // M 1000
    // For example, 2 is written as II in Roman numeral, just two ones added
    // together. 12 is written as XII, which is simply X + II. The number 27 is
    // written as XXVII, which is XX + V + II.

    // Roman numerals are usually written largest to smallest from left to right.
    // However, the numeral for four is not IIII. Instead, the number four is
    // written as IV. Because the one is before the five we subtract it making four.
    // The same principle applies to the number nine, which is written as IX. There
    // are six instances where subtraction is used:

    // I can be placed before V (5) and X (10) to make 4 and 9.
    // X can be placed before L (50) and C (100) to make 40 and 90.
    // C can be placed before D (500) and M (1000) to make 400 and 900.
    // Given a roman numeral, convert it to an integer.

    public static void main(String[] args) {
       //  System.out.println(new RomantoInteger().romanToInt("III"));
        // System.out.println(new RomantoInteger().romanToInt("LVIII"));
        //System.out.println(new RomantoInteger().romanToInt("MCMXCIV"));
         System.out.println(new RomantoInteger().romanToInt("IX"));
    }

    public static final  Map<String, Integer> map = new HashMap<>(){};
    {
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
    }
    public int romanToInt(String s) {
        String[] sArray = s.split("");

        int i = 0;
        int value = 0;
        while (i < sArray.length) {
            if (i < sArray.length-1) {
                String key = sArray[i] + sArray[i + 1];
                if (map.containsKey(key)) {
                    value += map.get(key);
                    i += 2;
                }
                else{
                    value += map.get(sArray[i]);
                    i += 1;
                }
            } else {
                value += map.get(sArray[i]);
                i += 1;
            }
        }

        return value;

    }

}
