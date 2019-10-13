package prog_01_RSA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static String readFile(String fn) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fn));
        String currentLine = reader.readLine();
        reader.close();
        return currentLine;
    }
}
