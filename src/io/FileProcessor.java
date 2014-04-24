/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class FileProcessor {

    private Path fFilePath;
    // UTF-8 Encoding
    private final static Charset ENCODING = StandardCharsets.UTF_8;

    // Variables that stores the input/output filenames
    private String inputFile;
    private String outputFile;
    // Use to write into a file
    private BufferedWriter writer = null;

    /**
     * Constructor of this class. Takes the input/output file to read/write
     *
     * @param inputFile Input file to read the strings
     */
    public FileProcessor(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        
        try {
            File file = new File(outputFile);
            writer = new BufferedWriter(new FileWriter(file));
        } catch (IOException ex) {

        }
    }

    public Queue<Integer> getList() throws IOException {
        Queue<Integer> list = new LinkedList<>();

        fFilePath = Paths.get(this.inputFile);

        Scanner scanner = new Scanner(fFilePath, ENCODING.name());

        while (scanner.hasNextLine()) {
            list.add(Integer.parseInt(scanner.nextLine()));
        }
        
        return list;
    }
}
