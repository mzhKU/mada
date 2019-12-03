package prog_02_huffman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Huffman {

    private Map<String, Long> huffman;
    private static StringBuilder lines;

    public Huffman() {
        this.huffman = new HashMap<>();
    }

    public Map<String, Long> charIntMap(String input) {
        return this.huffman;
    }

    public void compress(String inputFile) {
        String current = System.getProperty("user.dir");
        setInput(inputFile);
        getRelativeOccurence();
    }

    public void getRelativeOccurence() {
        Stream charStream = Arrays.stream(lines.toString().toLowerCase().split(""));
        huffman = (Map<String, Long>) charStream.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(lines.toString());
        System.out.println(huffman);
    }

    public void setInput(String inputFile) {
        String current = System.getProperty("user.dir");
        Path inputFilePath  = Paths.get(current, "src", "testInputs", inputFile);
        try(BufferedReader r = new BufferedReader(new FileReader(String.valueOf(inputFilePath)))) {
            String line;
            lines = new StringBuilder();
            while ((line=r.readLine()) != null) {
                lines.append(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
