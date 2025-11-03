package testsFonctionnels;
import cartes.*;
import utils.*;
import jeu.*;
import java.lang.reflect.Array;
import java.util.*;

public class TestZoneDeJeu {
    public static void main(String[] args) {
        ZoneDeJeu zone = new ZoneDeJeu();
        // --- Dépôt de bornes ---
        zone.deposer(new Borne(25));
        zone.deposer(new Borne(50));
        zone.deposer(new Borne(75));
        System.out.println("Total des bornes : " + zone.donnerKmParcourus());

        // --- Dépôt de limites ---
        zone.deposer(new DebutLimite());  // Début de limitation
        System.out.println("Limite : " + zone.donnerLimitationVitesse());

        zone.deposer(new FinLimite());   // Fin de limitation
        System.out.println("Limite : " + zone.donnerLimitationVitesse());
        // --- Dépôt de batailles ---
        System.out.println("\n=== Tests Batailles ===");
        zone.deposer(new Attaque(Type.FEU));     // Feu rouge
        zone.deposer(new Parade(Type.FEU));      // Feu vert
        zone.deposer(new Attaque(Type.ESSENCE)); // Panne d’essence
        zone.deposer(new Parade(Type.ESSENCE));  // Bidon d’essence
        zone.deposer(new Attaque(Type.CREVAISON)); // Crevaison
        zone.deposer(new Parade(Type.CREVAISON));  // Roue de secours
        zone.deposer(new Attaque(Type.ACCIDENT));  // Accident
        zone.deposer(new Parade(Type.ACCIDENT));   // Réparation

        // ------------------------------------------
        // Partie 3 : tests de dépôts autorisés
        // ------------------------------------------
        System.out.println("=== Tests Batailles ===");

        // Cas 1 : pile vide → on ne peut pas avancer
        System.out.println("peutAvancer() = " + zone.peutAvancer()); // false

        // Cas 2 : attaque feu rouge → feu vert autorisé
        zone.deposer(new Attaque(Type.FEU));
        System.out.println("estDepotFeuVertAutorise() = " + zone.estDepotFeuVertAutorise()); // true
        System.out.println("estDepotBatailleAutorise(feu vert) = " +
                zone.estDepotBatailleAutorise(new Parade(Type.FEU))); // true

        // Cas 3 : on pose le feu vert
        zone.deposer(new Parade(Type.FEU));
        System.out.println("peutAvancer() = " + zone.peutAvancer()); // true

        // Cas 4 : on tente une attaque alors qu’on est en feu vert
        System.out.println("estDepotBatailleAutorise(Attaque FEU) = " +
                zone.estDepotBatailleAutorise(new Attaque(Type.FEU))); // false

        // Cas 5 : on pose une attaque ESSENCE (panne d’essence)
        zone.deposer(new Attaque(Type.ESSENCE));
        System.out.println("estDepotBatailleAutorise(Parade ESSENCE) = " +
                zone.estDepotBatailleAutorise(new Parade(Type.ESSENCE))); // true

        // Cas 6 : dépôt de borne selon état
        System.out.println("estDepotBorneAutorise(50km) = " +
                zone.estDepotBorneAutorise(new Borne(50))); // true si feu vert
        System.out.println("estDepotBorneAutorise(75km) = " +
                zone.estDepotBorneAutorise(new Borne(75))); // dépend de la limite

        // Cas 7 : limitation de vitesse
        zone.deposer(new DebutLimite());
        System.out.println("estDepotBorneAutorise(75km) = " +
                zone.estDepotBorneAutorise(new Borne(75))); // false (limite 50)
        zone.deposer(new FinLimite());
        System.out.println("estDepotBorneAutorise(75km) = " +
                zone.estDepotBorneAutorise(new Borne(75))); // true (
    }
}
