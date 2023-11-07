import java.io.*;
import java.util.*;
class B1 {
 
     static {
         System.loadLibrary("B1");
     }

     private native int add(int a, int b);
     private native int sub(int a, int b);
     private native int mult(int a, int b);
     private native int div(int a, int b);
 
     public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int a, b,ch;
	System.out.println("\nEnter value of a : ");
	a = sc.nextInt();
	System.out.println("\nEnter value of b : ");
	b = sc.nextInt();
	do{
		System.out.println("\nENTER YOUR CHOICE : ");
		ch = sc.nextInt();
		
		switch(ch){
			case 1 : new B1().add(a,b);
				 break;

			case 2 : new B1().sub(a,b);
				 break;

			case 3 : new B1().mult(a,b);
				 break;

			case 4 : new B1().div(a,b);
				 break;

			default : System.out.println("Your choice is wrong.");
		}
	}while(ch<5);
     }
 }
