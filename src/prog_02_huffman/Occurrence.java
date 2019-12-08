package prog_02_huffman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.groupingBy;

public class Occurrence {

    public void buildTree() {
        Map<String, Double> tmp = new HashMap<>();

        // Combine elements of the map.
        while (tmp.keySet().size() > 1) {
            String newSymbol = "";
            newSymbol += "a";
        }
    }



    // Keep relative occurrence of ASCII code.
    // Not sure if I'm going to need a map<String, Double> or map<Integer, Double>.
    private Map<Integer, Double> occurrenceMapInt;
    private Map<String, Double> occurrenceMapChar;

    public Occurrence() {
        this.occurrenceMapInt = new HashMap<>();
        this.occurrenceMapChar = new HashMap<>();

        // Populate the occurrenceMap Map initialy with keys and zeroes.
        for (int i = 0; i<128; i++) {
            occurrenceMapInt.put(Integer.valueOf(i), 0.0);
            String tmp = String.valueOf((char)i);
            occurrenceMapChar.put(tmp, 0.0);
        }
    }

    public void getOccurrences(String inputFileName) {
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

        // Set the values in the occurrenceMap map.
        for(Integer k : tmp.keySet()) {
            occurrenceMapInt.put(k, Double.valueOf(tmp.get(k))/content.length());
        }
        Map<String, Long> tmp2 = new HashMap<>();
        tmp2 = Stream.of(content.split(""))
                .map(s -> s.charAt(0))
                .map(c -> String.valueOf(c))
                .collect(groupingBy(i -> i, counting()));
        for(String c : tmp2.keySet()) {
            occurrenceMapChar.put(c, Double.valueOf(tmp2.get(c))/content.length());
        }

        System.out.println(occurrenceMapInt);
        System.out.println(occurrenceMapChar);
    }

    private Path getFilePath(String inputFileName) {
        String current = System.getProperty("user.dir");
        Path inputFilePath = Paths.get(current, "src", "testInputs", inputFileName);
        return inputFilePath;
    }

    public Map<Integer, Double> getOccurrenceMap() {
        return this.occurrenceMapInt;
    }
}
