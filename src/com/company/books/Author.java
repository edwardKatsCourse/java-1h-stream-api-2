package com.company.books;

import java.util.Objects;
import java.util.Set;

public class Author {

    private String name;
    private Set<Book> books;

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Author() {
    }

    public Author(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, books);
    }
}
