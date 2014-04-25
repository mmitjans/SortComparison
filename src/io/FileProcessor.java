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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
    private BufferedWriter _writer = null;
    
    List<Queue<Integer>> fileList;
    Map<String, Queue<Integer>> fileMap = new HashMap<>();

    public FileProcessor(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        
        try {
            File file = new File(outputFile);
            _writer = new BufferedWriter(new FileWriter(file));
        } catch (IOException ex) {

        }
    }
    
    public FileProcessor(String[] inputFiles, String outputFile) 
    {
        this.outputFile = outputFile;
        this.listOfFiles = inputFiles;
        this.fileList = new LinkedList<>();
           
        try {
            File file = new File(outputFile);
            _writer = new BufferedWriter(new FileWriter(file));
        } catch (IOException ex) {
            System.out.println("Exception while creating file: " + 
                    ex.getMessage());
        }
    }

    public List<Queue<Integer>> getList() throws IOException 
    {
        for(String currentFile : this.listOfFiles)
        {
            Queue<Integer> list = appendToList(currentFile);
            
            this.fileList.add(list);
        }

        return this.fileList;
    }
    
    public Map<String, Queue<Integer>>  getMapList() throws IOException 
    {
        for(String currentFile : this.listOfFiles)
        {
            Queue<Integer> list = appendToList(currentFile);
            
            this.fileMap.put(currentFile, list);
        }

        return this.fileMap;
    }
    
    private Queue<Integer> appendToList(String inputFile) throws IOException
    {
        Queue<Integer> list = new LinkedList<>();
        
        Path filePath = Paths.get(inputFile);

        Scanner scanner = new Scanner(filePath, ENCODING.name());

        while (scanner.hasNextLine()) {
            list.add(Integer.parseInt(scanner.nextLine()));
        }
        
        return list;
    }
    
    public void writeToFile(String fileName, String message)
    {
        try {
            File file = new File(fileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            
            writer.write(message);
            writer.newLine();
            writer.close();
        } catch (IOException ex) {
            System.out.println("Exception while creating file: "
                    + ex.getMessage());
        }
    }
    
}
