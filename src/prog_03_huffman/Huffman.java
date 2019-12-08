package prog_03_huffman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Huffman {
    Map<String, Double> occurrence = new HashMap<>();
    Map<String, String> occurrenceBits = new HashMap<>();
    List<Map<String, Double>> entryList;

    public Huffman() {
        this.entryList = new ArrayList<>();
    }

    public void saveCode() {
        Iterator i = occurrenceBits.keySet().iterator();
        while (i.hasNext()) {
            i.next();
        }
        System.out.println("end");
    }

    public void buildCode() {
        while (entryList.size() > 1) {
            Map<String, Double> lastEntry = entryList.get(entryList.size()-1);
            Map<String, Double> secondLastEntry = entryList.get(entryList.size()-2);
            Map<String, Double> combinedEntry = new HashMap<>();

            // Remove the last two elements which will be combined into a new item.
            entryList = entryList.subList(0, entryList.size()-2);

            // For convenience keep references to the keys of the two items.
            String lastEntryKey       = lastEntry.keySet().iterator().next();
            String secondLastEntryKey = secondLastEntry.keySet().iterator().next();

            // The key and frequency of the combined item.
            String newKey  = lastEntry.keySet().iterator().next() + secondLastEntry.keySet().iterator().next();
            Double newFreq = lastEntry.get(lastEntry.keySet().iterator().next()) + secondLastEntry.get(secondLastEntry.keySet().iterator().next());

            // Inserting the new item into the entry list.
            combinedEntry.put(newKey, newFreq);
            entryList.add(combinedEntry);

            // Sort the list.
            entryList.sort(mapComparator);

            for (String s : lastEntryKey.split("")) {
                occurrenceBits.put(s, "0" + occurrenceBits.get(s));
            }

            for (String s : secondLastEntryKey.split("")) {
                occurrenceBits.put(s, "1" + occurrenceBits.get(s));
            }

            System.out.println(occurrenceBits);
        }

        System.out.println("COMBINED ENTRY LIST:");
        System.out.println(entryList);

        System.out.println("OCCURRENCE BITS");
        System.out.println(occurrenceBits);
    }


    public void sortOccurrences() {
        // Sort the list of maps by the frequency value using a custom mapComparator.
        Set<String> keys = this.occurrence.keySet();
        for (String k : keys) {
            Map<String, Double> tmpMap = new HashMap<>();
            tmpMap.put(k, this.occurrence.get(k));
            entryList.add(tmpMap);
        }

        Collections.sort(entryList, mapComparator);
        System.out.println("SORTED ENTRY LIST:");
        System.out.println(entryList);
    }

    public Comparator<Map<String, Double>> mapComparator = new Comparator<Map<String, Double>>() {
        @Override
        public int compare(Map<String, Double> o1, Map<String, Double> o2) {
            return o2.get(o2.keySet().iterator().next()).compareTo(o1.get(o1.keySet().iterator().next()));
        }
    };


    public void countOccurrences(String inputFile) {
        parse(getFilePath(inputFile));
    }

    public void parse(Path inputFilePath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(inputFilePath));
            System.out.println("Content: " + content);
            charOccurrence(content);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    private void charOccurrence(String content) {
        // Count character occurrence and store in tmp map.
        Map<String, Long> tmp = new HashMap<>();
        tmp = Stream.of(content.split(""))
                .map(s -> s.charAt(0))
                .map(c -> String.valueOf(c))
                .collect(groupingBy(i -> i, counting()));
        // Set the values in the occurrenceMap map.
        for(String k : tmp.keySet()) {
            //occurrence.put(k, Double.valueOf(tmp.get(k)/content.length()));
            occurrence.put(k, Double.valueOf(tmp.get(k))/content.length());
            occurrenceBits.put(k, "");
        }

        System.out.println("OCCURENCE MAP:");
        System.out.println(occurrence);

        System.out.println("OCCURENCE BITS INIT");
        System.out.println(occurrenceBits);
    }

    public Path getFilePath(String inputFileName) {
        String current = System.getProperty("user.dir");
        Path inputFilePath = Paths.get(current, "src", "testInputs", inputFileName);
        return inputFilePath;
    }

    public Map<String, Double> getOccurrence() {
        return this.occurrence;
    }
}
