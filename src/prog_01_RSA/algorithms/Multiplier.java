package prog_01_RSA.algorithms;

import java.math.BigInteger;

public class Multiplier {
    public BigInteger fastExp(int x, BigInteger e, BigInteger n) {

        boolean log = true;

        String binaryE = Integer.toBinaryString(Integer.valueOf(e.toString()));

        BigInteger j = BigInteger.valueOf(binaryE.length());
        BigInteger h = BigInteger.ONE;
        BigInteger k = BigInteger.valueOf(x);

        if (log) {
            String[] fieldsLabels = {"i", "h", "k"};
            BigInteger[] initialvalues = {j.subtract(BigInteger.ONE), h, k};

            System.out.println("Initial binary e: " + binaryE);
            System.out.println(String.format("%4s binaryE[i] %4s %10s", fieldsLabels));
            System.out.println("---------------------------------");
        }

        int i = j.intValue();

        // Note: The highest index value refers to the lowest significant digit.
        //       -> iterating over the binary representation from end to start.
        while (i > 0) {
            System.out.println(String.format("%4s %4s %10s %10s", i-1, binaryE.charAt(i-1), h, k));
            if (Character.getNumericValue(binaryE.charAt(i-1)) == 1) {
                h = (h.multiply(k)).mod(n);
            }
            k = (k.multiply(k)).mod(n);
            i = i-1;
        }
        return h;
    }
}
