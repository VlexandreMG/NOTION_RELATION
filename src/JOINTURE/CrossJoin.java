package JOINTURE;

import MODELE.*;
import java.util.ArrayList;
import java.util.List;

public class CrossJoin {

    public static Relation cross(Relation[] relations) {

        Relation r1;
        Relation r2;
        List<Object[]> new_relation = new ArrayList<>();

        for (int i = 0; i < relations.length - 1; i++) {
            r1 = relations[i];
            r2 = relations[i + 1];
            for (Object[] individus : r1.getIndividus()) {
                for (Object[] individus2 : r2.getIndividus()) {
                    Object[] combined = new Object[individus.length + individus2.length];
                    System.arraycopy(individus, 0, combined, 0, individus.length);
                    System.arraycopy(individus2, 0, combined, individus.length, individus2.length);
                    new_relation.add(combined);
                }
            }

        }

        Object[][] individusProduitCartesien = new_relation.toArray(new Object[0][]);
        return new Relation(
            "ProduitCartesien_" + relations[0].getNom(),
            relations[0].getNoms_colonnes(),
            relations[0].getTypes_colonnes(),
            individusProduitCartesien
        );
    }
    
}
