package jeu;
import cartes.*;
import jeu.*;
import utils.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Jeu {
    Sabot sabot;

    public Jeu(){
        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        List<Carte> listeCartes = new ArrayList<Carte>();
        Collections.addAll(listeCartes, jeuDeCartes.donnerCartes());
        listeCartes = GestionCartes.melanger(listeCartes);
        this.sabot = new Sabot(listeCartes.toArray(new Carte[0]));
    }


}
