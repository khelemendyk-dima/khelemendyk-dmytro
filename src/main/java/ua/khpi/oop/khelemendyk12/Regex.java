package ua.khpi.oop.khelemendyk12;

/**
 * Contains all required for validation regexes
 *
 * @author Khelemendyk Dmytro
 * @version 1.0
 */
public final class Regex {
    /**
     * Allows to validate strings with alphanumeric symbols, dots, commas, spaces and hyphen.
     */
    public static final String SIMPLE_STRING_REGEX = "^[A-Za-zА-ЩЬЮЯҐІЇЄЭЫа-щьюяґіїєэы0-9'.,\\- ]+$";
    public static final String ISBN_REGEX = "^[0-9]{3}-[0-9]{3}-[0-9]{6}-[0-9]$";
    public static final String GENRE_REGEX = "^[A-Za-zА-ЩЬЮЯҐІЇЄЭЫа-щьюяґіїєэы']+$";
    public static final String AUTHOR_REGEX = "^[A-Za-zА-ЩЬЮЯҐІЇЄЭЫа-щьюяґіїєыэ'.,\\- ]+$";
    public static final String YEAR_REGEX = "^[12][0-9]{3}$";
    private Regex() {}
}
