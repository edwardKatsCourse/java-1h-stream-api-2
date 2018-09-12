package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	    //Stream API
        //1. Source (List, Set, Map, Arrays, custom)

        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";

        //Way 1
        List<String> strings = new ArrayList<>();
        strings.add(s1);
        strings.add(s2);
        strings.add(s3);
        strings.add(s4);
        strings.stream(); // -> stream object

        //Way 2
        Stream.of(s1, s2, s3, s4); // -> stream object

        //Way 3
        //Stream -> Builder -> String
        Stream streamFromBuilder = Stream.builder()
                .add(s1)
                .add(s2)
                .add(s3)
                .build();

        //Custom
//        Stream.of(1, 2, 3);
//        Stream.builder()
//                .add(1)
//                .add(2)
//                .build();

        //2. Pipe (operations)
        //List<List<String>>   flatMap ()       List<String>
        //.filter(string -> boolean), .map(string -> int), .flatMap, .peek ...

        //3. terminal operations (sink)
        // .reduce()
        // .collectors()


        // 1. что на выходе -> (Collectors) List, Set, Map, Map + посчитать сколько кого    -> Коллекция значиний
        // 2. что на выходе -> (aggregators) .reduce()                                      -> ОДНО ЗНАЧЕНИЕ

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

        TreeSet<String> processedWords = words.stream()
                .filter(x -> x.length() > 3) //Stream<String>
                .map(x -> x.toUpperCase())   //Stream<List<String>>
//                .peek(x -> /*void*/ x.toUpperCase())
                .collect(Collectors.toCollection(TreeSet::new)); //TreeSet<String>

        processedWords.forEach(x -> System.out.println(x));

        //toMap

//        words.stream()
//        .collect(Collectors.toMap(/*1. key, 2. value*/));
//        .collect(Collectors.toMap(/*1. key, 2. value, 3. duplication handling*/));
//        .collect(Collectors.toMap(/*1. key, 2. value, 3. duplication handling, 4. Map type: HashMap, TreeMap ..*/));

        //Map<String, Integer>
        //Map<Integer, List<String>>


    }
}
