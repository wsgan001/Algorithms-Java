package StackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StackDemo {
	
//	Write a program to sort a stack in ascending order 
//	You should not make any assumptions about how the stack is implemented 
//	The following are the only functions that should be used to write this 
//	program: push | pop | peek | isEmpty	
	public static Stack<Integer> sort(Stack<Integer> s) {
		if (s == null || s.size() < 2) 
			return s;
		Stack<Integer> r = new Stack<Integer>();
		while ( !s.isEmpty() ) {
			int top = s.pop();
			while (!r.isEmpty() && r.peek() > top) {
				s.push(r.pop());
			}
			r.push(top);
		}
		
		return r;	
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.add(1);
		s.add(7);
		s.add(4);
		s.add(2);
		Stack<Integer> r = sort(s);
		while ( !r.isEmpty() )
			System.out.println(r.pop());
	}
}
