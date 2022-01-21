package com.github.tden27.model;

import jdk.nashorn.internal.objects.NativeMath;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static jdk.nashorn.internal.runtime.ScriptObject.toPropertyDescriptor;

public class Generator{
    private static String headPerson;
    private static String askedPerson;
    private static List<String> memberNames;
    private static int callMethodCounter = 0;

    public static void generateNextPersonInFullList(Map<Integer, String> personList) {
        memberNames = new ArrayList<>(personList.values());
        if(callMethodCounter == 0 || callMethodCounter == personList.size()){
            generateFirstPerson();
            generateAskedPerson();
            System.out.format("%s, ask %s", headPerson, askedPerson);
            System.out.println();
        }
        callMethodCounter++;
        headPerson = askedPerson;
        generateAskedPerson();
        if(headPerson.equals(askedPerson)){
            generateAskedPerson();
        }
        System.out.format("%s, ask %s", headPerson, askedPerson);
        System.out.println();

    }

    private static void generateFirstPerson() {
        int number = (int) (Math.random() * (memberNames.size() - 1));
        headPerson = memberNames.get(number);
        callMethodCounter = 0;
    }

    private static void generateAskedPerson() {
        int number = (int) (Math.random() * (memberNames.size() - 1));
        askedPerson = memberNames.get(number);
    }

    private static void removeCash(){
        headPerson = null;
        askedPerson = null;
        callMethodCounter = 0;
        memberNames = null;
    }

    public static List<String> getMemberNames() {
        return memberNames;
    }
}
