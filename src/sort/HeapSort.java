package sort;

public class HeapSort<T extends Comparable> extends BaseSort
{
    public HeapSort(T[] data)
    {
        super(data);
    }
    
    public void sort()
    {
        // First converts the data into a heap
        heapify(this.data);
        // Node does the sorting
        performSort(this.data);
    }
    
    private void heapify(Comparable[] data)
    {
        /* Insertion onto heap */
        for (int heapsize = 0; heapsize < data.length; heapsize++) 
        {
            /* Step one in adding an element to the heap in the
             * place that element at the end of the heap array-
             * in this case, the element is already there. */
            int n = heapsize;
            
            while ( n > 0 ) 
            { 
                // the index of the parent of n
                int parentIndex = (n - 1) / 2; 
                
                int compareValue = compareValue(data[n], data[parentIndex]);
                
                if ( compareValue > 0 ) { 
                    // child is larger than parent
                    arraySwap(data, n, parentIndex);
                    n = parentIndex;
                } else
                {
                    break;
                }
            }
        }
    }

    private void arraySwap(Comparable[] data, int childIndex, int parentIndex)
    {
        Comparable parentTemp = data[parentIndex];
        Comparable childTemp = data[childIndex];
        data[parentIndex] = childTemp;
        data[childIndex] = parentTemp;
    }
    
    private void performSort(Comparable[] array)
    {
        
        for (int heapsize = array.length; heapsize > 0;) 
        {
            // swap root with the last heap element
            arraySwap(array, 0, --heapsize);
            
            // index of the element being moved down the tree
            int n = 0; 
            while (true) 
            {
                int left = (n * 2) + 1;
                
                // No Left Child
                if (left >= heapsize)
                {
                    break;
                }
                int right = left + 1;
                
                // Node with Left Child but not Right Child
                if (right >= heapsize) 
                {
                    // Left Childe > Node
                    if (compareValue(array[left], array[n]) > 0 )
                    {
                        // Swaps left with Node
                        arraySwap(array, left, n); 
                    }
                    
                    break; 
                }
                // Left is > N
                if (compareValue(array[left],array[n]) > 0) 
                { 
                    // Left is > Right and > n
                    if (compareValue(array[left],array[right]) > 0 ) 
                    {
                        arraySwap(array, left, n);
                        
                        n = left;
                        
                        // Next left child
                        continue; 
                        
                    } 
                    else 
                    { 
                        // Right > Left and Left > n
                        arraySwap(array, right, n);
                        n = right;
                        
                        // Next right child
                        continue;
                    }
                } else 
                { 
                    // Node > Left
                    if (compareValue(array[right],array[n]) > 0 ) 
                    {
                        // Right >  n and > Left
                        arraySwap(array, right, n);
                        n = right;
                        
                        // Next right child
                        continue;
                    } else 
                    {   
                        // n > Left and n > Right ( Node is greater than 
                        // children)
                        break; 
                    }
                }
            }
        }
    }
    
    public String name()
    {
        return "HeapSort";
    }

}
