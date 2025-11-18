package MODELE;

public class Domaine {
    Class[] types;

    public Domaine(Class[] types) {
        this.types = types;
    }

    public Class[] getType() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }
}
