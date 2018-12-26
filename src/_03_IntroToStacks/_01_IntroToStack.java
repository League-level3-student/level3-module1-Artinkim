package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		Stack<Double> sk = new Stack<Double>();
		Random rand = new Random();
		//   Don't forget to import the Stack class
		
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for(int i = 0;i<100;i++) {
			sk.push(rand.nextDouble()*100);
		}
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		String answer = JOptionPane.showInputDialog("Enter a number between 0 and 100");
		String answer2 = JOptionPane.showInputDialog("Enter another number between 0 and 100");
		int num = Integer.parseInt(answer);
		int num2 = Integer.parseInt(answer2);
		if(num<num2) {
			int temp = num2;
			num2 = num;
			num = temp;
			
		}
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		double t = 0;
		for(int i = 0; i < sk.size(); i++) {
			t = sk.pop();
			if(t<num && t>num2) {
				System.out.println(t);
			}
			
		}
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
