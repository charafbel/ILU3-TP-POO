package cartes;

public abstract class Carte {
    public Carte() {
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().equals(this.getClass());
    }
}
