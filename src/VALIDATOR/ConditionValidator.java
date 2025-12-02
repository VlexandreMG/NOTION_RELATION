package VALIDATOR;

import UTILS.*;

public class ConditionValidator {
    
    public static boolean f_validator(Object valeurCellule, String operateur, String valeur) {
         try {
            switch (operateur.toLowerCase().trim()) {
                // Égalité
                case "=":
                case "égale à":
                case "egale a":
                case "égale a":
                case "egale à":
                case "mitovy @":
                case "equal":
                case "equals":
                case "eq":
                    return valeurCellule.toString().equals(valeur);
                
                // Inégalité
                case "!=":
                case "différent de":
                case "different de":
                case "tsia mitovy":
                case "not equal":
                case "neq":
                case "<>":
                    return !valeurCellule.toString().equals(valeur);
                
                // Supérieur
                case ">":
                case "supérieur à":
                case "superieur a":
                case "supérieur a":
                case "superieur à":
                case "lehibe noho":
                case "greater than":
                case "gt":
                    if (valeurCellule instanceof Number && isNumber.f_number(valeur)) {
                        return ((Number) valeurCellule).doubleValue() > Double.parseDouble(valeur);
                    }
                    break;
                
                // Inférieur
                case "<":
                case "inférieur à":
                case "inferieur a":
                case "inférieur a":
                case "inferieur à":
                case "kely noho":
                case "less than":
                case "lt":
                    if (valeurCellule instanceof Number && isNumber.f_number(valeur)) {
                        return ((Number) valeurCellule).doubleValue() < Double.parseDouble(valeur);
                    }
                    break;
                
                // Supérieur ou égal
                case ">=":
                case "supérieur ou égal à":
                case "superieur ou egal a":
                case "supérieur ou égal a":
                case "lehibe na mitovy":
                case "greater than or equal":
                case "gte":
                    if (valeurCellule instanceof Number && isNumber.f_number(valeur)) {
                        return ((Number) valeurCellule).doubleValue() >= Double.parseDouble(valeur);
                    }
                    break;
                
                // Inférieur ou égal
                case "<=":
                case "inférieur ou égal à":
                case "inferieur ou egal a":
                case "inférieur ou égal a":
                case "kely na mitovy":
                case "less than or equal":
                case "lte":
                    if (valeurCellule instanceof Number && isNumber.f_number(valeur)) {
                        return ((Number) valeurCellule).doubleValue() <= Double.parseDouble(valeur);
                    }
                    break;
                
                // Contient (pour les textes)
                case "contient":
                case "contains":
                case "misy":
                case "include":
                    return valeurCellule.toString().toLowerCase().contains(valeur.toLowerCase());
                
                // Commence par
                case "commence par":
                case "start with":
                case "manomboka":
                    return valeurCellule.toString().toLowerCase().startsWith(valeur.toLowerCase());
                
                // Termine par
                case "termine par":
                case "end with":
                case "miafara":
                    return valeurCellule.toString().toLowerCase().endsWith(valeur.toLowerCase());
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}