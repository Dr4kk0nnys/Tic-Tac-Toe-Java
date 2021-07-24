package com.dr4kk0nnys.tic_tac_toe.controllers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class Input {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Function> observers = new ArrayList<>();

    public static void subscribe(Function<Integer, Void> observerFunction) {
        observers.add(observerFunction);
    }

    public static void capture() {
        System.out.print("[0 ~ 9]: ");
        Integer index = scanner.nextInt();
        notifyAllObservers(index);
    }

    public static void close() {
        scanner.close();
    }

    private static void notifyAllObservers(Integer index) {
        for (Function<Integer, Integer> observerFunction : observers) {
            observerFunction.apply(index);
        }
    }
}
