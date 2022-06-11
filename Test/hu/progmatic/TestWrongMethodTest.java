package hu.progmatic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestWrongMethodTest {

    @Test
    void isPrimeTrue() {
      assertTrue(TestWrongMethod.isPrime(2));
      assertTrue(TestWrongMethod.isPrime(11));
      assertTrue(TestWrongMethod.isPrime(7));


    }
    @Test
    void isPrimeFalse() {
        assertFalse(TestWrongMethod.isPrime(4));


    }
    @Test
    void isPrimeFalse1() {
        assertFalse(TestWrongMethod.isPrime(51));
    }

    @Test
    void isPrimeFalse3() {
        assertFalse(TestWrongMethod.isPrime(9));
    }

    @Test
    void isPrimeFalse2() {
        assertFalse(TestWrongMethod.isPrime(15));
    }
}