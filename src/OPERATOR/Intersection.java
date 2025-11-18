package OPERATOR;

import MODELE.*;
import VALIDATOR.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {
    
    public static Relation f_intersections(Relation[] relations) {
        
        if (relations.length < 2) {
            System.out.println("L'intersection nécessite au moins 2 relations");
            return null;
        }

        // Validation globale
        if (!ColumnValidator.f_validator(relations)) {
            System.out.println("Les colonnes ne correspondent pas");
            return null;
        }
        
        for (Relation relation : relations) {
            if (!ClassValidator.f_validator(relation)) {
                System.out.println("Validation échouée pour: " + relation.getNom());
                return null;
            }
        }

        // Prendre la première relation comme base
        List<Object[]> resultat = new ArrayList<>();
        Relation base = relations[0];
        
        // Pour chaque ligne de la première relation
        for (Object[] ligneBase : base.getIndividus()) {
            boolean dansToutesLesRelations = true;
            
            // Vérifier si cette ligne existe dans TOUTES les autres relations
            for (int i = 1; i < relations.length; i++) {
                boolean trouveDansRelation = false;
                
                for (Object[] ligneAutre : relations[i].getIndividus()) {
                    if (Arrays.equals(ligneBase, ligneAutre)) {
                        trouveDansRelation = true;
                        break;
                    }
                }
                
                if (!trouveDansRelation) {
                    dansToutesLesRelations = false;
                    break;
                }
            }
            
            if (dansToutesLesRelations) {
                resultat.add(ligneBase);
            }
        }

        Object[][] individusIntersection = resultat.toArray(new Object[0][]);
        return new Relation(
            "Intersection_" + base.getNom(),
            base.getNoms_colonnes(),
            base.getTypes_colonnes(),
            individusIntersection
        );
    }
}