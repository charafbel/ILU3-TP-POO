package cartes;

import java.util.ArrayList;
import java.util.List;

public class JeuDeCartes{
    Configuration[] typeDeCartes = new Configuration[19];

    public JeuDeCartes(){
        typeDeCartes[0] = new Configuration(new Borne(25), 10);
        typeDeCartes[1] = new Configuration(new Borne(50), 10);
        typeDeCartes[2] = new Configuration(new Borne(75), 10);
        typeDeCartes[3] = new Configuration(new Borne(100), 12);
        typeDeCartes[4] = new Configuration(new Borne(200), 4);
        typeDeCartes[6] = new Configuration(new FinLimite(), 6);
        typeDeCartes[11] = new Configuration(new DebutLimite(), 4);
        typeDeCartes[5] = new Configuration(new Parade(Type.FEU), 14);
        typeDeCartes[7] = new Configuration(new Parade(Type.ESSENCE), 6);
        typeDeCartes[8] = new Configuration(new Parade(Type.CREVAISON), 6);
        typeDeCartes[9] = new Configuration(new Parade(Type.ACCIDENT), 6);
        typeDeCartes[10] = new Configuration(new Attaque(Type.FEU), 5);
        typeDeCartes[12] = new Configuration(new Attaque(Type.ESSENCE), 3);
        typeDeCartes[13] = new Configuration(new Attaque(Type.CREVAISON), 3);
        typeDeCartes[14] = new Configuration(new Attaque(Type.ACCIDENT), 3);
        typeDeCartes[15] = new Configuration(new Botte(Type.FEU), 1);
        typeDeCartes[16] = new Configuration(new Botte(Type.ESSENCE), 1);
        typeDeCartes[17] = new Configuration(new Botte(Type.ACCIDENT), 1);
        typeDeCartes[18] = new Configuration(new Botte(Type.CREVAISON), 1);
    }
    public boolean checkCount(){
        int somme = 0;
        for(Configuration c : typeDeCartes){
            somme += c.nbExemplaires;
        }
        return somme == 106;
    }
    public String affichageJeuDeCartes() {
        StringBuilder sb = new StringBuilder();
        for (Configuration c : typeDeCartes) {
            sb.append(c.getNbExemplaires() + "  ");
            sb.append(c.getCarte() + "\n");
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
