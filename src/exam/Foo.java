package exam;
/**
 * What is required to make the Foo class thread safe?
 *
 * A) Make the declaration of lock static.
 * B) Replace the lock constructor call with new ReentrantLock(true).
 * C) Move the declaration of lock inside the foo method.
 * D) No change is required.
 */

import java.util.concurrent.locks.ReentrantLock;

public class Foo {
    private final ReentrantLock lock = new ReentrantLock();
    private State state;

    public void foo() throws Exception {
        try {
            lock.lock();
            state.mutate();
        } finally {
            lock.unlock();
        }
    }
}

class State {
    static void mutate() {
    }
}
