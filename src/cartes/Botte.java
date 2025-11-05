package cartes;

public class Botte extends Probleme {
    public Botte(Type type) {
        super(type);
    }

    @Override
    public String toString() {
        return type.getBotte();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Botte) {
            return this.type.equals(((Botte) o).getType());
        }
        return false;
    }
}
