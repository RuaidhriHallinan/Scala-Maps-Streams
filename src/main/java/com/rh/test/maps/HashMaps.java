package com.rh.test.maps;

import java.util.HashMap;

public class HashMaps {

    public static void main(String args[]) {

        /* This is how to declare HashMap */
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();

        System.out.println("Java Hashmaps Example");

        //Adding to a Map
        hmap.put(34, "Stephanie");
        hmap.put(36, "Ruaidhri");
        hmap.put(1, "Grace");

        //Adding to a Map if absent
        hmap.putIfAbsent(0, "Finn");

        //Checking does contain Key
        int userAge = 36;
        if(hmap.containsKey(userAge)) {
            System.out.println("Map contains Luke");
        } else {
            System.out.println("Map does not contain Luke");
        }

        //Checking does contain Value
        String userName = "Ruaidhri";
        if(hmap.containsValue(userName)) {
            System.out.println("Map contains Ruaidhri");
        } else {
            System.out.println("Map does not contain Ruaidhri");
        }

        //Adding to Map
        hmap.put(100, "Unknown");
        System.out.println(hmap);
        //Removing from Map
        hmap.remove(100);
        System.out.println(hmap);
        System.out.println(hmap.get(36));

        //Getting the Values
        System.out.println("Values: " + hmap.values());
        //Getting the Keys
        System.out.println("Keys:" + hmap.keySet());
        //Getting the entrySet
        System.out.println("Entries:" + hmap.entrySet());

        //Iterating through hashMap keys, values
        hmap.forEach((k, v) -> {
            //.keySet().forEach
            //.values().forEach
            System.out.println(k + " => " + v);
        });

        //Iterating through ma entry set
        hmap.entrySet().forEach(m -> {
            System.out.println(m);
        });

    }
}
