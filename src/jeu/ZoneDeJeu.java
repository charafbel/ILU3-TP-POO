package jeu;
import cartes.*;
import utils.*;
import java.util.*;

public class ZoneDeJeu {
    List<Limite> pLimites = new ArrayList<>();
    List<Bataille> pBatailles = new ArrayList<>();
    List<Borne> pBornes = new ArrayList<>();

    public ZoneDeJeu() {

    }

    public int donnerLimitationVitesse(){
        if (pLimites.isEmpty() || (pLimites.get(0)).getClass() == FinLimite.class) {
            return 200;
        }
        return 50;
    }

    public int donnerKmParcourus(){
        int nbKmParcourus = 0;
        for (Iterator i = pBornes.iterator(); i.hasNext(); ) {
            nbKmParcourus = ((Borne)i.next()).getKm();
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
            System.out.println("Depot Attaque :  " + ((Bataille) c).getType() + " km");
        }
        if (c instanceof Limite){
            pLimites.add((Limite)c);
            System.out.println("Depot " + ((Limite) c) + " kmh");
        }
    }
    public boolean peutAvancer(void) {
        if (pBatailles.isEmpty()){
            return false;
        }
        Bataille sommet = pBatailles.get(pBatailles.size() - 1);
        return (sommet instanceof Parade && sommet.getType() == Type.FEU);
    }
    public boolean estDepotFeuVertAutorise(){
        if (pBatailles.isEmpty()){
            return false;
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




}
