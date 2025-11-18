package WORK;

import MODELE.*;

public class ColumnValidator {
    
    public static boolean f_validator(Object[] Nom_colonnes1 , Object[] noms_colonnes2) {
        if (Nom_colonnes1.length != noms_colonnes2.length) {
            System.out.println("\n Le nombre de colonnes ne correspond pas.");
            return false;
        } else {
            System.out.println("\n Le nombre de colonnes correspond.");
            return true;
        }
    }
}
