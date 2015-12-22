package com.epam.tat.module4;

public class Timeout {
    public Timeout() {
    }

    public static void sleep(int sec) {
        try {
            Thread.sleep((long)(sec * 2000));
        } catch (InterruptedException var2) {
            ;
        }
    }
}
