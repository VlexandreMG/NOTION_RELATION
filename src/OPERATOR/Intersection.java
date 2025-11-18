package OPERATOR;

import MODELE.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Intersection {
    
    public static Relation f_intersections(Relation[] relations) {
        
        Relation r1;
        Relation r2;
        List<Object[]> new_relation = new ArrayList<>();

        for (int i = 0; i < relations.length - 1; i++) {
            r1 = relations[i];
            r2 = relations[i + 1];
            for (Object[] individus : r1.getIndividus()) {
                for (Object[] individus2 : r2.getIndividus()) {
                    if (Arrays.equals(individus,individus2)) {
                      new_relation.add(individus);  
                    }
                }
            }
        }

        Object[][] individusIntersection = new_relation.toArray(new Object[0][]);
        return new Relation(
            "Intersection_" + relations[0].getNom(),
            relations[0].getNoms_colonnes(),
            relations[0].getTypes_colonnes(),
            individusIntersection
        );


    }
}
