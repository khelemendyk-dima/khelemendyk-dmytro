package ua.khpi.oop.khelemendyk12;

/**
 * Validator to validate ISBN, book's name, authors, etc...
 *
 * @author Khelemendyk Dmytro
 * @version 1.0
 */
public final class ValidatorUtil {

    /**
     * Validates book's ISBN
     * @param isbn string to validate
     * @return true if string is valid
     */
    public static boolean validateISBN(String isbn) {
        return validateFormat(isbn, Regex.ISBN_REGEX);
    }

    /**
     * Validates book's name, production
     * @param string string to validate
     * @return true if string is valid
     */
    public static boolean validateSimpleString(String string) {
        return validateFormat(string, Regex.SIMPLE_STRING_REGEX);
    }

    /**
     * Validates book's genre
     * @param genre string to validate
     * @return true if string is valid
     */
    public static boolean validateGenre(String genre) {
        return validateFormat(genre, Regex.GENRE_REGEX);
    }

    /**
     * Validates authors
     * @param authors array of authors to validate
     * @return true if string is valid
     */
    public static boolean validateAuthors(String[] authors) {
        for (String author : authors) {
            if (!validateFormat(author, Regex.AUTHOR_REGEX)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Validates publication data
     * @param year publication year to validate
     * @return true if string is valid
     */
    public static boolean validatePublicationDate(String year) {
        return validateFormat(year, Regex.YEAR_REGEX);
    }

    /**
     * Validates string with specified regex
     * @param name string to validate
     * @param regex regex for matching
     * @return true if string is valid
     */
    public static boolean validateFormat(String name, String regex) {
        return name != null && name.matches(regex);
    }
}