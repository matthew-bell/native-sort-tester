public class QuickSort
{
  public static int comparisons = 0;
  public static long startTime, endTime;
  public static <T extends Comparable<T>> void swap(T[] a, int i, int j)
  {
    T temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
  public static <T extends Comparable<T>> int partition(T[] a, int lo, int hi) 
  {
    int i = lo, j = hi + 1;
    T el = a[lo];
    while (true) { 
      while (a[++i].compareTo(el) > 0){
        comparisons++;
        if (i == hi){
          comparisons++;
          break;}
        comparisons++;
      }
      while (el.compareTo(a[--j]) > 0){
        comparisons++;
        if (j == lo){
          comparisons++;
          break;}
        comparisons++;
      }
      if (i >= j){
        comparisons++;
        break;}
      comparisons++;
      swap(a, i, j);
    }
    swap(a, lo, j);
    return j;
  }
  
  public static <T extends Comparable<T>> void sort(T[] a)
  {
    sort(a, 0, a.length-1);
    System.out.println("Number of Comparisons: "+comparisons);
  }
  public static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) 
  { 
    long startTime = System.currentTimeMillis();
    if (hi <= lo) {
      comparisons++;
      return;}
    else{
      comparisons++;
      int j = partition(a, lo, hi);
      sort(a, lo, j-1);
      sort(a, j+1, hi);
    }
  }
}
  

  
  //heapQueue:
  

