package UTILS;

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
}
