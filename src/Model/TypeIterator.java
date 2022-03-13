package Model;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class TypeIterator {
    private Hashtable<String, List<Integer>> dictionary;
    private Hashtable<String, Integer> offsets = new Hashtable<>();
    private Hashtable<String, Integer> lengths = new Hashtable<>();

    public TypeIterator(Hashtable<String, List<Integer>> dict){
        dictionary = dict;
        Set<String> set = dictionary.keySet();
        for (String key : set) {
            offsets.put(key, 0);
            lengths.put(key, dictionary.get(key).size());
        }
    }
    public boolean hasNext(String key) {
        if (offsets.get(key) < lengths.get(key))
            return true;
        return false;
    }

    public Integer next(String key) {
        if (!hasNext(key))
            return null;
        offsets.put(key, offsets.get(key) + 1);
        return dictionary.get(key).get(offsets.get(key) - 1);
    }
}
