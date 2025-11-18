package OPERATOR;

import MODELE.*;
import VALIDATOR.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Difference {
    
    public static Relation f_differences(Relation[] relations) {
        
        Relation r1;
        Relation r2;
        List<Object[]> new_relation = new ArrayList<>();

        for (Relation relation : relations) {
            if (!ClassValidator.f_validator(relation)) {
                System.out.println("\n Validation échouée pour: " + relation.getNom());
                return null;
            } else if (!ColumnValidator.f_validator(relations)) {
                System.out.println("\n Les nombres de colonnes ne correspondent pas : " + relation.getNom());
                return null;
            }
        }

        for (int i = 0; i < relations.length - 1; i++) {
            r1 = relations[i];
            r2 = relations[i + 1];
            for (Object[] individus : r1.getIndividus()) {
                boolean exists = false;
                for (Object[] individus2 : r2.getIndividus()) {
                    if (Arrays.equals(individus, individus2)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    new_relation.add(individus);
                }
            }
        }

        Object[][] individusDifference = new_relation.toArray(new Object[0][]);
        return new Relation(
            "Difference_" + relations[0].getNom(),
            relations[0].getNoms_colonnes(),
            relations[0].getTypes_colonnes(),
            individusDifference
        );
    }
}
