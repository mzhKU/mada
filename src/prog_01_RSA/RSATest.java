package prog_01_RSA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class RSATest {

    RSA rsa;

    @BeforeEach
    void setup() {
        rsa = new RSA();
    }

    @Test
    void testggT() {
        BigInteger a = BigInteger.valueOf(100);
        BigInteger b = BigInteger.valueOf(75);
        BigInteger c = BigInteger.valueOf(18);
        BigInteger d = BigInteger.valueOf(7);

        assertEquals(BigInteger.valueOf(25), rsa.ggT(a, b));
        assertEquals(BigInteger.valueOf(1),  rsa.ggT(c, d));
    }

    @Test
    void getProbablePrime() {
        assertEquals(BigInteger.valueOf(101), rsa.getProbablePrime(100));
    }

    @Test
    void getProductOf() {
        BigInteger a = BigInteger.valueOf(5);
        BigInteger b = BigInteger.valueOf(7);
        assertEquals(rsa.getProductOf(a, b), BigInteger.valueOf(35));
    }
}