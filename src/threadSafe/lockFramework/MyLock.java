package threadSafe.lockFramework;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock {
    public static void main(String[] args) {

        // #1) - with a synchronized block
        Object object = new Object();
        synchronized (object) {
            // Protected code
        }

        // 2) - with a Lock
        //lock()
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
        } finally {
            lock.unlock();
        }
    }
}
