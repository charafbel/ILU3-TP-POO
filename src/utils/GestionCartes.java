package utils;
import java.lang.reflect.Array;
import java.util.*;

public class GestionCartes {

    /*
    v1.
    public static <T> T extraire(List<T> liste){
        Random rng = new Random();
        int removeindex = rng.nextInt(liste.size());
        T elem = liste.get(removeindex);
        liste.remove(removeindex);
        return elem;
    }
    */

    public static <T> T extraire(List<T> liste){
        Random rng = new Random();
        Iterable<T> iterable = new ArrayList<>();
        int rindex = rng.nextInt(liste.size());
        T elem = liste.get(rindex);
        liste.remove(elem);
        return elem;
    }

    public static <T> List<T> melanger(List<T> liste){
        List<T> suffledList = new ArrayList<>(liste);
        Collections.shuffle(suffledList);
        liste.clear();
        return suffledList;
    }

    public static <T> boolean verifierMelange(List<T> l1, List<T> l2){
        if (l1.size() != l2.size()){
            return false;
        }
        for (T elem : l1){
            int freq = Collections.frequency(l2, elem);
            int freq2 = Collections.frequency(l1, elem);
            if (freq != freq2){
                return false;
            }
        }
        return true;
    }

    public static <T> List<T> rassembler(List<T> liste){
        List<T> segmentedList = new ArrayList<>();
        List<T> addedList = new ArrayList<>();

        for (T elem : liste) {
            if (!addedList.contains(elem)) {
                for (T elem2 : liste) {
                    if (elem.equals(elem2)) {
                        segmentedList.add(elem);
                    }
                }
                addedList.add(elem);
            }
        }
        return segmentedList;
    }
}
