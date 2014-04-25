package sort;

import io.FileProcessor;
import java.io.IOException;
import java.util.Map;
import java.util.Queue;
import sort.ShellSortSequenceGenerator.SequenceType;

public class SortAnalyzer {
    
    private FileProcessor fileProcessor;
    
    private SortFactory factory;
    
    public SortAnalyzer(FileProcessor fileIO)
    {
        this.fileProcessor = fileIO;
        this.factory = new SortFactory();
    }
    
    public void runAnalysis() throws IOException
    {
        Map<String, Queue<Integer>> numberMap 
                = this.fileProcessor.getMapList();
        
        for (String fileName : numberMap.keySet()) {
            
            Integer[] heapValues = 
                     numberMap.get(fileName).toArray(
                             new Integer[numberMap.get(fileName).size()]);
            
            runShellSortAnalysis(fileName, heapValues);
            runHeapSortAnalysis(fileName, heapValues);
        }

    }
    
    private void runShellSortAnalysis(String fileName, Integer[] heapValues) throws IOException
    {
        ISort shellShort = null;
        
        for(SequenceType sequence : SequenceType.values())
        {
            shellShort = factory.createShellSort(sequence, heapValues.clone());
            runSort(fileName, shellShort);
        }
    }
    
    private void runHeapSortAnalysis(String fileName, Integer[] heapValues) throws IOException
    {
        ISort heapSort = factory.createHeapSort(heapValues.clone());
        System.out.println(heapSort.toString());
        runSort(fileName, heapSort);
    }
    
    private void runSort(String fileName, ISort sort) throws IOException
    {

        String outputFile = fileName + ".result";
        
        System.out.println("Size of sort: " + sort.size());
        //sort.printSortedData();
        // Calculate time
        long preSortTime = System.currentTimeMillis();
        sort.sort();
        long afterSortTime = System.currentTimeMillis();
        long sortTime = afterSortTime - preSortTime;

        System.out.println("Sort = " + sort.name() + " took: "
                + sortTime + " milliseconds");

        
        this.fileProcessor.writeToFile(outputFile, sort.toString());
        
        
    }
}
