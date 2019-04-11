package jay.LRU;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jaywangs on 2019/4/10
 */
public class LRU<K,V> extends LinkedHashMap<K,V> {
    private static int MAX_SIZE;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Lock lock = new ReentrantLock();

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_SIZE;
    }

    public LRU(){
        super(MAX_SIZE, DEFAULT_LOAD_FACTOR, true);
    }

    @Override
    public boolean containsValue(Object value) {
        try {
            lock.lock();
            return super.containsValue(value);
        }finally {
            lock.unlock();
        }
    }

    @Override
    public V get(Object key) {
        try {
            lock.lock();
            return super.get(key);
        }finally {
            lock.unlock();
        }
    }

    @Override
    public V put(K key, V value) {
        try {
            lock.lock();
            return super.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        try {
            lock.lock();
            return super.size();
        } finally {
            lock.unlock();
        }
    }

    public void clear() {
        try {
            lock.lock();
            super.clear();
        } finally {
            lock.unlock();
        }
    }

    public Collection<Map.Entry<K, V>> getAll() {
        try {
            lock.lock();
            return new  ArrayList<Map.Entry<K,V>>(super.entrySet());
        }finally {
            lock.unlock();
        }
    }
}
