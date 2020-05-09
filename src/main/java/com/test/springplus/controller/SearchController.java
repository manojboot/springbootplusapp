package com.test.springplus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.springplus.model.Product;
import com.test.springplus.repository.ProductRepository;

@Controller
public class SearchController {
	
		@Autowired
		ProductRepository productRepository;
	
	/*	@GetMapping("/search")
		public String search(@RequestParam("search") String search,Model model) {
			
			System.out.println("In searhc controller");
			System.out.println("Search Criteria:" +search);
			
			List<Product> products = new ArrayList<Product>();
			products = productRepository.searchByName(search);
			model.addAttribute("products", products);
			return "search";
		}	*/
		
		@GetMapping("/search")
		public Callable<String> search(@RequestParam("search") String search,Model model,HttpServletRequest request) {
			
			System.out.println("In searhc controller");
			System.out.println("Search Criteria:" +search);
			System.out.println(request.isAsyncSupported());
			System.out.println("Thread from Serverlet Container :" +Thread.currentThread().getName());
			
			return() ->{
				
				Thread.sleep(1000);
				System.out.println("Thread from Serverlet Container :" +Thread.currentThread().getName());

				List<Product> products = new ArrayList<Product>();
				products = productRepository.searchByName(search);
				model.addAttribute("products", products);
				return "search";
			};
			
			
		}


}
