package WORK;

public class ConditionValidator {
    
    public static boolean f_validator(Object valeurCellule, String operateur, String valeur) {
         try {
            switch (operateur) {
                case "=":
                    return valeurCellule.toString().equals(valeur);
                case "!=":
                    return !valeurCellule.toString().equals(valeur);
                case ">":
                    if (valeurCellule instanceof Number && isNumber.f_number(valeur)) {
                        return ((Number) valeurCellule).doubleValue() > Double.parseDouble(valeur);
                    }
                    break;
                case "<":
                    if (valeurCellule instanceof Number && isNumber.f_number(valeur)) {
                        return ((Number) valeurCellule).doubleValue() < Double.parseDouble(valeur);
                    }
                    break;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
