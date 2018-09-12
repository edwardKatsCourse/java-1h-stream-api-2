package com.company.books;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomLibrary {

    private static final String[] AUTHORS = {
            "Gregory Linn",
            "Gregory Lee",
            "John Johnson",
            "John Philips",
            "George Fox",
            "John Ford"
    };

    private static final String[] BOOKS = {
            "Bread and Stone",
            "Red and Black",
            "Death and Life",
            "Drugs and Rock'n'Roll"
    };

    private static String getRandomName(String[] array) {
        int randomIndex = new Random().nextInt(array.length);
        return array[randomIndex];
    }


    public static Book getRandomBook() {
        Book book = new Book();
        book.setTitle(getRandomName(BOOKS));

        int authorsCount = new Random().nextInt(4) + 1;
        Set<Author> authors = Stream
                .generate(RandomLibrary::getRandomAuthor)
                .limit(authorsCount)
                .peek(author -> {
                    if (author.getBooks() == null) {
                        author.setBooks(new HashSet<>());
                    }
                    author.getBooks().add(book);
                })
                .collect(Collectors.toSet());

        book.setAuthors(authors);

        return book;
    }

    public static Author getRandomAuthor() {
        Author author = new Author();
        author.setName(getRandomName(AUTHORS));
        return author;
    }
}
