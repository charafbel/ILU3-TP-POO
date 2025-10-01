package testsFonctionnels;
import cartes.*;

public class TestMethodeEquals {
    public static void main(String[] args) {
        // Bornes :
        Borne km25 = new Borne(25);
        Borne km502 = new Borne(50);
        Borne km50 = new Borne(50);
        // Attaques :
        Attaque afeu = new Attaque(Type.FEU);            // Attaque : Feu rouge
        Attaque afeu2 = new Attaque(Type.FEU);           // Attaque : Feu rouge
        Attaque acrev = new Attaque(Type.CREVAISON);     // Attaque : Crevaison
        // Parades :
        Parade pfeu = new Parade(Type.FEU);              // Parade : Feu vert
        Parade pfeu2 = new Parade(Type.FEU);             // Parade : Feu vert
        Parade pcrev = new Parade(Type.CREVAISON);       // Parade : Roue de secours

        // Affichages :
        System.out.println("Deux cartes 25km et 50km sont identiques ? " + km50.equals(km25));           // false
        System.out.println("Deux cartes de 50km sont identiques ? " + km50.equals(km502));          // true
        System.out.println("Deux cartes de feux rouge sont identiques ? " + afeu.equals(afeu2));    // true
        System.out.println("Une carte attaque feu rouge et une carte attaque crevaison sont identiques ? " + afeu.equals(acrev)); // false
        System.out.println("La carte feu rouge et la carte feu vert sont identiques ? " + afeu.equals(pfeu)); // false
        System.out.println("Deux cartes de parade feu vert sont identiques ? " + pfeu.equals(pfeu2)); // true
        System.out.println("La parade crevaison et la parade roue de secours sont identiques ? " + pfeu.equals(pcrev)); // false
    }
}
