package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ToMapMain {

    public static void main(String[] args) {
        //toMap

//        words.stream()
//        .collect(Collectors.toMap(/*1. key, 2. value*/));
//        .collect(Collectors.toMap(/*1. key, 2. value, 3. duplication handling*/));
//        .collect(Collectors.toMap(/*1. key, 2. value, 3. duplication handling, 4. Map type: HashMap, TreeMap ..*/));

        //Map<String, Integer>
        //Map<Integer, List<String>>

        List<String> words = new ArrayList<>();
        words.add("apple");
        words.add("apple");
        words.add("car");
        words.add("deer");
        words.add("deer");
        words.add("fox");
        words.add("eagle");
        words.add("eagle");
        words.add("eagle");
        words.add("deer");
        words.add("apple");
        words.add("eagle");
        words.add("forest");
        words.add("guitar");
        words.add("han");
        words.add("han");
        words.add("han");
        words.add("ice-cream");
        words.add("ice-cream");
        words.add("ice-cream");
        words.add("ice-cream");
        words.add("jet");
        words.add("jet");
        words.add("jet");
        words.add("lion");
        words.add("kitten");
        words.add("kitten");
        words.add("kitten");

        //        words.stream()
//        .collect(Collectors.toMap(/*1. key, 2. value*/));
//        .collect(Collectors.toMap(/*1. key, 2. value, 3. duplication handling*/));
//        .collect(Collectors.toMap(/*1. key, 2. value, 3. duplication handling, 4. Map type: HashMap, TreeMap ..*/));


//        streamToMap_1(words);

        //groupingBy - Map
        //1. Collectors.counting -> Map<String, Integer> - считает сколько раз повторяется ключ
        words.stream()
                .collect(Collectors.groupingBy(
                        x -> x /*Function.identity()*/, //key
                        Collectors.counting()           //как считать или что делать если дубликат!
                ))
                .entrySet()
                .stream()
                .forEach(x -> System.out.println(x));

        System.out.println();
        System.out.println("------------------");
        System.out.println();

        //2. Collectors.mapping -> Map<Integer, List<String>>
        //                        длинна слова,   слова
        words.stream()
                .collect(Collectors.groupingBy(
                        x -> x.length(),
                        Collectors.mapping(
                                x -> x,
                                Collectors.toList()
                        )
                ))
                .entrySet()
                .forEach(x -> System.out.println(x));



    }

    //Map<String, String>
    private static void streamToMap_1(List<String> words) {
        words.stream()
//                .map(x -> x.length() > 3)
//                .distinct()
                .collect(
                        Collectors.toMap(
                                Function.identity()/*x -> x*/, //key
                                x -> x,                        //value
                                (x1, x2) -> x1,                //че делать если ключ повторяется
                                TreeMap::new)                  //Map type (TreeMap)
                ).entrySet()
                .stream()
                .forEach(x -> System.out.println(x));
    }


    private static void oldSchool(List<String> words) {
        Map<String, Integer> wordsCount = new HashMap<>();

        for (String word : words) {
            if (wordsCount.get(word) == null) {

                wordsCount.put(word, 1);
            } else {
                wordsCount.put(word, wordsCount.get(word) + 1);
            }
        }

        wordsCount.entrySet().forEach(x -> System.out.println(x));
    }
}
