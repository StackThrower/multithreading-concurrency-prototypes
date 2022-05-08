package com.multitreading;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingObjectPool<T> {

    private final Lock takeLock = new ReentrantLock();
    private final BlockingQueue<T> pool;
    /**
     * Creates filled pool of passed size
     *
     * @param size of pool
     */
    public BlockingObjectPool(int size) {
        this.pool = new LinkedBlockingQueue<T>(size);
    }

    /**
     * Gets object from pool or blocks if pool is empty
     *
     * @return object from pool
     */
    public Object get() {
        Object obj;
        takeLock.lock();
        try {
            obj = pool.take();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            takeLock.unlock();
        }
        return obj;
    }

    /**
     * Puts object to pool or blocks if pool is full
     *
     * @param object to be taken back to pool
     */
    public void take(Object object) {
        // TODO Needed implementation;
    }
}