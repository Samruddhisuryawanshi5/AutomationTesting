package test;

import org.testng.annotations.Test;

public class pratice {
     static int a=100;
   static int add(int b){
      a=a;
       return a+b;
  }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(add(20));
        a=200;
        System.out.println("New Line");
    }
    @Test
    public void testAdd(){
       pratice pratice = new pratice();
       pratice.testAdd();
    }
}
