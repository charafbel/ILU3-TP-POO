package Cartes;

public enum Type {
    FEU("Feu Rouge", "Prioritaire", "Feu vert"),
    ESSENCE("Attaque", "Botte", "Parade"),
    CREVAISON("Attaque", "Botte", "Parade"),
    ACCIDENT("Attaque", "Botte", "Parade");

    private String attaque;
    private String parade;
    private String botte;

    Type(String attaque, String botte, String parade){
        this.attaque = attaque;
        this.parade = parade;
        this.botte = botte;
    }

    public String getAttaque() {
        return attaque;
    }

    public String getParade() {
        return parade;
    }

    public String getBotte() {
        return botte;
    }
}


