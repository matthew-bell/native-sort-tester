import java.util.Random;

public class SortDemo
{
  public static long startTime = System.currentTimeMillis();
  public static void main(String[] args)
  {
    Integer[] nums = new Integer[100000];
    Random picker = new Random();
    for(int i=0; i<nums.length; i++){
      nums[i] = picker.nextInt(2147483647);
    }
    Integer[] temp = nums.clone();
    long startQuick = System.currentTimeMillis();
    QuickSort.sort(nums);
    System.out.print("25 largest numbers are: ");
    for(int j=0; j<25; j++){
      System.out.print(nums[j]+", ");
    }
    long endQuick = System.currentTimeMillis();
    System.out.println();
    System.out.println("Runtime in milliseconds: "+(endQuick-startQuick));
    nums = temp;
    System.out.println();
    
    long startHeap = System.currentTimeMillis();
    HeapQueue maxHeap = new HeapQueue(nums);
    System.out.print("25 largest numbers are: ");
    for(int j=0; j<25; j++){
      System.out.print(maxHeap.delMax()+", ");
    }
    long endHeap = System.currentTimeMillis();
    System.out.println();
    maxHeap.getComps();
    System.out.println("Runtime in milliseconds: "+(endHeap-startHeap));
    nums=temp;
  }
}


  