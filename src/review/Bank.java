package review;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Bank {
    private Lock vault = new ReentrantLock();
    private int total = 0;

    public static void main(String[] unused) {
        var bank = new Bank();
        IntStream.range(1, 10)
                .parallel()
                .forEach(s -> bank.deposit(s));
        System.out.println(bank.total);
    }

    public void deposit(int value) {
        try {
            vault.tryLock();
            total += value;
        } finally {
            vault.unlock();
        }
    }
}