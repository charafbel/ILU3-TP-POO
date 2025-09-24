package Cartes;

public abstract class Bataille extends Probleme {
    public Bataille(Type type) {
        super(type);
    }

    @Override
    public String toString() {
        return "Carte Bataille de type " + type;
    }
}
