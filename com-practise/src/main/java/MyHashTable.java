import java.util.Map;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-03-13 下午 10:59
 */
public class MyHashTable<K,V> implements Map.Entry<K,V> {

    final int hash;
    final K key;
    V value;
    MyHashTable<K,V> next;

    protected MyHashTable(int hash, K key, V value, MyHashTable<K,V> next) {
        this.hash = hash;
        this.key =  key;
        this.value = value;
        this.next = next;
    }


    @Override
    public K getKey() {
        return null;
    }

    @Override
    public V getValue() {
        return null;
    }

    @Override
    public V setValue(V value) {
        return null;
    }
}
