package testsFonctionnels;
import cartes.*;
import utils.*;
import jeu.*;
import java.lang.reflect.Array;
import java.util.*;

public class TestGestionCartes {
    public static void main(String[] args) {
        JeuDeCartes jeu = new JeuDeCartes();
        List<Carte> listeCarteNonMelangee = new LinkedList<>();
        for (Carte carte : jeu.donnerCartes()) {
            listeCarteNonMelangee.add(carte);
        }
        List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);

        System.out.println(listeCartes);
        System.out.println("Avant melange \n");

        listeCartes = GestionCartes.melanger(listeCartes);

        System.out.println(listeCartes);
        System.out.println("liste mélangée sans erreur ? "
                + GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));

        listeCartes = GestionCartes.rassembler(listeCartes);
        System.out.println(listeCartes);
        System.out.println("liste rassemblée sans erreur ? "
                + GestionCartes.verifierRassemblement(listeCartes));
    }
}
