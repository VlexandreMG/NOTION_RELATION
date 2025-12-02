package UTILS;

import MODELE.*;
import java.util.*;

public class ColumnIndex {
    
    public static int[] f_index(String[] column_need , String[] column_origin) {
        
        int[] indice_colonne = new int[column_need.length];
        for (int i = 0; i < column_need.length; i++) {
            boolean found = false;
            for (int j = 0; j < column_origin.length; j++) {
                if (column_origin[j].equals(column_need[i])) {
                    found = true;
                    indice_colonne[i] = j;
                    break;
                }
            }
            if (!found) {
               System.out.println("Aucune colonne n'est trouvé.");
               return null; 
            }
        }
        return indice_colonne;
    }

    public static int trouverIndexColonne(Relation relation, String nomColonne) {
        String[] nomsColonnes = relation.getNoms_colonnes();
        for (int i = 0; i < nomsColonnes.length; i++) {
            if (nomsColonnes[i].equals(nomColonne)) {
                return i;
            }
        }
        return -1;
    }

    public static String[] creerNomsColonnes(Relation r1, Relation r2, String nomColonneJoin) {
        List<String> noms = new ArrayList<>();
        
        // Ajouter toutes les colonnes de r1
        Collections.addAll(noms, r1.getNoms_colonnes());
        
        // Ajouter les colonnes de r2 sauf celle de jointure
        for (String nom : r2.getNoms_colonnes()) {
            if (!nom.equals(nomColonneJoin)) {
                noms.add(nom);
            }
        }
        
        return noms.toArray(new String[0]);
    }
}
