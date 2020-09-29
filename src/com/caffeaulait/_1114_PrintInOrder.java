package com.caffeaulait;

import java.util.concurrent.Semaphore;

public class _1114_PrintInOrder {
    /**
     * Suppose we have a class:
     *
     * public class Foo {
     *   public void first() { print("first"); }
     *   public void second() { print("second"); }
     *   public void third() { print("third"); }
     * }
     * The same instance of Foo will be passed to three different threads. Thread A will call first(),
     * thread B will call second(), and thread C will call third(). Design a mechanism and modify the
     * program to ensure that second() is executed after first(), and third() is executed after second().
     */
    Semaphore sema2, sema3;

    public _1114_PrintInOrder() {
        sema2 = new Semaphore(0);
        sema3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        sema2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        sema2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        sema3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        sema3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
