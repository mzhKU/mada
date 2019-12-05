package prog_02_huffman;

import utils.Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DriverHoffman {

    private static final String inputFile01 = "testInput01";
    private static Huffman huffman;


    public static void main(String[] args) {

        huffman = new Huffman();
        huffman.compress(inputFile01);

        // 1: Read an ASCII encoded file

        // 2: Generate character counting table

        // 3: Construct Huffman coding for the counting table

        // 4: Write Huffman coding table to external file "dec_tab.txt" as
        //    ASCII-Code of character 1:Code of character 1
        //    ASCII-Code of character 2:Code of character 2
        //    [...]
        //    --> see p. 3.12

        // 5: Convert the input file into a bit string

        // 6: Append '1' and as many '0' as required to the bit string
        //    such that the length of the bit stream becomes a multiple
        //    of eight.

        // 7: Create a byte array from the bit string where eight bits
        //    become a byte

        // 8: Write the bytes into a file "output.dat"

        // 9: Implement decoding: Read from external file encoding table
        //    and byte array.
        //    The byte array is translated to a bit string, cut off the last
        //    '1' and all following '0' from the bit string, then decode
        //    the resulting bit string and save to a file 'decompress.txt'

        // 10: Test the compression level.
    }
}
