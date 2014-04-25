package sort;

public class ShellSortSequenceGenerator {
    
    public enum SequenceType {
        FIRST,
        SECOND,
        THIRD,
        FOURTH
    };
    
    public static int[] generateSequence(SequenceType sequenceType, int length)
    {
        int[] sequence = null;
        switch(sequenceType)
        {
            case FIRST:
                sequence = new int[]{1093, 364, 121, 40, 13, 4, 1};
            break;  
            case SECOND:
                sequence = new int[]{1123, 373, 149, 53, 17, 5, 1};
            break;
            case THIRD:
                sequence = new int[]{1080, 360, 120, 60, 30, 10, 1};
                break;
            case FOURTH:
                sequence = new int[]{1080, 360, 120, 60, 30, 10, 1};
                break;
            default:
                
        }
        
        return sequence;
    }
}
