package WORK;

import MODELE.Relation;

public class RelationShow {
    
    public static void displayRelation(Relation relation) {
        System.out.println("\n Relation Name: " + relation.getNom());
        
        // Display column names
        String[] columnNames = relation.getNoms_colonnes();
        for (String colName : columnNames) {
            System.out.print(colName + "\t");
        }
        System.out.println();
        
        // Display data rows
        Object[][] individus = relation.getIndividus();
        for (Object[] row : individus) {
            for (Object value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
