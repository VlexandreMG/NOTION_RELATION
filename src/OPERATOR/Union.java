package OPERATOR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import MODELE.*;
import WORK.*;

public class Union {
    
    public static Relation f_unions(Relation[] relations) {
        if (relations == null || relations.length == 0) return null;

        Relation base = relations[0];
        List<Object[]> nouveau = new ArrayList<>();

        for (Relation relation : relations) {
            if (!ClassValidator.f_validator(relation)) {
                System.out.println("\n Validation échouée pour: " + relation.getNom());
                return null;
            } else if (!ColumnValidator.f_validator(relations)) {
                System.out.println("\n Les nombres de colonnes ne correspondent pas : " + relation.getNom());
                return null;
            }
        }

        for (Relation relation : relations) {
            for (Object[] individu : relation.getIndividus()) {
                boolean existeDeja = false;
                for (Object[] existant : nouveau) {
                    if (Arrays.equals(existant, individu)) {
                        existeDeja = true;
                        break;
                    }
                }
                if (!existeDeja) {
                    nouveau.add(individu);
                }
            }
        }

        Object[][] individusUnion = nouveau.toArray(new Object[0][]);
        return new Relation(
            "Union_" + base.getNom(),
            base.getNoms_colonnes(),
            base.getTypes_colonnes(),
            individusUnion
        );
    }
}
