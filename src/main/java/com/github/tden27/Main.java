package com.github.tden27;

import com.github.tden27.model.Generator;
import jdk.nashorn.internal.objects.NativeMath;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static jdk.nashorn.internal.objects.NativeMath.random;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Integer, String> users = new HashMap<>();
        users.put(0, "1111");
        users.put(1, "2222");
        users.put(2, "3333");
        users.put(3, "4444");
        users.put(4, "5555");

        Generator.generateNextPersonInFullList(users);
        Generator.generateNextPersonInFullList(users);
        Generator.generateNextPersonInFullList(users);
        Generator.generateNextPersonInFullList(users);
        Generator.generateNextPersonInFullList(users);
        Generator.generateNextPersonInFullList(users);


    }
}
