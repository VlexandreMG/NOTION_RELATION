package VALIDATOR;

import java.util.Arrays;
import MODELE.*;

public class ClassValidator {
   
    public static boolean f_validator(Relation r) {

        Object[][] donnees = r.getIndividus();
        Domaine[] types_colonnes = r.getTypes_colonnes();

        for (int i = 0; i < donnees.length; i++) {
            for (int j = 0; j < donnees[i].length; j++) {
                Class type_donnee = donnees[i][j].getClass();
                
                boolean type_valide = false;
    
                for (Class type_accepte : types_colonnes[j].getType()) {  // ⚠️ j pas i!
                    if (type_donnee.equals(type_accepte)) {
                        type_valide = true;
                        break;
                    }
                }
                
                if (!type_valide) {
                    System.out.println("\n Erreur - Ligne " + i + ", Colonne " + j + 
                        " : Type " + type_donnee.getName() + 
                        " n'est pas dans " + Arrays.toString(types_colonnes[j].getType()));
                    return false;
                }
                // ❌ SUPPRIMER le else qui retournait true trop tôt
            }
        }
        
        // ✅ UNIQUEMENT ici, après avoir vérifié TOUTES les cellules
        System.out.println("\n ✅ Tous les types sont valides!");
        return true;
    }
}