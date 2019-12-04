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

    private Map<Integer, Long> huffman;

    public Huffman() {
        this.huffman = new HashMap<>();
    }

    public void compress(String inputFileName) {
        parse(getFilePath(inputFileName));
    }

    public void parse(Path inputFilePath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(inputFilePath));
            charOccuranceInLine(content);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void charOccuranceInLine(String line) {
        huffman = Stream.of(line.split(""))
                .map(s -> s.charAt(0))
                .map(c -> Integer.valueOf((int) c))
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println(huffman);
    }

    private Path getFilePath(String inputFileName) {
        String current = System.getProperty("user.dir");
        Path inputFilePath = Paths.get(current, "src", "testInputs", inputFileName);
        return inputFilePath;
    }
}
