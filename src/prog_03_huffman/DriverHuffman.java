package prog_03_huffman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DriverHuffman {
    private static final String inputFile01 = "testInput01";

    private static final String decTab = "dec_tab-mada.txt";
    private static final String compressedFile = "output-mada.dat";


    public static void main(String[] args) {


        // Sort the occurrences for lowest values first such that
        // the lowest frequencies can be selected.
        System.out.println("-----------------------------");
        System.out.println("OCCURENCE OF INPUT");
        System.out.println("-----------------------------");
        Huffman huffman = new Huffman();
        huffman.countOccurrences(inputFile01);
        huffman.sortOccurrences();
        huffman.buildCode();
        huffman.saveCode();








        // Decode given data.
        // System.out.println("-----------------------------");
        // System.out.println("READING COMPRESSED DATA");
        // System.out.println("-----------------------------");
        // File file = new File("src/testInputs/output-mada.dat");
        // byte[] bFile = new byte[(int) file.length()];
        // try {
        //     FileInputStream fis = new FileInputStream(file);
        //     int currentByte;
        //     int i = 0;
        //     while ((currentByte = fis.read()) != -1) {
        //         bFile[i] = (byte) currentByte;
        //         System.out.println("Current byte: " + currentByte + ", " + Integer.toBinaryString(bFile[i]));
        //         i++;
        //     }
        //     fis.close();
        // } catch (FileNotFoundException e) {
        //     e.printStackTrace();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
}
