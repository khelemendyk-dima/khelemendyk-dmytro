package ua.khpi.oop.khelemendyk11;

import org.testng.Assert;
import org.testng.annotations.*;

import static ua.khpi.oop.Constants.*;
import static ua.khpi.oop.khelemendyk11.ValidatorUtil.*;

@Test()
public class ValidatorUtilTestNG {
    @DataProvider
    public Object[][] validISBN() {
        return validISBN;
    }

    @DataProvider
    public Object[][] wrongISBN() {
        return wrongISBN;
    }

    @DataProvider
    public Object[][] validSimpleString() {
        return validSimpleString;
    }

    @DataProvider
    public Object[][] wrongSimpleString() {
        return wrongSimpleString;
    }

    @DataProvider
    public Object[][] validGenre() {
        return validGenre;
    }

    @DataProvider
    public Object[][] wrongGenre() {
        return wrongGenre;
    }

    @DataProvider
    public Object[][] validDate() {
        return validDate;
    }

    @DataProvider
    public Object[][] wrongDate() {
        return wrongDate;
    }

    @Test(dataProvider = "validISBN")
    public void testValidateISBN(String ISBN) {
        Assert.assertTrue(validateISBN(ISBN));
    }

    @Test(dataProvider = "wrongISBN")
    public void testWrongValidateISBN(String ISBN) {
        Assert.assertFalse(validateISBN(ISBN));
    }

    @Test(dataProvider = "validSimpleString")
    public void testValidateSimpleString(String s) {
        Assert.assertTrue(validateSimpleString(s));
    }

    @Test(dataProvider = "wrongSimpleString")
    public void testWrongValidateSimpleString(String s) {
        Assert.assertFalse(validateSimpleString(s));
    }

    @Test(dataProvider = "validGenre")
    public void testValidateGenre(String genre) {
        Assert.assertTrue(validateGenre(genre));
    }

    @Test(dataProvider = "wrongGenre")
    public void testWrongValidateGenre(String genre) {
        Assert.assertFalse(validateGenre(genre));
    }

    @Test(dataProvider = "validDate")
    public void testValidatePublicationDate(String date) {
        Assert.assertTrue(validatePublicationDate(date));
    }

    @Test(dataProvider = "wrongDate")
    public void testWrongValidatePublicationDate(String date) {
        Assert.assertFalse(validatePublicationDate(date));
    }

    @Test
    public void testValidateAuthors() {
        Assert.assertTrue(validateAuthors(validAuthors));
    }

    @Test
    public void testWrongValidateAuthors() {
        Assert.assertFalse(validateAuthors(wrongAuthors));
    }
}
