import java.util.Scanner;

public class student {
    int[] marks = new int[5];
     static Scanner ip = new Scanner(System.in);
     public student(int[] arr){
         for(int i=0;i<5;i++){
             marks[i] = arr[i];
         }
     }
    public static void main(String[] args) {
        int[] marks = new int[5];
        for (int i = 0; i < 5; i++) {
            try {
                marks[i] = ip.nextInt();
                if (marks[i] < 0) {
                    throw new Exception("NegativeMarksException");
                }
                if (marks[i] > 100) {
                    throw new Exception("OutofRangeException");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        student student_1 = new student(marks);
        try{
            int i = ip.nextInt();
            if(i>4){
                throw new ArrayIndexOutOfBoundsException();
            }
            int mark = student_1.marks[i];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
}
