package MAIN;

import JOINTURE.*;
import MODELE.*;
import VIEW.*;

public class Main {
    
    public static void main(String[] args) {
        String[] noms_colonnes1 = {"ID", "Name", "Age"};
        String[] noms_colonnes2 = {"ID", "Name", "Age"};

        // ColumnValidator.f_validator(noms_colonnes1, noms_colonnes2);

        Domaine[] d1 = new Domaine[3];
        d1[0] = new Domaine(new Class[]{Integer.class, String.class});
        d1[1] = new Domaine(new Class[]{String.class, Integer.class});
        d1[2] = new Domaine(new Class[]{Integer.class,String.class});

        Object[][] donnees1 = new Object[3][3];
        donnees1[0][0] = 1;
        donnees1[0][1] = "Alex";
        donnees1[0][2] = 30;

        donnees1[1][0] = "Balou";
        donnees1[1][1] = 50;
        donnees1[1][2] = 80;

        donnees1[2][0] = "louBa";
        donnees1[2][1] = 45;
        donnees1[2][2] = 10;

        Object[][] donnees2 = new Object[3][3];
        donnees2[0][0] = 1;
        donnees2[0][1] = "Alex";
        donnees2[0][2] = 30;

        donnees2[1][0] = "Balou";
        donnees2[1][1] = 50;
        donnees2[1][2] = 80;

        donnees2[2][0] = 600;
        donnees2[2][1] = 50;
        donnees2[2][2] = "koukiri";

        Relation[] r = new Relation[2];
        r[0] = new Relation("r1", noms_colonnes1, d1,donnees1);
        r[1] = new Relation("r2", noms_colonnes2, d1,donnees2);
        
                //Relation unionResult = Union.f_unions(r);
                //Relation produitCartesienResult = ProduitCartesien.f_produitcartesien(r);
                //Relation intersectionResult = Intersection.f_intersections(r);
                //Relation projectionResult = Projection.f_projection(r[0], noms_colonnes1);
                //Relation selectionResult = Selection.f_selection(r[0], "ID", "!=", "louBa");
                // Relation differenceResult = Difference.f_differences(r);
                //Relation test_fotsn = InnerJoin.join(r,"ID");
                //Relation test_fotsn = LeftJoin.join(r,"ID");
        
                Relation test_fotsn = RightJoin.join(r,"ID");
        RelationShow.displayRelation(test_fotsn);                
    }
}