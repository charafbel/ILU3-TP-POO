package utils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GestionCartes {

    public static <T> T extrairea(List<T> liste){
        Random rng = new Random();
        int removeindex = rng.nextInt(liste.size());
        T elem = liste.get(removeindex);
        liste.remove(removeindex);
        return elem;
    }

    public static <T> T extraire(List<T> liste){
        Random rng = new Random();
        Iterable<T> iterable = new ArrayList<>();
        int rindex = rng.nextInt(liste.length);
        T elem = liste[rindex];

    }
}
