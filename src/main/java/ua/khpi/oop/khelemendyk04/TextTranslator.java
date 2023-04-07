package ua.khpi.oop.khelemendyk04;

public class TextTranslator {
    private final String inputText;
    private String translatedText;

    public TextTranslator(String text) {
        inputText = text;
    }

    public String getInputText() {
        return inputText;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    /**
     * Функція додає табуляцію між буквами.
     * @return обробленний текст.
     */
    public String getTabulatedText() {
        if (inputText == null) {
            return "inputText is null";
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            int temp = inputText.charAt(i) - 64;
            if (temp > 0)
                res.append(inputText.charAt(i)).append("\t");
        }

        return res.toString();
    }

    /**
     * Функція заміняє літери їхні номера в алфавіті.
     */
    public void lettersToDigits() {
        if (inputText == null) {
            System.out.println("inputText is null");
            return;
        }

        StringBuilder res = new StringBuilder();
        String text = inputText.toUpperCase();

        for (int i = 0; i < text.length(); i++) {
            int temp = text.charAt(i) - 64;
            if (temp > 0)
                res.append(temp).append("\t");
        }
        translatedText =  res.toString();
        System.out.println("Обчислення виконані");
    }
}
