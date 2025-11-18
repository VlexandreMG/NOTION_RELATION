package OPERATOR;

import MODELE.*;
import WORK.*;

import java.util.ArrayList;
import java.util.List;

public class Selection {
    
    public static Relation f_selection(Relation r, String[] colonne, String operateur, String valeur) {
        
        List<Object[]> resultat = new ArrayList<>();
        String[] nomsColonnes = r.getNoms_colonnes();
        
        // Trouver l'index de la colonne
        int indexColonne = -1;
        for (int i = 0; i < nomsColonnes.length; i++) {
            if (nomsColonnes[i].equals(colonne[i])) {
                indexColonne = i;
                break;
            }
        }
        
        if (indexColonne == -1) {
            throw new IllegalArgumentException("Colonne non trouvée: " + colonne);
        }
        
        // Appliquer la condition sur chaque ligne
        for (Object[] ligne : r.getIndividus()) {
            Object valeurCellule = ligne[indexColonne];
            
            if (ConditionValidator.f_validator(valeurCellule, operateur, valeur)) {
                resultat.add(ligne);
            }
        }
        
        // Créer la nouvelle relation
        Object[][] nouvellesDonnees = resultat.toArray(new Object[0][]);
        return new Relation(
            "Selection_" + r.getNom(),
            nomsColonnes,
            r.getTypes_colonnes(),
            nouvellesDonnees
        );
    }
    
    // private static boolean verifieCondition(Object valeurCellule, String operateur, String valeur) {
    //     try {
    //         switch (operateur) {
    //             case "=":
    //                 return valeurCellule.toString().equals(valeur);
    //             case "!=":
    //                 return !valeurCellule.toString().equals(valeur);
    //             case ">":
    //                 if (valeurCellule instanceof Number && isNumber(valeur)) {
    //                     return ((Number) valeurCellule).doubleValue() > Double.parseDouble(valeur);
    //                 }
    //                 break;
    //             case "<":
    //                 if (valeurCellule instanceof Number && isNumber(valeur)) {
    //                     return ((Number) valeurCellule).doubleValue() < Double.parseDouble(valeur);
    //                 }
    //                 break;
    //         }
    //     } catch (Exception e) {
    //         return false;
    //     }
    //     return false;
    // }
    
    // private static boolean isNumber(String s) {
    //     try {
    //         Double.parseDouble(s);
    //         return true;
    //     } catch (NumberFormatException e) {
    //         return false;
    //     }
    // }
}
