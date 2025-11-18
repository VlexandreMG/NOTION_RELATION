package UTILS;

public class isNumber {
    
    public static boolean f_number(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
