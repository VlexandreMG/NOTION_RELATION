package MODELE;

public class Relation {
    String nom;
    String[] noms_colonnes;
    Domaine[] types_colonnes;
    Object[][] individus;

    public Relation(String nom, String[] noms_colonnes, Domaine[] types_colonnes, Object[][] individus) {
        this.nom = nom;
        this.noms_colonnes = noms_colonnes;
        this.types_colonnes = types_colonnes;
        this.individus = individus;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String[] getNoms_colonnes() {
        return noms_colonnes;
    }

    public void setNoms_colonnes(String[] noms_colonnes) {
        this.noms_colonnes = noms_colonnes;
    }

    public Domaine[] getTypes_colonnes() {
        return types_colonnes;
    }

    public void setTypes_colonnes(Domaine[] types_colonnes) {
        this.types_colonnes = types_colonnes;
    }

    public Object[][] getIndividus() {
        return individus;
    }

    public void setIndividus(Object[][] individus) {
        this.individus = individus;
    }

}