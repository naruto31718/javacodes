import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class Student{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

public class A {
    private int id;
    private int age;
    private String branch;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    public A(int i,int a,String b){
        this.age=a;
        this.id=i;
        this.branch = b;
    }

    public String toString(){
        return "The A here is "+this.age+" years old and has an id "+this.id+" and branch is "+this.branch;
    }

    public static void main(String[] args) throws IOException {
       A obj = new A(1001,12,"computers");
        System.out.println(obj);
    }
}
