package JOINTURE;

import MODELE.*;
import UTILS.*;
import java.util.*;

public class FullJoin {

    public static Relation join(Relation[] rlt,String nomColonne) {

        Relation r1 = rlt[0];
        Relation r2 = rlt[1];

        int indexColonneR1 = ColumnIndex.trouverIndexColonne(r1, nomColonne);
        int indexColonneR2 = ColumnIndex.trouverIndexColonne(r2, nomColonne);

        List<Object[]> list = new ArrayList<>();

        for (Object[] ob1 : r1.getIndividus()) {
            for (Object[] ob2 : r2.getIndividus()) {
                if (Objects.equals(ob1[indexColonneR1], ob2[indexColonneR2])) {
                    list.add(Linefusion.fusionnerLignes(ob1, ob2, indexColonneR2));
                }
            }
        }
    
        for (Object[] ob1 : r1.getIndividus()) {
            boolean misy = false;
            for (int i = 0; i < list.size(); i++) {
                if (Objects.equals(ob1[indexColonneR1], list.get(i)[indexColonneR1])) {
                    misy = true;
                    break;
                }
            }
            if (!misy) {
                list.add(ob1);
            }
        }

        for (Object[] ob2 : r2.getIndividus()) {
            boolean misy = false;
            for (int i = 0; i < list.size(); i++) {
                if (Objects.equals(ob2[indexColonneR2], list.get(i)[indexColonneR2])) {
                    misy = true;
                    break;
                }
            }
            if (!misy) {
                list.add(ob2);
            }
        }

        Object[][] finalTab = list.toArray(new Object[0][]);
        return new Relation(
            r1.getNom() + "-FullJoin-" + r2.getNom(),
            r1.getNoms_colonnes(),
            r1.getTypes_colonnes(),
            finalTab
        );      
    }   
}