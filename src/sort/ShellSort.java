package sort;

import sort.ShellSortSequenceGenerator.SequenceType;

public class ShellSort<T extends Comparable> extends BaseSort
{
    private SequenceType _sequenceType;
    
    public ShellSort(SequenceType type, T[] data)
    {
        super(data);
        _sequenceType = type;
    }
        
    public void sort()
    {
        int listLength = data.length;
        
        int[] gapSequence = 
                ShellSortSequenceGenerator.generateSequence(_sequenceType, 
                        listLength);
        
        // Iterates through each gap
        for(int gapIter = 0; gapIter < gapSequence.length; gapIter++)
        {
            // Gets the current gap
            int currentGap = gapSequence[gapIter];
            
            // Starts at the first gap index
            for (int arrayIndex = currentGap; 
                    arrayIndex < data.length; arrayIndex += 1) {
                
                try {

                    // Current value in the array @gap index
                    Comparable temp = data[arrayIndex];

                    int gapArrayIndex = arrayIndex;
                    //System.out.println("Current temp: " + temp);
                    //System.out.println("Current gapArrayIndex: " + gapArrayIndex);
                    //System.out.println("Current gap: " + currentGap);
                    
                    for (; gapArrayIndex >= currentGap
                            && compareValue(data[gapArrayIndex - currentGap], 
                                            temp) > 0;
                            gapArrayIndex -= currentGap) 
                    {
                        //System.out.println("Gap array index: " + gapArrayIndex);
                        //System.out.println("Compare value: " + 
                        //        (gapArrayIndex - currentGap));
                        
                        data[gapArrayIndex] = 
                                data[gapArrayIndex - currentGap];
                    }

                    data[gapArrayIndex] = temp;

                } catch (Exception e) {
                    // This is an ok exception because the gap could be greater
                    // than the actual array index
                }
            }
        }
        
    }
 
    public String name()
    {
        return "ShellSort with SequenceType " + this._sequenceType.name();
    }
}
