import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap{
    private int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!super.containsKey(key))
            return -1;
        return (Integer) super.get(key);
    }
    
    public void set(int key, int value) {
        super.put(key, value);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        // TODO Auto-generated method stub
        return size() > capacity;
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(2, 3);
        cache.set(1, 2);
        cache.set(3, 2);
        cache.set(1, 3);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
    }
}
