package Cartes;

public abstract class Probleme extends Carte {
    Type type;

    public Probleme(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Carte Problème de type " + type;
    }
}
