//James Panagis


package sorting;
import java.util.*;
public class Sort4 {
//Implemented the sub trees (the left and right child)


public static int left (int i) {
int left = 2*i + 1;
return left;
}
public static int right (int i) {
int right = 2*i + 2;
return right;
}
public static int parent (int i) {
int parent = i/2;
return parent;

}
public static int[] max_heapify (int[] array, int heap_size, int i) {
//the heapify affects the subtree by seeing which is the larggest and then create a tree  
int largest = i;

int l = left(i);

int r = right(i);

if (l < heap_size && array[l] > array[largest])

largest = l;

if(r < heap_size && array[r] > array[largest])

largest = r;

if(largest != i)

{

int swap = array[i];

array[i]= array[largest];

array[largest] = swap;

max_heapify(array, heap_size, largest);

}
return array;
}
public static int[] build_heap (int[] array) {
//the build heap converts the array into a heap until the largest integer is at the root

int n = array.length;

for (int i= n / 2-1; i >= 0; i--)

max_heapify(array, n, i);

return array;


}
public static int[] heap_sort (int[] array) {
//implemented the heap sort that connects the all the objects

array = build_heap(array);

int n = array.length;

for (int i=n-1; i>=0; i--)

{

int temp = array[0];

array[0] = array[i];

array[i] = temp;

max_heapify(array, i, 0);

}

return array;


}
public static int[] quick_sort (int[] array, int p, int r) {
//Implemented quick sort

if (p < r) {
int q = partition(array, p, r);
quick_sort(array, p, q - 1);
quick_sort(array, q + 1, r);
}
return array;
}

public static int partition (int[] array, int p, int r) {
//implemented the pivot value and array values for the index to move to least to greatest positions

int x = array[r]; 
int i = p - 1; 


for (int j = p; j < r; j++) {
if (array[j] <= x) {
i++;

int temp = array[i];
array[i] = array[j];
array[j] = temp;
}
}
int temp = array[i + 1];
array[i + 1] = array[r];
array[r] = temp;


return i + 1;
}




public static int[] counting_sort (int[] array, int k) {
//Implemented counting sort, which picks a value if it greater or less than the integer

int [] b = new int [array.length];
int [] c = new int [k + 1];


for (int j = 0; j < array.length; j++) {
c[array[j]] = c[array[j]] + 1;
}

for (int i = 1; i <= k; i++) {
c[i] = c[i] + c[i - 1];
}


for (int j = array.length - 1; j >= 0 ; j--) {
b[c[array[j]] - 1] = array[j];
c[array[j]] = c[array[j]] - 1;
}
return b;


}
public static int[] generate_random_array (int n, int k) {
List<Integer> list;
int[] array;
Random rnd;
rnd = new Random(System.currentTimeMillis());
list = new ArrayList<Integer> ();
for (int i = 1; i <= n; i++) 
list.add(new Integer(rnd.nextInt(k+1)));
Collections.shuffle(list, rnd);
array = new int[n];
for (int i = 0; i < n; i++) 
array[i] = list.get(i).intValue();
return array;
} 
public static int[] generate_random_array (int n) {
List<Integer> list;
int[] array;
list = new ArrayList<Integer> ();
for (int i = 1; i <= n; i++) 
list.add(new Integer(i));
Collections.shuffle(list, new Random(System.currentTimeMillis()));
array = new int[n];
for (int i = 0; i < n; i++) 
array[i] = list.get(i).intValue();
return array;
}
/*
 * Input: an integer array
 * Output: true if the array is acsendingly sorted, otherwise return false
 */
public static boolean check_sorted (int[] array) {
for (int i = 1; i < array.length; i++) {
if (array[i-1] > array[i])
return false;
}
return true;
}
public static void print_array (int[] array) {
for (int i = 0; i < array.length; i++)
System.out.print(array[i] + ", ");
System.out.println();
}
public static void main(String[] args) {
// TODO Auto-generated method stub
int k = 10000;
System.out.println("Heap sort starts ------------------");
for (int n = 100000; n <= 1000000; n=n+100000) {
int[] array = Sort2.generate_random_array(n);
long t1 = System.currentTimeMillis();
array = Sort4.heap_sort(array);
long t2 = System.currentTimeMillis();
long t = t2 - t1;
boolean flag = Sort2.check_sorted(array);
System.out.println(n + "," + t + "," + flag);
}
System.out.println("Heap sort ends ------------------");
System.out.println("Quick sort starts ------------------");
for (int n = 100000; n <= 1000000; n=n+100000) {
int[] array = Sort2.generate_random_array(n);
long t1 = System.currentTimeMillis();
array = Sort4.quick_sort(array, 0, n-1);
long t2 = System.currentTimeMillis();
long t = t2 - t1;
boolean flag = Sort2.check_sorted(array);
System.out.println(n + "," + t + "," + flag);
}
System.out.println("Quick sort ends ------------------");
System.out.println("Counting sort starts ------------------");
for (int n = 100000; n <= 1000000; n=n+100000) {
int[] array = Sort2.generate_random_array(n, k);
long t1 = System.currentTimeMillis();
array = Sort4.counting_sort(array, k);
long t2 = System.currentTimeMillis();
long t = t2 - t1;
boolean flag = Sort2.check_sorted(array);
System.out.println(n + "," + t + "," + flag);
}
System.out.println("Counting sort ends ------------------");
}
}