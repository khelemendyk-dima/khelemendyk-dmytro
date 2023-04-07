package ua.khpi.oop.khelemendyk11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static ua.khpi.oop.khelemendyk11.ValidatorUtil.*;

class ValidatorUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"987-643-234567-1", "111-111-111111-1", "654-123-568412-5", "123-456-789023-3", "321-665-989795-8"})
    void testValidateISBN(String ISBN) {
        assertTrue(validateISBN(ISBN));
    }

    @ParameterizedTest
    @ValueSource(strings = {"6", "-111-111111-1", "ASD-123-568412-5", "123-F-789023-3", "321-665-"})
    void testWrongValidateISBN(String ISBN) {
        assertFalse(validateISBN(ISBN));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Приключения Тома Сойера", "3 Поросенка", "м. Київ", "Forrest gump 2", "You, me, them"})
    void testValidateSimpleString(String string) {
        assertTrue(validateSimpleString(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"@#$%^&*()_+", "Awful_things", "3% Поросенка", "Forrest gump 2 ;)", "You, me, them~"})
    void testWrongValidateSimpleString(String string) {
        assertFalse(validateSimpleString(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Фантастика", "Драма", "проза", "РОМАН", "Science"})
    void testValidateGenre(String genre) {
        assertTrue(validateGenre(genre));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Фантастика!", "%Драма", "пр$оза", "Р~О~М~А~Н", "S-c-i-e-n-c-e"})
    void testWrongValidateGenre(String genre) {
        assertFalse(validateGenre(genre));
    }

    @Test
    void testValidateAuthors() {
        String[] authors = {"Марк Твен", "Джек Лондон", "Й. Й. Булгаков", "УКРАЇНКА", "Abra-mov"};
        assertTrue(validateAuthors(authors));
    }

    @Test
    void testWrongValidateAuthors() {
        String[] authors = {"Марк & Твен", "Джек Л0нд0н", "$Булгаков$", "Э_К_З_Ю_П_Е_Р_И", "Abra-mov"};
        assertFalse(validateAuthors(authors));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "2023", "1555", "1956", "2000"})
    void testValidatePublicationDate(String year) {
        assertTrue(validatePublicationDate(year));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "20", "155555", "19566", "word"})
    void testWrongValidatePublicationDate(String year) {
        assertFalse(validatePublicationDate(year));
    }
}
