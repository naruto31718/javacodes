import java.util.*;

public class prac {
    public int size;
    public int[] a;
    public int f,l;
    public prac(int s){
       f=l=0;
       size=s+1;
       a = new int[size];
    }
    public  void enque(int e){

             try{
                 a[l]=e;
                 l+=1;
             }catch (Exception s){
                 System.out.println("Queue is full");
             }
    }
    public void deque(){
        try {
            System.out.println(a[f]);
            f+=1;
        }catch (Exception z){
            System.out.println("Queue is empty");
        }
    }

    public static void main(String[] args) {
        prac q=new prac(2);
        q.enque(10);
        q.enque(11);
        q.enque(12);
        q.deque();
        q.deque();
        q.deque();
        q.deque();
        q.enque(13);
        q.enque(13);
    }
}
