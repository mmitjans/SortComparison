package sortapplication;

import io.FileProcessor;
import java.io.IOException;
import java.util.Arrays;
import sort.SortAnalyzer;

public class SortApplication {

    public static void main(String[] args) throws IOException 
    {
        if(args.length != 6)
        {
            throw new RuntimeException("Invalid number of arguments");
        }
        
        // copy the input files
        String[] inputFiles = Arrays.copyOfRange(args, 1, 5);
        String outputFileName = args[0];
        
        FileProcessor fileIO = 
                new FileProcessor(inputFiles, outputFileName);
        
        SortAnalyzer analyzer = new SortAnalyzer(fileIO);
        analyzer.runAnalysis();
    }
    
}
