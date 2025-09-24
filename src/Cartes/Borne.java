package Cartes;

public class Borne {
    int km;
    public Borne(int km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return "Carte Borne :" + km;
    }
}
