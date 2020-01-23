package com.future.service;

import org.springframework.stereotype.Service;

@Service
public class AddingService {

	private static int count = 0;
	
	public Integer firstAddition(int num1, int num2) {
		
		System.out.println("Execute adding method asynchronously - " + Thread.currentThread().getName());
		
		int sum = 0;
		
        for(int i=num1; i<num2; i++) {
			sum = sum+i;
		}
        count++;
        if(count < 2) {
        	 sum = sum/0;
        }
        
        //return sum;
        //throw new IllegalStateException();
        return sum;
	
	} 
	
}

