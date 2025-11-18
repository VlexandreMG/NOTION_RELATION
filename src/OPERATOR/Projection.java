package OPERATOR;

import java.util.ArrayList;
import java.util.List;

import MODELE.Relation;
import WORK.ColumnIndex;
import WORK.CoupleDeletor;

public class Projection {
    
    public static Relation f_projection(Relation relation, String[] nom_colonne) {
        
        String[] relation_colonnes = relation.getNoms_colonnes();
        List<Object[]> new_relation = new ArrayList<>();

        // int[] indice_colonne = new int[nom_colonne.length];
        // for (int i = 0; i < nom_colonne.length; i++) {
        //     boolean found = false;
        //     for (int j = 0; j < relation_colonnes.length; j++) {
        //         if (relation_colonnes[j].equals(nom_colonne[i])) {
        //             found = true;
        //             indice_colonne[i] = j;
        //             break;
        //         }
        //     }
        //     if (!found) {
        //        System.out.println("Aucune colonne n'est trouvé.");
        //        return null; 
        //     }
        // }

        int[] indice_colonne = ColumnIndex.f_index(nom_colonne, relation_colonnes);

        Object[][] individus = relation.getIndividus();
        for (Object[] objects : individus) {
            Object[] nouvelleLigne = new Object[nom_colonne.length];
            for (int i = 0; i < indice_colonne.length; i++) {
                nouvelleLigne[i] = objects[indice_colonne[i]];
            }
            new_relation.add(nouvelleLigne);
        }
        
        Object[][] projection = new_relation.toArray(new Object[0][]);
        Object[][] new_projection = CoupleDeletor.f_deletor(projection);
        
        return new Relation(
            "\n Projection :"+ relation.getNom(),
            nom_colonne,
            relation.getTypes_colonnes(),
            new_projection
        );
    }
}
