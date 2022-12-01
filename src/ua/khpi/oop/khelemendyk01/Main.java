package ua.khpi.oop.khelemendyk01;

public class Main {
    public static void main(String[] args) {
        final int RECORD_BOOK_NUMBER = 0xFF_FF;
        final long PHONE_NUMBER = 380667802881L;
        final int LAST_2_DIGITS_FROM_NUM = 0b1010001;
        final int LAST_4_DIGITS_FROM_NUM = 05501;
        final int STUDENT_NUMBER = (20 - 1) % 26 + 1;
        final char SYMBOL = 'U';
        long[] arr = new long[] {(long) RECORD_BOOK_NUMBER, PHONE_NUMBER,
                (long) LAST_2_DIGITS_FROM_NUM, (long) LAST_4_DIGITS_FROM_NUM,
                (long) STUDENT_NUMBER, (long) SYMBOL};
        int even, odd, ones;
        even = odd = ones = 0;

        for (long el : arr) {
            ones += Long.bitCount(el);

            while (el > 1) {
                long temp = el % 10;

                if (temp % 2 == 0) even++;
                else odd++;

                el /= 10;
            }
        }
    }
}
