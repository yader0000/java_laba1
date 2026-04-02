package org.example;

public class Main {
    public static void main(String[] args) {
        IntegerContainer container = new IntegerContainer();

        container.add(10);
        container.add(20);
        container.add(30);

        System.out.println(container.get(1)); // 20

        container.remove(1);

        System.out.println(container.get(1)); // теперь 30

        System.out.println("Размер: " + container.size());
    }
}