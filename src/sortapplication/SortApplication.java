package sortapplication;

import sort.HeapSort;
import sort.ShellSort;
import sort.ShellSortSequenceGenerator.SequenceType;

public class SortApplication {


    public static void main(String[] args) {
        
        Integer[] values = new Integer[]{222,40, 5, 20, 99};
        
        ShellSort<Integer> shellSort = new ShellSort(SequenceType.FIRST);
        //shellSort.show(values);
        //shellSort.sortValues(values);
        //shellSort.show(values);
        
        
        Integer[] heapValues = new Integer[]{222,40, 5, 20, 99};
        HeapSort<Integer> heapSort = new HeapSort<>();
        heapSort.show(heapValues);
        heapSort.sort(heapValues);
        heapSort.show(heapValues);
    }
    
}
