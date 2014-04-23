/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sort;

public class ShellSortSequenceGenerator {
    
    public enum SequenceType {
        FIRST,
        SECOND,
        THIRD,
        FOURTH
    };
    
    public static int[] generateSequence(SequenceType type, int length)
    {
        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
        int h = 1;
        while (h < length/3) h = 3*h + 1; 
        return new int[]{1093, 364, 121, 40, 13, 4, 1};
    }
}
