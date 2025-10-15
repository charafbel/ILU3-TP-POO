package jeu;
import cartes.*;
import utils.*;
import java.util.*;

public class ZoneDeJeu {
    List<Limite> pLimites;
    List<Bataille> pBatailles;
    List<Borne> pBornes;

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
}
