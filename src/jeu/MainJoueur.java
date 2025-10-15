package jeu;
import cartes.*;
import utils.*;
import java.util.*;

public class MainJoueur {
    List <Carte> deck;
    public MainJoueur() {
        this.deck = new ArrayList<>();
    }

    public void prendre (Carte carte) {
        deck.add(carte);
        System.out.println("Carte prise -> " + carte);
    }

    public void jouer(Carte carte) {
        assert (deck.contains(carte));
        deck.remove(carte);
        System.out.println("Carte jouée -> " + carte);
    }

    @Override
    public String toString() {
        for (Carte carte : deck) {
            System.out.println(carte);
        }
        return "-------------- \n";
    }
}
