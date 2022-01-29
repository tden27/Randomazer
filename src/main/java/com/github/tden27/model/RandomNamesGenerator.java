package com.github.tden27.model;

import java.util.*;

public class RandomNamesGenerator {
    private static final List<Integer> answeredPersonKeys = new ArrayList<>();
    private static final Map<Integer, String> mapExcel = ParserExcel.readFromExcel();
    private static Integer keyOfFirstPerson;
    private static Integer keyOfLastAnsweredPerson;


    public static int random() {
        int generated;
        Random random = new Random();
        while (true) {
            generated = random.nextInt(mapExcel.size() + 1);
            if (generated == 0) continue;
            if (!answeredPersonKeys.contains(generated)) {
                answeredPersonKeys.add(generated);
                break;
            }
        }
        return generated;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Нажмите Enter для генерации или Х для выхода");
        while (!scanner.nextLine().equalsIgnoreCase("x")) {
            if (answeredPersonKeys.size() == mapExcel.size()) {
                System.out.println(mapExcel.get(keyOfLastAnsweredPerson) + " ask " + mapExcel.get(keyOfFirstPerson));
                System.out.println("Все учащиеся сгенерированы");
                break;
            }
            System.out.println("Нажмите Enter для продолжения или Х для выхода");
            if(keyOfFirstPerson == null){
                keyOfFirstPerson = random();
                keyOfLastAnsweredPerson = random();
                System.out.println(mapExcel.get(keyOfFirstPerson) + " ask " + mapExcel.get(keyOfLastAnsweredPerson));
            }else{
                Integer tmpKey = random();
                System.out.println(mapExcel.get(keyOfLastAnsweredPerson) + " ask " + mapExcel.get(tmpKey));
                keyOfLastAnsweredPerson = tmpKey;
            }
        }

    }
}
