package sort;

public class HeapSort<T extends Comparable> 
{
    public HeapSort()
    {
    }
    
    public void sort(T[] data)
    {
        heapify(data);
        performSort(data);
    }
    
    private void heapify(T[] data)
    {
        /* Insertion onto heap */
        for (int heapsize = 0; heapsize < data.length; heapsize++) {
            /* Step one in adding an element to the heap in the
             * place that element at the end of the heap array-
             * in this case, the element is already there. */
            int n = heapsize; // the index of the inserted int
            while ( n > 0 ) { // until we reach the root of the heap
                int p = (n - 1) / 2; // the index of the parent of n
                
                int compareValue = compareValue(data[n], data[p]);
                
                if ( compareValue > 0 ) { // child is larger than parent
                    arraySwap(data, n, p); // swap child with parent
                    n = p; // check parent
                } else // parent is larger than child
                {
                    break; // all is good in the heap
                }
            }
        }
        
        
    }
    
    private int compareValue(Comparable one, Comparable two) {
        return one.compareTo(two);
    }
    
    private void arraySwap(T[] data, int childIndex, int parentIndex)
    {
        T parentTemp = data[parentIndex];
        T childTemp = data[childIndex];
        data[parentIndex] = childTemp;
        data[childIndex] = parentTemp;
    }
    
    private void performSort(T[] array)
    {
        /* Removal from heap */
        for (int heapsize = array.length; heapsize > 0;) {
            arraySwap(array, 0, --heapsize); // swap root with the last heap element
            int n = 0; // index of the element being moved down the tree
            while (true) {
                int left = (n * 2) + 1;
                if (left >= heapsize) // node has no left child
                {
                    break; // reached the bottom; heap is heapified
                }
                int right = left + 1;
                if (right >= heapsize) { // node has a left child, but no right child
                    
                    if (compareValue(array[left], array[n]) > 0 )// if left child is greater than node
                    {
                        arraySwap(array, left, n); // swap left child with node
                    }
                    break; // heap is heapified
                }
                if (compareValue(array[left],array[n]) > 0) { // (left > n)
                    
                    if (compareValue(array[left],array[right]) > 0 ) { // (left > right) & (left > n)
                        arraySwap(array, left, n);
                        n = left;
                        continue; // continue recursion on left child
                    } else { // (right > left > n)
                        arraySwap(array, right, n);
                        n = right;
                        continue; // continue recursion on right child
                    }
                } else { // (n > left)
                    if (compareValue(array[right],array[n]) > 0 ) { // (right > n > left)
                        arraySwap(array, right, n);
                        n = right;
                        continue; // continue recursion on right child
                    } else { // (n > left) & (n > right)
                        break; // node is greater than both children, so it's heapified
                    }
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
}
