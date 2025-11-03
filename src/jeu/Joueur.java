package jeu;
import cartes.*;
import utils.*;
import java.util.*;

public class Joueur {
    String nom;
    ZoneDeJeu zJeu;
    MainJoueur deck;


    public Joueur(String nom, ZoneDeJeu zoneDeJeu) {
        this.nom = nom;
        this.zJeu = zoneDeJeu;
        deck = new MainJoueur();
    }

    public void donner(Carte carte) {
        deck.prendre(carte);
    }

    public Carte prendreCarte(Sabot sabot){
        if (sabot.estVide()){
            return null;
        }
        Carte carte = sabot.piocher();
        deck.prendre(carte);
        return carte;
    }

    public void deposer(Carte c){
        zJeu.deposer(c);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Joueur) && this.nom.equals(((Joueur)obj).nom);
    }

    @Override
    public String toString() {
        return this.nom;
    }

}
