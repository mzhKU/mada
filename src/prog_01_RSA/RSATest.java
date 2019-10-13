package prog_01_RSA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog_01_RSA.algorithms.Multiplier;

import java.io.*;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class RSATest {

    RSA rsa;
    BigInteger five;
    BigInteger seven;

    @BeforeEach
    void setup() {
        rsa = new RSA();
        five = BigInteger.valueOf(5);
        seven = BigInteger.valueOf(7);
    }

    @Test
    void testFastExp() {
        int x = 7;
        BigInteger e = BigInteger.valueOf(13);
        BigInteger n = BigInteger.valueOf(11);

        Multiplier m = new Multiplier();

        assertEquals(BigInteger.valueOf(2), m.fastExp(x, e, n));
    }


    @Test
    void testConvertCharacter() {
        String testString;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("testFile.txt"));
            writer.write("abc");
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader("testFile.txt"));
            testString = reader.readLine();
            reader.close();

            char currentChar;
            int asciiOfChar;

            int[] correctChars = {97, 98, 99};

            for(int i = 0; i<testString.length(); i++) {
                currentChar = testString.charAt(i);
                asciiOfChar = (int) currentChar;
                assertEquals(asciiOfChar, correctChars[i]);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
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
        assertEquals(rsa.getProductOf(five, seven), BigInteger.valueOf(35));
    }

    @Test
    void testFindE() {
        rsa.setP(five);
        rsa.setQ(seven);
        rsa.setN(rsa.getProductOf(rsa.getP(), rsa.getQ()));
        assertEquals(five, rsa.findE(rsa.getN()));
    }

    @Test
    void testFindD() {
        rsa.setP(five);
        rsa.setQ(seven);
        rsa.setN(rsa.getProductOf(rsa.getP(), rsa.getQ()));
        BigInteger phi = rsa.getPhi(rsa.getN());
        BigInteger e = rsa.findE(rsa.getN());
        BigInteger d = rsa.findD(e, phi);
        assertEquals((e.multiply(d)).mod(phi), BigInteger.ONE.mod(phi));

        rsa.setP(BigInteger.valueOf(1000000));
        rsa.setQ(BigInteger.valueOf(2000000));
        rsa.setN(rsa.getProductOf(rsa.getP(), rsa.getQ()));
        BigInteger phi2 = rsa.getPhi(rsa.getN());
        BigInteger e2 = rsa.findE(rsa.getN());
        BigInteger d2 = rsa.findD(e2, phi2);
        assertEquals((e2.multiply(d2)).mod(phi2), BigInteger.ONE.mod(phi2));
    }
}