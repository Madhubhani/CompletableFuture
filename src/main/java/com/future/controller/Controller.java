package com.future.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.future.service.AddingService;

@RestController
public class Controller {

	@Autowired
	private AddingService addingService;
		
	@RequestMapping("/sample")
	public Object ask() {
		//Double s = addingService.firstAddition();
		
		final CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(()->{
			System.out.println("Execute first method asynchronously - " + Thread.currentThread().getName());
				return addingService.firstAddition(1001, 2000);
			
		}).exceptionally(e -> {
            System.out.println(e.getMessage());
            return null;
		});
		
		final CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
			System.out.println("Execute second method asynchronously - " + Thread.currentThread().getName());
			return addingService.firstAddition(2001, 300000000);
		
	}).exceptionally(e -> {
        System.out.println(e.getMessage());
        return null;
	});
		return CompletableFuture.anyOf(completableFuture1, completableFuture2);
	}
	
}
