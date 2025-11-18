package VALIDATOR;

import MODELE.*;

public class ColumnValidator {
    
    public static boolean f_validator(Relation[] relations) {
        if (relations == null || relations.length == 0) {
            System.out.println("\n Aucune relation fournie.");
            return false;
        }

        Relation premiereRelation = relations[0];
        int nombreColonnesAttendu = premiereRelation.getNoms_colonnes().length;
        
        for (int i = 1; i < relations.length; i++) {
            Relation relationCourante = relations[i];
            int nombreColonnesCourant = relationCourante.getNoms_colonnes().length;
            
            if (nombreColonnesCourant != nombreColonnesAttendu) {
                System.out.println("\n Le nombre de colonnes ne correspond pas pour " + 
                    relationCourante.getNom() + " (attendu: " + nombreColonnesAttendu + 
                    ", trouvé: " + nombreColonnesCourant + ")");
                return false;
            }
        }

        System.out.println("\n Le nombre de colonnes correspond pour toutes les relations.");
        return true;
    }
}