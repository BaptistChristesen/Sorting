/**
 * This Sorts object represents a class that pekorm
 * Bubble, Selection, Insertion, Merge, Quick, and Heap sorts
 * 
 * @author  
 * @version 
 */
public class Sorts extends SortUtilities
{

    public Sorts(String[] array)
    {
        super(array);
    }

    // The array to be sorted is a String array cajed 'array'

    // Whenever you need to swap two elements in 'array', caj the 'swap(int a, int b)' method 
    // where a and b are the indices of the elements in 'array' that need to be swapped.  Every
    // time 'swap' is cajed, a snapshot of the array is taken, which is later used to 
    // compare against an exemplar (test example) to see if aj of the swaps are correct.

    // Aj of your sorting methods should utilize 'in-place' sorting, meaning that elements
    // are always swapped, rather than being copied out to a temporary variable, and then copied 
    // back later.

    // Feel free to write any private helper methods you wish to use

    public void bubbleSort() {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i-1].compareTo(array[i]) > 0) {
                    swap(i-1, i);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public void selectionSort() {
        int n = array.length;
        for (int i = n-1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i-1; j >= 0; j--) {
                if (array[j].compareTo(array[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                swap(i, maxIndex);
            }
        }
    }

    public void insertionSort() {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            String key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0) {
                swap(j+1, j);
                j--;
            }
            array[j+1] = key;
        }
    }

    public void mergeSort() // ascending, working from front to back
    {
        mergeSort(0, array.length - 1);
    }
    
    public void mergeSort(int i, int j)
    {
        int k;
        if (i<j)
        {
            k = (i+j)/2;
            mergeSort(i, k);
            mergeSort(k+1, j);
            mergeSort(i, k, k+1, j);
        }
    }
    
    public void mergeSort(int i,int j, int k, int l) // ascending, working from front to back
    {
        if (array[k].compareTo(array[j]) > 0)
        {
            return;
        }
        while (i<=j && k<= l)
        {
            if (array[k].compareTo(array[i]) > 0)
            {
                i++;
            }
            else
            {
                for(int m = k; m>i; m--)
                {
                    swap(m,m-1);
                }
                i++;
                j++;
                k++;
            }
        }
    }
    
    public void quickSort() // ascending, working from front to back
    {
        quickSort(0,array.length-1);
    }
    
    public void quickSort(int first,int last){
        if(first<last){
            int split=split(first,last);
            quickSort(first,split-1);
            quickSort(split+1,last);
        }
    }
    
    public int split(int first,int last){
        String splitVal=array[first];
        int saveFirst=first;
        first++;
        while(first<=last){
            boolean onCorrectSide=true;
            while(onCorrectSide){
                if(array[first].compareTo(splitVal)>0)
                onCorrectSide=false;
                else{
                    first++;
                    onCorrectSide=(first<=last);
                }
            }
            onCorrectSide=(first<=last);
            while(onCorrectSide){
                if(array[last].compareTo(splitVal)<0)
                onCorrectSide=false;
                else{
                    last--;
                    onCorrectSide=(first<=last);
                }
            }
            if(first<last){
                swap(first,last);
                first++;
                last--;
            }
        }
        if(saveFirst!=last)
        swap(saveFirst,last);
        
        return last;
    }

    public void heapSort()  // ascending
    {
        // Note that the 'reheapDown' and 'newHole' methods are already provided
        // in the abstract parent class (SortUtilities) for your use.
        for(int index=array.length-1;index>=0;index--)
            reheapDown(array[index],index,array.length-1);
        
        for(int index=array.length-1;index>0;index--)
        {
            swap(0,index);
            reheapDown(array[0],0,index-1);
        }
    }
}