package sort;

import sort.ShellSortSequenceGenerator.SequenceType;

public class ShellSort<T extends Comparable> 
{
    
    private SequenceType _sequenceType;
    
    public ShellSort(SequenceType type)
    {
        _sequenceType = type;
    }
        
    public void sortValues(T[] values)
    {
        
        int listLength = values.length;
        
        int[] gapSequence = 
                ShellSortSequenceGenerator.generateSequence(_sequenceType, 
                        listLength);
        
        for(int gapIter = 0; gapIter < gapSequence.length; gapIter++)
        {
            int currentGap = gapSequence[gapIter];
            
            for (int arrayIndex = currentGap; arrayIndex < 
                    values.length; arrayIndex += 1) {
                
                try {

                    T temp = values[arrayIndex];

                    int gapArrayIndex = arrayIndex;

                    for (; gapArrayIndex >= currentGap
                            && compareValue(values[gapArrayIndex - currentGap], 
                                            temp) > 0;
                            gapArrayIndex -= currentGap) 
                    {
                        values[gapArrayIndex] = 
                                values[gapArrayIndex - currentGap];
                    }

                    values[gapArrayIndex] = temp;

                } catch (Exception e) {
                    // This is an ok exception because the gap could be greater
                    // than the actual array index
                }
            }
        }
        
    }
 
    // print array to standard output
    public void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    private int compareValue(Comparable one, Comparable two) {
        return one.compareTo(two);
    }
}
