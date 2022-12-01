package ua.khpi.oop.khelemendyk08;

import java.util.StringJoiner;

public class Book {
    private final String ISBN;
    private final String name;
    private final String[] authors;
    private final String production;
    private final String genre;
    private final int publicationDate;

    public Book(){
        this.ISBN = "123-456-789012-3";
        this.name = "Быть или не быть";
        this.authors = new String[] { "Марк Твен", "Джек Лондон" };
        this.production = "Первое издание";
        this.genre = "Фантастика";
        this.publicationDate = 2020;
    }

    public Book(String ISBN, String name, String[] authors, String edition, String genre, int publicationDate) {
        this.ISBN = ISBN;
        this.name = name;
        this.authors = authors;
        this.production = edition;
        this.genre = genre;
        this.publicationDate = publicationDate;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getName() {
        return name;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String getProduction() {
        return production;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public String toString() {
        return    "Название: " + name +
                "\nISBN: " + ISBN +
                "\nАвторы: " + getStringAuthors() +
                "\nИздательство: " + production +
                "\nЖанр: " + genre +
                "\nДата публикации: " + publicationDate;
    }

    /**
     * Функція перетворює масив в рядок, у якому перераховує
     * елементи через кому.
     * @return перетворенний рядок.
     */
    private String getStringAuthors() {
        StringJoiner sj = new StringJoiner(", ");
        for (String author : authors)
            sj.add(author);

        return sj.toString();
    }
}
