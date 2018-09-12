package com.company.books;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Set<Book> books = Stream.generate(RandomLibrary::getRandomBook)
                .limit(10)
                .collect(Collectors.toSet());

        books.forEach(x -> System.out.println(x));

        System.out.println();
        System.out.println("-----------");
        System.out.println();

        //Many authors <-> Many books
        //...code
        //...more code
        //one author <-> one book
        //a,b,c <-> 1,2,3
        //a - 1,2,3
        //b - 1
        //c - 1
        //a - 2
        //b - 2
        //c - 2
        //a - 3
        //b - 3
        //c - 3

        //3 = [a,b,c]
        //a = [1,2,3]

        books.stream()
                .map(book -> book.getAuthors()) //Stream<Set<Author>>
                .flatMap(authors -> authors.stream())//Stream<Author>
                .map(author -> {
                    //a - 1,2,3
                    List<Pair<String, String>> authorBookList = new ArrayList<>();
                    for (Book book : author.getBooks()) {
                        authorBookList.add(new Pair<>(author.getName(), book.getTitle()));
                    }
                    //a - 1
                    //a - 2
                    //a - 3
                    return authorBookList;
                })
                .flatMap(x -> x.stream())
                //a - 1
                //a - 2
                //a - 3
                //b - 1
                //b - 2
                //b - 3
                //c - 1
                //c - 2
                //c - 3
                .collect(
                        Collectors.groupingBy(
                                x -> x.getKey(),
                                Collectors.mapping(
                                        x -> x.getValue(),
                                        Collectors.toSet()
                                )
                        )
                )
                .entrySet()
                .forEach(x -> System.out.println(x));

        // JDK: Oracle, Apple, OpenJDK
        //Cortesian product/result
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}