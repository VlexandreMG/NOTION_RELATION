package UTILS;

public class Linefusion {

    public static Object[] fusionnerLignes(Object[] ligneR1, Object[] ligneR2, int indexColonneR2) {
        // ligneR1 + ligneR2 sans la colonne de jointure dupliquée
        Object[] fusion = new Object[ligneR1.length + ligneR2.length - 1];
        
        // Copier toute la première ligne
        System.arraycopy(ligneR1, 0, fusion, 0, ligneR1.length);
        
        // Copier la deuxième ligne sauf la colonne de jointure
        int destPos = ligneR1.length;
        for (int i = 0; i < ligneR2.length; i++) {
            if (i != indexColonneR2) {
                fusion[destPos++] = ligneR2[i];
            }
        }
        
        return fusion;
    }
}