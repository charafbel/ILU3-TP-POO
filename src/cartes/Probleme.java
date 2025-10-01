package cartes;

public abstract class Probleme extends Carte {
    Type type;

    public Probleme(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && this.getType().equals(((Probleme)obj).getType());
    }
}
