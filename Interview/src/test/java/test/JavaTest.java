package test;

import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaTest {
    public static String name(String text,String text1){
        return text.toUpperCase() + text1.toLowerCase();
    }
    //Create a Method to Sum 2 Numbers and Return the Ouput
    public int numbers(int num1,int num2){
        return num1+num2;
    }
   // Create a Method to Divide 2 numbers and return reminder
    public int divide(int num1,int num2){
        return num1%num2;
    }
    //Create a Method to remove Special Charachters from input String
    public  String specialchar(String input){
        return input.replaceAll("[^a-zA-Z0-9]","");
    }
    //Create a Method to check if input String is Plalindrome or Not and return true or false if true print is Plalindrome
    public boolean palidrome(String input){
        StringBuilder builder=new StringBuilder(input);
        if(input.equalsIgnoreCase(builder.reverse().toString())){
            return true;
        }else{
            return false;
        }
    }
    //Create a Method to Split the Input String using split input as second arguent and return output array
    public String [] splitarray(String input,String in ){
        String[] temp=input.split(in);
        //temp
           return temp;
       }

       //Write a method to remove , from input string
    public String comma(String input){
        return input.replace(",","");
    }


    public static void main(String[] args) {
        JavaTest javaTest=new JavaTest();
       /* System.out.println(  javaTest.name("capggemini","accenture"));
        System.out.println("sum = " + javaTest.numbers(10,20));
        System.out.println("divide = " + javaTest.divide(20,20));
        System.out.println(javaTest.specialchar("shsshasf12jkhshdjk%$#$^hhd"));
        System.out.println("palidrome example = " +javaTest.palidrome("noon"));
        //input=samruddhi,surawanshi,automation inpu2=,
        String [] output=javaTest.splitarray("samruddhi surawansh automation"," ");
        System.out.println("comma = " + javaTest.comma("sassg,ss"));
*/
        //numbers methods - 10,90 =100
        //save additonal in output int

        /*int additional=javaTest.numbers(10,90);
               System.out.println( javaTest.divide(additional,10));*/
        System.out.println(name("samru","damu"));
        System.out.println(name("sucess","AXIS"));
        //no need to change


    }
}
