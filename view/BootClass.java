package com.flp.pms.view;

import java.util.Scanner;

import com.flp.pms.domain.Product;
import com.flp.pms.service.IProductService;
import com.flp.pms.service.ProductServiceImpl;

public class BootClass {

	public static void main(String[] args) {
		menuSelection();

	}
	
	public static void menuSelection(){
		int option;
		Scanner sc=new Scanner(System.in);
		UserInteraction userInteraction=new UserInteraction();
		IProductService iProductService=new ProductServiceImpl();
		
		System.out.println("1.Create Product"+
				"\n2.Modify Product"+
				"\n3.Remove Product"+
				"\n4.View All Product"+
				"\n5.Search Product"+
				"\n6.Exit");
		System.out.println("Enter your option:");
		option=sc.nextInt();
		
		switch(option){
			case 1:
				Product product=userInteraction.addProduct(iProductService.getAllCategory(),
						iProductService.getAllSubCategory());
				
				System.out.println(product);
				
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				System.out.println("1.By Name"+
							"\n2.By Supplier/Producer"+
							"\n3.By Category"+
							"\n4.By SubCategory"+
							"\n5.By Ratings");
				
				
				break;
			case 6:
				System.exit(0);
		}
		
		
	}
	
	
	
	

}
