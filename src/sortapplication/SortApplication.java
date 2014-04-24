package sortapplication;

import io.FileProcessor;
import java.io.IOException;
import java.util.Arrays;
import java.util.Queue;
import sort.HeapSort;
import sort.ISort;
import sort.ShellSort;
import sort.ShellSortSequenceGenerator.SequenceType;

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
        
        Queue<Integer> numbers = fileIO.getList();
        
        Integer[] heapValues = new Integer[numbers.size()];
        int iter = 0;
        for(Integer currentNumber : numbers)
        {
            heapValues[iter] = currentNumber;
            iter++;
        }
        ISort<Integer> shellSort = new ShellSort<>(SequenceType.FIRST, heapValues);
        ISort<Integer> heapSort = new HeapSort<>(heapValues);
        shellSort.printSortedData();
        long startTime = System.currentTimeMillis();
        shellSort.sort();
        long delta = System.currentTimeMillis() - startTime;
        System.out.println("Took: " + delta);
        shellSort.printSortedData();
    }
    
}
