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
    }
}
