package Cartes;

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
        return
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
