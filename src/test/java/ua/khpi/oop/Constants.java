package ua.khpi.oop;

public final class Constants {
    public static final Object[][] validISBN =  new String[][] {
            new String[]{"987-643-234567-1"},
            new String[]{"111-111-111111-1"},
            new String[]{"654-123-568412-5"},
            new String[]{"123-456-789023-3"},
            new String[]{"321-665-989795-8"}
    };

    public static final Object[][] wrongISBN =  new String[][] {
            new String[]{"6"},
            new String[]{"-111-111111-1"},
            new String[]{"ASD-123-568412-5"},
            new String[]{"123-F-789023-3"},
            new String[]{"321-665-"}
    };

    public static final Object[][] validSimpleString =  new String[][] {
            new String[]{"Приключения Тома Сойера"},
            new String[]{"3 Поросенка"},
            new String[]{"м. Київ"},
            new String[]{"Forrest gump 2"},
            new String[]{"You, me, them"}
    };

    public static final Object[][] wrongSimpleString =  new String[][] {
            new String[]{"@#$%^&*()_+"},
            new String[]{"Awful_things"},
            new String[]{"3% Поросенка"},
            new String[]{"Forrest gump 2 ;)"},
            new String[]{"You, me, them~"}
    };
    public static final Object[][] validGenre =  new String[][] {
            new String[]{"Фантастика"},
            new String[]{"Драма"},
            new String[]{"проза"},
            new String[]{"РОМАН"},
            new String[]{"Science"}
    };
    public static final Object[][] wrongGenre =  new String[][] {
            new String[]{"Фантастика!"},
            new String[]{"%Драма"},
            new String[]{"пр$оза"},
            new String[]{"Р~О~М~А~Н"},
            new String[]{"S-c-i-e-n-c-e"}
    };

    public static final Object[][] validDate =  new String[][] {
            new String[]{"1234"},
            new String[]{"2023"},
            new String[]{"1555"},
            new String[]{"1956"},
            new String[]{"2000"}
    };

    public static final Object[][] wrongDate =  new String[][] {
            new String[]{"1"},
            new String[]{"20"},
            new String[]{"155555"},
            new String[]{"19566"},
            new String[]{"word"}
    };

    public static final String[] validAuthors = {
            "Марк Твен", "Джек Лондон",
            "Й. Й. Булгаков", "УКРАЇНКА",
            "Abra-mov"};

    public static final String[] wrongAuthors = {
            "Марк & Твен", "Джек Л0нд0н",
            "$Булгаков$", "Э_К_З_Ю_П_Е_Р_И",
            "Abra-mov"};

    private Constants() {}
}
