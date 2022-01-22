package com.github.tden27.model;

import java.util.*;

public class Ramdomaizer {
    private static final List<Integer> cache = new ArrayList<>();
    private static final Map<Integer, String> map = ParserExcel.readFromExcel();

    public static int random() {
        int generated;
        while (true) {
            generated = new Random().nextInt(map.size()+1);
            if (generated == 0) continue;
            if (!cache.contains(generated)) {
                cache.add(generated);
                break;
            }
        }
        return generated;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Нажмите Enter для генерации или Х для выхода");
        while (!scanner.nextLine().equalsIgnoreCase("x")) {
            if (cache.size()==map.size()) {
                System.out.println("Все учащиеся сгенерированы");
                break;
            }
            System.out.println("Нажмите Enter для продолжения или Х для выхода");
            int generated = random();
            System.out.println(generated + "-" + map.get(generated));
        }
    }
}
