package sortapplication;

import io.FileProcessor;
import java.io.IOException;
import java.util.Queue;
import sort.HeapSort;
import sort.ShellSort;
import sort.ShellSortSequenceGenerator.SequenceType;

public class SortApplication {


    public static void main(String[] args) throws IOException {
        
        FileProcessor fileIO = 
                new FileProcessor("/Users/miltondmitjans/Downloads/lab4Input/dup1K.dat", 
                "/Users/miltondmitjans/Downloads/lab4Input/test.out");
        
        Queue<Integer> numbers = fileIO.getList();
        
        Integer[] values = new Integer[]{222,40, 5, 20, 99};
        
        ShellSort<Integer> shellSort = new ShellSort(SequenceType.FIRST);
        //shellSort.show(values);
        //shellSort.sortValues(values);
        //shellSort.show(values);
        Integer[] heapValues = new Integer[numbers.size()];
        int iter = 0;
        for(Integer currentNumber : numbers)
        {
            heapValues[iter] = currentNumber;
            iter++;
        }
        
        HeapSort<Integer> heapSort = new HeapSort<>();
        heapSort.show(heapValues);
        long startTime = System.currentTimeMillis();
        shellSort.sortValues(heapValues);
        long delta = System.currentTimeMillis() - startTime;
        System.out.println("Took: " + delta);
        heapSort.show(heapValues);
    }
    
}
