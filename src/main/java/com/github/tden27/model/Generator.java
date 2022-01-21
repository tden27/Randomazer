package com.github.tden27.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import static jdk.nashorn.internal.objects.NativeMath.random;

public class Generator{
    private static Map<Integer, String> personsWhichICanAsk;
    private static int personListSize;

    static String generateNextPersonInFullList(Map<Integer, String> personList) {
        personsWhichICanAsk.putAll(personList);
        personListSize = personList.size() - 1;
        Random random = new Random();
        int localNumber = (int)random(personListSize);
        String person = personsWhichICanAsk.get(localNumber);
        personListSize --;
        personsWhichICanAsk.remove(localNumber);

        return person;
    }

}
