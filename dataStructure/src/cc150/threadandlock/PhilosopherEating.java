package cc150.threadandlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PhilosopherEating {
    private static class Chopstick {
        private Lock lock;

        public Chopstick() {
            this.lock = new ReentrantLock();
        }

        public void peekUp() {
            lock.lock();
        }

        public void putDown() {
            lock.unlock();
        }
    }

    private static class Philosopher extends Thread {
        private static final int BITES = 10;
        private final Chopstick left;
        private final Chopstick right;

        public Philosopher(Chopstick left, Chopstick right) {
            this.left = left;
            this.right = right;
        }

        public void eat() {
            left.peekUp();
            right.peekUp();
            chew();
            left.putDown();
            right.putDown();
        }

        private void chew() {

        }

        @Override
        public void run() {
            for (int i = 0; i < BITES; i++) {
                eat();
            }
        }
    }

    public static void main(String[] args) {
        Chopstick chopstick1 = new Chopstick();
        Chopstick chopstick2 = new Chopstick();
        Chopstick chopstick3 = new Chopstick();
        Chopstick chopstick4 = new Chopstick();
        Chopstick chopstick5 = new Chopstick();
        Chopstick chopstick6 = new Chopstick();
        Philosopher philosopher1 = new Philosopher(chopstick1, chopstick2);
        Philosopher philosopher2 = new Philosopher(chopstick2, chopstick3);
        Philosopher philosopher3 = new Philosopher(chopstick3, chopstick4);
        Philosopher philosopher4 = new Philosopher(chopstick4, chopstick5);
        Philosopher philosopher5 = new Philosopher(chopstick5, chopstick6);
        Philosopher philosopher6 = new Philosopher(chopstick6, chopstick1);

        philosopher1.eat();
        philosopher2.eat();
        philosopher3.eat();
        philosopher4.eat();
        philosopher5.eat();
        philosopher6.eat();

    }
}
