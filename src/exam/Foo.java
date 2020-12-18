package exam;

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
