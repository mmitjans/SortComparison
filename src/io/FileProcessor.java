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

public class FileProcessor {

    private Path fFilePath;
    // UTF-8 Encoding
    private final static Charset ENCODING = StandardCharsets.UTF_8;

    // Variables that stores the input/output filenames
    private String inputFile;
    private String[] listOfFiles;
    private String outputFile;
    // Use to write into a file
    private BufferedWriter writer = null;

    public FileProcessor(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        
        try {
            File file = new File(outputFile);
            writer = new BufferedWriter(new FileWriter(file));
        } catch (IOException ex) {

        }
    }
    
    public FileProcessor(String[] inputFiles, String outputFile) 
    {
        this.outputFile = outputFile;
        this.listOfFiles = inputFiles;
           
        try {
            File file = new File(outputFile);
            writer = new BufferedWriter(new FileWriter(file));
        } catch (IOException ex) {
            System.out.println("Exception while creating file: " + 
                    ex.getMessage());
        }
    }

    public Queue<Integer> getList() throws IOException 
    {
        Queue<Integer> list = new LinkedList<>();
        
        for(String currentFile : this.listOfFiles)
        {
            appendToList(currentFile, list);
        }

        return list;
    }
    
    private void appendToList(String inputFile, Queue<Integer> list) throws IOException
    {
        Path filePath = Paths.get(inputFile);

        Scanner scanner = new Scanner(filePath, ENCODING.name());

        while (scanner.hasNextLine()) {
            list.add(Integer.parseInt(scanner.nextLine()));
        }
    }
}
