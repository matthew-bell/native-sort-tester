import java.util.ArrayList;

public class HeapQueue<Key extends Comparable<Key>>
{
  public static int comparisons = 0;
  private ArrayList<Key> pq;
  private int n = 0;  
  
  public HeapQueue(int cap) 
  {
    pq = new ArrayList<Key>(cap + 1);
    pq.add(null);
  }
  
  public HeapQueue(Key[] keys) 
  {
    this(keys.length);
    n = keys.length;
    for (int i = 0; i < n; i++) pq.add(keys[i]);
    for (int k = n/2; k >= 1; k--) sink(k);
  }
  
  private void swim(int k) 
  {
    Key x = pq.get(k);
    while (k > 1 && pq.get(k/2).compareTo(x) < 0) {
      comparisons++;
      pq.set(k, pq.get(k/2));
      k = k/2;
    }
    pq.set(k, x);
  }
  private void sink(int k) {
    Key x = pq.get(k);
    while (2*k <= n) {
      comparisons++; //checking the key against n
      int j = 2*k;
      if (j<n){
        comparisons++;
        if(pq.get(j).compareTo(pq.get(j+1))<0){
          comparisons++;
          j++;
        }
      }
      if (x.compareTo(pq.get(j)) >= 0){
        comparisons++;
        break;
      }
      pq.set(k, pq.get(j));
      k = j;
    }
    pq.set(k, x);
  }
 
  
  public void insert(Key x) {
    n++;
    pq.add(x);
    swim(n);
  }
  public Key delMax() {
    Key max = pq.get(1);
    swap(pq, 1, n--);
    sink(1);
    pq.remove(n+1);
    return max;
  }  
  
  public static <K extends Comparable<K>> void swap(ArrayList<K> a, int i, int j)
  {
    K temp = a.get(i);
    a.set(i, a.get(j));
    a.set(j, temp);
  }
  
  public static void getComps(){
    System.out.println("Total array comparisons: "+comparisons);
  }
}

