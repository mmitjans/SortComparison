/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sort;

public abstract class BaseSort<T extends Comparable> implements ISort{
    
    protected T[] data;
    
    public BaseSort(T[] data)
    {
        this.data = data;
    }
    
    @Override
    public void printSortedData() {
        for (T value : this.data) {
            System.out.println(value);
        }
    }
    
    protected int compareValue(Comparable one, Comparable two) {
        return one.compareTo(two);
    }
    
    public int size()
    {
        if(this.data != null)
            return this.data.length;
        else 
            return 0;
    }
    
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        
        for (T value : this.data) {
            builder.append("\n");
            builder.append(value);
        }
        
        return builder.toString();
                
    }
            
}
