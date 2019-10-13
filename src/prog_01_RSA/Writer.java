package prog_01_RSA;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Writer {
    public static void writeKey(String keyname, BigInteger a, BigInteger b) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(keyname));
        writer.write(a.toString());
        writer.write(" ");
        writer.write(b.toString());
        writer.write("\n");
        writer.close();
    }
}
