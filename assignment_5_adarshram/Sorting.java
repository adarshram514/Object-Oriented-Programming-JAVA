import java.util.Arrays;
public class ArraySortTestDriver {
public static void main(String[] args) {

int n = 10;
boolean bubbleFail = false;
boolean mergeFail = false;

    do {
        double[] firstArray = SortUtil.getArrayOfDouble(n);
        if (firstArray != null && firstArray.length > 0) {
        double[] secondArray = new double[n];

        secondArray = Arrays.copyOf(firstArray, firstArray.length);
    try {
        SortUtil.bubbleSort(secondArray);
        
        
    }
    
    catch(RuntimeException runTimeExec) {

        bubbleFail=true;

        System.out.println(runTimeExec.getMessage());

    }

    catch (OutOfMemoryError E) {

        bubbleFail=true;

        System.out.println("OutOfMemoryError occurred in Bubble Sort for Array Length ="+n);

    }

    try {

        SortUtil.doMergeSort(firstArray);

        }

        catch(RuntimeException runTimeExec){

            System.out.println(runTimeExec.getMessage());
            mergeFail=true;

        }

        catch (OutOfMemoryError E) {

            System.out.println("OutOfMemoryError occurred in Merge Sort for Array Length ="+n);
            mergeFail=true;

    }

    if(mergeFail && bubbleFail){
        break;

    }

}

System.out.println("********** next iteration********");

n = n * 10;

} while (n !=-1);

System.out.println("********** Execution stopped at arrayLength= "+n);

}

}

package solution.sorttime;
import java.util.Date;
import java.util.Random;
import com.sun.jmx.snmp.Timestamp;

public class SortUtil {

    public static void doMergeSort(double[] sourceArray) {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    System.out.println("Merge sort starts at=>" + timestamp);
    long startTime = System.currentTimeMillis();

    mergeSortImpl(sourceArray,startTime);
    Timestamp endTimestamp = new Timestamp(System.currentTimeMillis());

    System.out.println("Merge sort Ends at=>" + endTimestamp);

    }

    public static void mergeSortImpl(double[] sourceArray, long startTime) {
        final long start =startTime;
        long now = System.currentTimeMillis();

    if ((now - start) / 1000.0 > 20) {
        System.out.println("Merge Sort Execution taking more than 20 seconds. Suspending------");
        throw new RuntimeException("Execution time elapsed in Merge Sort");

    }

    int size = sourceArray.length;

        if (size < 2)

        return;

    int mid = size / 2;
    int leftSize = mid;
    int rightSize = size - mid;
    double[] left = new double[leftSize];
    double[] right = new double[rightSize];
    for (int i = 0; i < mid; i++) {
        left[i] = sourceArray[i];

    }
    
    for (int i = mid; i < size; i++) {
        right[i - mid] = sourceArray[i];

    }

    mergeSortImpl(left,startTime);
    mergeSortImpl(right,startTime);
    merge(left, right, sourceArray);
    
    }

    public static void merge(double[] left, double[] right, double[] argArray) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
            argArray[k] = left[i];
            i++;
            k++;

    } else {

        argArray[k] = right[j];
            k++;
            j++;

        }

    }

        while (i < leftSize) {
            argArray[k] = left[i];
            k++;
            i++;
    
            
        }

            while (j < leftSize) {
                argArray[k] = right[j];
                k++;
                j++;

            }

        }

        static void bubbleSort(double[] arr) throws RuntimeException {
            int n = arr.length;
            long startTime = System.currentTimeMillis();

            System.out.println("Bubble sort starts at=>" + new Date().toString());
            double temp = 0;
            for (int i = 0; i < n; i++) {
    
            for (int j = 1; j < (n - i); j++) {

            if (arr[j - 1] > arr[j]) {
                temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;

        }

        long now = System.currentTimeMillis();
        if ((now - startTime) / 1000.0 > 20) {

        System.out.println("Bubble Sort Execution taking more than 20 seconds. Suspending------");

        throw new RuntimeException("Execution time elapsed in Bubble Sort");

        }

    }

}

Date endTime = new Date();

System.out.println("Bubble sort Ends at =>" + endTime.toString());

}

public static double[] getArrayOfDouble(int length) {

    double[] anArray = null;
    if (length > 0) {
        anArray = new double[length];
        Random rand = new Random();

        for (int i = 0; i < anArray.length; i++) {
        double randomNum = rand.nextDouble();
            anArray[i] = randomNum;
            
            
            }

        }

    return anArray;

    }

}