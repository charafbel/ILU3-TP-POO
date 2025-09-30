package cartes;

public enum Type {
    FEU("Feu Rouge", "Prioritaire", "Feu vert"),
    ESSENCE("Panne d'essence", "Citerne", "Bidon d'essence"),
    CREVAISON("Crevaison", "Increvable", "Roue de Secours"),
    ACCIDENT("Accident", "As du Volant", "Reparation");

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


