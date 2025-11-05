package jeu;
import cartes.*;
import utils.*;
import java.util.*;

public class ZoneDeJeu {
    List<Limite> pLimites = new ArrayList<>();
    List<Bataille> pBatailles = new ArrayList<>();
    Collection<Borne> pBornes = new ArrayList<>();
    HashSet<Botte> bottes = new HashSet<>();

    public ZoneDeJeu(){}

    public int donnerLimitationVitesse(){
        if (pLimites.isEmpty() || pLimites.get(pLimites.size()-1) instanceof FinLimite){
            return 200;
        }
        return 50;
    }

    public int donnerKmParcourus(){
        int nbKmParcourus = 0;
        for (Iterator i = pBornes.iterator(); i.hasNext(); ) {
            nbKmParcourus += ((Borne)i.next()).getKm();
        };
        return nbKmParcourus;
    }

    public void deposer(Carte c){
        if (c instanceof Borne){
            pBornes.add((Borne) c);
            System.out.println("Depot Borne : " + ((Borne) c).getKm() + " km");
        }
        if (c instanceof Bataille){
            pBatailles.add((Bataille)c);
            System.out.println("Depot Attaque :  " + ((Bataille) c).getType());
        }
        if (c instanceof Limite){
            pLimites.add((Limite)c);
            System.out.println("Depot " + ((Limite) c) + " kmh");
        }
    }

    public boolean peutAvancer(){
        if (pBatailles.isEmpty()){
            return false;
        }
        Bataille sommet = pBatailles.get(pBatailles.size() - 1);
        return (sommet instanceof Parade && sommet.getType() == Type.FEU);
    }

    public boolean estDepotFeuVertAutorise(){
        if (pBatailles.isEmpty()){
            return true;
        }
        Bataille sommet = pBatailles.get(pBatailles.size() - 1);
        if (sommet instanceof Attaque && sommet.getType() == Type.FEU) {
            return true;
        }
        if (sommet instanceof Parade && sommet.getType() != Type.FEU) {
            return true;
        }
        return false;
    }

    public boolean estDepotBorneAutorise(Borne borne){
        if (!peutAvancer()){
            return false;
        }
        if (borne.getKm() > donnerLimitationVitesse()) {
            return false;
        }
        if (donnerKmParcourus() + borne.getKm() > 1000){
            return false;
        }
        return true;
    }

    public boolean estDepotLimiteAutorise(Limite limite){
        // Si la pile est vide, seul un début de limite est autorisé
        if (pLimites.isEmpty()) {
            return (limite instanceof DebutLimite); // true si c'est un début
        }

        // Récupérer le sommet de la pile (la dernière limite posée)
        Limite sommet = pLimites.get(pLimites.size() - 1);

        // Cas a : le paramètre est un début de limite
        if (limite instanceof DebutLimite){
            // On peut poser un début si la pile est vide ou si le sommet est une fin
            return (sommet instanceof FinLimite);
        }

        // Cas b : le paramètre est une fin de limite
        if (limite instanceof FinLimite){
            // On peut poser une fin si le sommet est un début de limite
            return (sommet instanceof DebutLimite);
        }
        return false;
    }

    public boolean estDepotBatailleAutorise(Bataille bataille){
        // Cas 1 : c’est une attaque
        if (bataille instanceof Attaque) {
            return peutAvancer();
        }
        // Cas 2 : c’est une parade
        if (bataille instanceof Parade) {
            Bataille sommet = pBatailles.isEmpty() ? null : pBatailles.get(pBatailles.size() - 1);
            if (bataille.getType() == Type.FEU) {
                if (sommet == null) return true; 
                if (sommet instanceof Attaque && sommet.getType() == Type.FEU) return true; 
                if (sommet instanceof Parade && sommet.getType() != Type.FEU) return true; 
                return false;
            } else {

                if (sommet == null) return false;
                return (sommet instanceof Attaque && sommet.getType().equals(bataille.getType()));
            }
        }

        return false;
    }

    public boolean estDepotAutorise(Carte carte){
        if (carte instanceof Borne) {
            return estDepotBorneAutorise((Borne) carte);
        }
        if (carte instanceof Limite) {
            return estDepotLimiteAutorise((Limite) carte);
        }
        if (carte instanceof Bataille) {
            return estDepotBatailleAutorise((Bataille) carte);
        }
        return false;
    }
}
