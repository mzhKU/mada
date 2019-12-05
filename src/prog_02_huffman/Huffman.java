package prog_02_huffman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.groupingBy;

public class Huffman {

    // Keep relative occurrence of ASCII code.
    private Map<Integer, Double> huffman;

    public Huffman() {
        this.huffman = new HashMap<>();

        // Populate the huffman Map initialy with keys and zeroes.
        for (int i = 0; i<128; i++) {
            huffman.put(Integer.valueOf(i), 0.0);
        }
    }

    public void compress(String inputFileName) {
        parse(getFilePath(inputFileName));
    }

    public void parse(Path inputFilePath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(inputFilePath));
            charOccurrenceInLine(content);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void charOccurrenceInLine(String content) {
        // Count character occurrence and store in tmp map.
        Map<Integer, Long> tmp = new HashMap<>();
        tmp = Stream.of(content.split(""))
                .map(s -> s.charAt(0))
                .map(c -> Integer.valueOf((int) c))
                .collect(groupingBy(i -> i, counting()));

        // Set the values in the huffman map.
        for(Integer k : tmp.keySet()) {
            huffman.put(k, Double.valueOf(tmp.get(k))/content.length());
        }
        System.out.println(huffman);
    }

    private Path getFilePath(String inputFileName) {
        String current = System.getProperty("user.dir");
        Path inputFilePath = Paths.get(current, "src", "testInputs", inputFileName);
        return inputFilePath;
    }
}
