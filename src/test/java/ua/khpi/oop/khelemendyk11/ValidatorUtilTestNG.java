package ua.khpi.oop.khelemendyk11;

import org.testng.Assert;
import org.testng.annotations.*;

import static ua.khpi.oop.khelemendyk11.ValidatorUtil.*;

@Test()
public class ValidatorUtilTestNG {
    @DataProvider
    public Object[][] validISBN() {
        return new String[][] {new String[]{"987-643-234567-1"},
                new String[]{"111-111-111111-1"},
                new String[]{"654-123-568412-5"},
                new String[]{"123-456-789023-3"},
                new String[]{"321-665-989795-8"}
        };
    }

    @DataProvider
    public Object[][] wrongISBN() {
        return new String[][] {new String[]{"6"},
                new String[]{"-111-111111-1"},
                new String[]{"ASD-123-568412-5"},
                new String[]{"123-F-789023-3"},
                new String[]{"321-665-"}
        };
    }

    @DataProvider
    public Object[][] validSimpleString() {
        return new String[][] {new String[]{"Приключения Тома Сойера"},
                new String[]{"3 Поросенка"},
                new String[]{"м. Київ"},
                new String[]{"Forrest gump 2"},
                new String[]{"You, me, them"}
        };
    }

    @DataProvider
    public Object[][] wrongSimpleString() {
        return new String[][] {new String[]{"@#$%^&*()_+"},
                new String[]{"Awful_things"},
                new String[]{"3% Поросенка"},
                new String[]{"Forrest gump 2 ;)"},
                new String[]{"You, me, them~"}
        };
    }

    @DataProvider
    public Object[][] validGenre() {
        return new String[][] {new String[]{"Фантастика"},
                new String[]{"Драма"},
                new String[]{"проза"},
                new String[]{"РОМАН"},
                new String[]{"Science"}
        };
    }

    @DataProvider
    public Object[][] wrongGenre() {
        return new String[][] {new String[]{"Фантастика!"},
                new String[]{"%Драма"},
                new String[]{"пр$оза"},
                new String[]{"Р~О~М~А~Н"},
                new String[]{"S-c-i-e-n-c-e"}
        };
    }

    @DataProvider
    public Object[][] validDate() {
        return new String[][] {new String[]{"1234"},
                new String[]{"2023"},
                new String[]{"1555"},
                new String[]{"1956"},
                new String[]{"2000"}
        };
    }

    @DataProvider
    public Object[][] wrongDate() {
        return new String[][] {new String[]{"1"},
                new String[]{"20"},
                new String[]{"155555"},
                new String[]{"19566"},
                new String[]{"word"}
        };
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
        String[] authors = {"Марк Твен", "Джек Лондон", "Й. Й. Булгаков", "УКРАЇНКА", "Abra-mov"};
        Assert.assertTrue(validateAuthors(authors));
    }

    @Test
    public void testWrongValidateAuthors() {
        String[] authors = {"Марк & Твен", "Джек Л0нд0н", "$Булгаков$", "Э_К_З_Ю_П_Е_Р_И", "Abra-mov"};
        Assert.assertFalse(validateAuthors(authors));
    }
}
