package hu.progmatic;

public class TestWrongMethod {



    public static boolean isPrime(int number) {
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return number >= 2;
    }


}
