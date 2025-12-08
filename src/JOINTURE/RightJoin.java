package JOINTURE;

import MODELE.*;
import UTILS.*;
import java.lang.*;
import java.util.*;

public class RightJoin {

    public static Relation join(Relation[] relations, String nomColonne) {
         if (relations.length != 2) {
            throw new IllegalArgumentException("La jointure nécessite exactement 2 relations");
        }
        
        Relation r1 = relations[0];
        Relation r2 = relations[1];
        
        // Trouver les indices de la colonne dans chaque relation
        int indexColonneR1 = ColumnIndex.trouverIndexColonne(r1, nomColonne);
        int indexColonneR2 = ColumnIndex.trouverIndexColonne(r2, nomColonne);

        if (indexColonneR1 == -1 || indexColonneR2 == -1) {
            throw new IllegalArgumentException("Colonne '" + nomColonne + "' non trouvée dans une des relations");
        }
        
        List<Object[]> resultat = new ArrayList<>();

        // Jointure naturelle sur la colonne spécifiée
        for (Object[] ligneR1 : r1.getIndividus()) {
            for (Object[] ligneR2 : r2.getIndividus()) {
                if (Objects.equals(ligneR1[indexColonneR1], ligneR2[indexColonneR2])) {
                    // Fusionner les deux lignes (sans dupliquer la colonne de jointure)
                    resultat.add(Linefusion.fusionnerLignes(ligneR1, ligneR2, indexColonneR2));
                }
            }
        }

        for (Object[] ligneR2 : r2.getIndividus()) {
            boolean existeDeja = false;
    
            // Vérifier si cette ligne existe déjà dans le résultat
            for (int i = 0; i < resultat.size(); i++) {
                if (Objects.equals(ligneR2[indexColonneR2], resultat.get(i)[indexColonneR2])) {
                    existeDeja = true;
                    break;  // Trouvé, on arrête de chercher
                }
            }
    
            // Si la ligne n'existe PAS dans le résultat, l'ajouter
            if (!existeDeja) {
                resultat.add(ligneR2);
            }
        }

        // Créer les nouveaux noms de colonnes
        String[] nouveauxNomsColonnes = ColumnIndex.creerNomsColonnes(r1, r2, nomColonne);

        Object[][] individusJoin = resultat.toArray(new Object[0][]);
        return new Relation(
            "Join_" + r1.getNom() + "_" + r2.getNom() + "_sur_" + nomColonne,
            nouveauxNomsColonnes,
            r1.getTypes_colonnes(),
            individusJoin
        );
    }
}