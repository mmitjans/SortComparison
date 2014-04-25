/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sort;

import sort.ShellSortSequenceGenerator.SequenceType;

public class SortFactory<T extends Comparable> {
    
    public ISort createShellSort(SequenceType type, T[] values)
    {
        return new ShellSort<>(type, values);
    }
    
    public ISort createHeapSort(T[] values)
    {
        return new HeapSort<>(values);
    }
}
