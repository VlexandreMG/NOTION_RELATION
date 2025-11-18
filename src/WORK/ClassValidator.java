package WORK;

import java.util.Arrays;

import MODELE.Domaine;

public class ClassValidator {
   
    public static boolean f_validator(Object[][] donnees , Domaine[] types_colonnes) {

        if (ColumnValidator.f_validator(donnees, types_colonnes)) {
            for (int i = 0; i < donnees.length; i++) {
                for (int j = 0; j < donnees[i].length; j++) {
                    Class type_donnee = donnees[i][j].getClass();
                    
                    boolean type_valide = false;
        
                    for (Class type_accepte : types_colonnes[i].getType()) {
                        if (type_donnee.equals(type_accepte)) {
                            type_valide = true;
                            break;
                        }
                    }
                    
                        if (!type_valide) {
    System.out.println("\n Type de donnée : " + type_donnee.getName() + 
                      " ne correspond pas avec les types acceptés pour la colonne " + i + " : " + 
                      Arrays.toString(types_colonnes[i].getType()));
    return false;
} else {
    System.out.println("\n Type de donnée : " + type_donnee.getName() + 
                      " correspond avec les types de la colonne " + i + " : " + 
                      Arrays.toString(types_colonnes[i].getType()));
}
                }
            
        }
        return true; // Tous les types sont valides

        } else {
            System.out.println("\n Validation des colonnes échouée.");
            return false;
        }
    }
}