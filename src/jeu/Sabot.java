package jeu;
import cartes.*;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sabot implements Iterable<Carte>{
    private int nbCartes;
    private Carte[] cartes;
    private int modifs = 0;

    public Sabot(Carte[] cartes){
        nbCartes = cartes.length;
        this.cartes = new Carte[nbCartes];
        System.arraycopy(cartes, 0, this.cartes, 0, nbCartes);
    }
    public boolean estVide(){
        return nbCartes == 0;
    }
    public void ajouterCarte(Carte carte) {
        if (nbCartes >= cartes.length){
            throw new IllegalStateException("Dépassement de capacité");
        }
        cartes[nbCartes] = carte;
        nbCartes++;
    }
    public Carte piocher() {
        Iterator<Carte> it = this.iterator();
        if (!it.hasNext()) {
            throw new IllegalStateException("Sabot vide");
        }
        Carte premiereCarte = it.next();
        it.remove();
        return premiereCarte;
    }

    @Override
    public Iterator<Carte> iterator() {
        return new SabotIterator();
    }
    
    private class SabotIterator implements Iterator<Carte> {
        private int curseur = 0;
        private int derElt = -1;
        private int modifAtt = modifs;

        @Override
        public boolean hasNext() {
            return curseur < nbCartes;
        }
        @Override
        public Carte next() {
            if (modifs != modifAtt)
                throw new ConcurrentModificationException();
            if (curseur >= nbCartes)
                throw new NoSuchElementException();
            derElt = curseur;
            return cartes[curseur++];
        }
        @Override
        public void remove() {
            if (derElt < 0)
                throw new IllegalStateException();
            if (modifs != modifAtt)
                throw new ConcurrentModificationException();
            for (int i = derElt; i < nbCartes - 1; i++) {
                cartes[i] = cartes[i+1];
            }
            cartes[nbCartes-1] = null;
            nbCartes--;
            modifs++;
            modifAtt++;
            curseur = derElt;
            derElt = -1;
        }
    }
}
