package Cartes;

public class Attaque extends Bataille {
    public Attaque(Type type) {
        super(type);
    }

    @Override
    public String toString() {
        return type.getAttaque();
    }
}
