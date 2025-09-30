package Cartes;

import java.util.ArrayList;
import java.util.List;

public class JeuDeCartes{
    Configuration[] typeDeCartes = new Configuration[19];

    public String affichageJeuDeCartes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < typeDeCartes.length; i++) {
            sb.append(typeDeCartes[i].getNbExemplaires() + "  ");
            sb.append(typeDeCartes[i].getCarte() + "\n");
        }
        return sb.toString();
    }

    public Carte[] donnerCartes(){
        List<Carte> cartes = new ArrayList<>();
        for (Configuration c : typeDeCartes) {
            int nbC = c.getNbExemplaires();
            for (int i = 0; i <= nbC; i++) {
                cartes.add(c.getCarte());
            }
        }
        return cartes.toArray(new Carte[0]);
    }

    private static class Configuration {
        private int nbExemplaires;
        private Carte carte;

        private Configuration(Carte carte, int nbExemplaires){
            this.nbExemplaires = nbExemplaires;
            this.carte = carte;
        }
        public Carte getCarte(){
            return carte;
        }
        public int getNbExemplaires(){
            return nbExemplaires;
        }
    }
}
