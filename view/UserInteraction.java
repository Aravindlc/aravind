package com.flp.pms.view;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.util.Validate;

public class UserInteraction {
	
	
	public Product addProduct(List<Category> categories,List<SubCategory> subCategories){
		Scanner sc=new Scanner(System.in);
		boolean flag=false;
		Product product=new Product();
		
		
		//prompt valid productName
		String productName;
		do{
			System.out.println("Enter ProductName:");
			productName=sc.nextLine();
			flag=Validate.isValidProductName(productName);
			if(!flag)
				System.out.println("* Invalid ProductName!");
		}while(!flag);
		product.setProductName(productName);
		
		
		System.out.println("Enter Product Description:");
		String description=sc.nextLine();
		product.setDescription(description); 
		
		
		//prompt ManufacturingDate
		String manufact_Date;
		do{
		System.out.println("Enter Manufacturing Date:[dd-MMM-yyyy]");
		manufact_Date=sc.next();
		flag=Validate.isValidDate(manufact_Date);
		if(!flag)
			System.out.println("* Invalid Date Format!");
		
		}while(!flag);
		product.setManufacturing_date(new Date(manufact_Date));
		
		
		
		
			//prompt ExpiryDate
				String expiry_Date;
				boolean ex_flag=false;
				
				//Check valid Expiry Date
				do{
					
					//Validate Date Format
					do{
					System.out.println("Enter Expiry Date:[dd-MMM-yyyy]");
					expiry_Date=sc.next();
					flag=Validate.isValidDate(expiry_Date);
					if(!flag)
						System.out.println("* Invalid Date Format!");
					
					}while(!flag);
				
					ex_flag=Validate.isValidExpiryDate(new Date(expiry_Date));
					
					if(!ex_flag)
						System.out.println("* Expiry Date must be future Date!");
				}while(!ex_flag);
				product.setExpiry_date(new Date(expiry_Date));
				
				
				//prompt Maximum Retail Price
				System.out.println("Enter Maximum Retail Price:");
				double price=sc.nextDouble();
				product.setMax_retail_price(price);
				
				//prompt Quantity
				int quantity=0;
				do{
				System.out.println("Enter Product Quantity:");
				quantity=sc.nextInt();
				flag=Validate.isValidQuantity(quantity);
				if(!flag)
						System.out.println("* Qunaity Should be positive integer!");
				}while(!flag);
				product.setQuantity(quantity);
				
				
				
				
				//prompt Ratings
				float ratings=0.0f;
				do{
				System.out.println("Enter Product Ratings:");
				ratings=sc.nextFloat();
				flag=Validate.isValidRatings(ratings);
				if(!flag)
						System.out.println("* Ratings Should be between 1.0 and 5.0!");
				}while(!flag);
				product.setRatings(ratings);
		
		
			//prompt valid category Details
			Category category=getCategory(categories);
			product.setCategory(category);
			
			
			//Prompt SubCategory Details
			SubCategory subCategory=getSubCategory(subCategories, category);
			product.setSubCategory(subCategory);
		
		
		
		return product;
	}
	
	
	public Category getCategory(List<Category> categories){
		//Choose Category
		Category category=null;
		boolean flag=false;
		
		Scanner sc=new Scanner(System.in);
		int choice;	
		
		do{
			System.out.println("Choose Catgeory Id:");
			for(Category category1:categories)
				System.out.println(category1.getCategory_Id() +"\t" +category1.getCategory_Name() +
						"\t"+category1.getDescription());
			choice=sc.nextInt();
			
			
			
			//Validate the Category
			for(Category category1:categories){
				if(choice==category1.getCategory_Id())
				{
					category=category1;
					flag=true;
					break;
				}
			}
			if(!flag)
				System.out.println("* Please choose Valid Category ID!");
		}while(!flag);
		
		return category;
	}
	
	
	
	
	//Choose Sub Category
	public SubCategory getSubCategory(List<SubCategory> categories,Category category){
		SubCategory subCategory=null;
		Scanner scanner=new Scanner(System.in);
		int option;
		boolean flag=false;
		
		do{
			System.out.println("Choose Product Sub Category:");
			for(SubCategory  subCategory2:categories){
				if(subCategory2.getCategory().getCategory_Id()==category.getCategory_Id())
					System.out.println(subCategory2.getSub_category_Id() + "\t" + subCategory2.getSub_category_Name());
					}
			option=scanner.nextInt();
			
			
			//Check Valid SubCategory
			for(SubCategory subCategory2:categories){
				if(option==subCategory2.getSub_category_Id())
					{
						subCategory=subCategory2;
						flag=true;
						break;
					}
			}
			
			if(!flag)
				System.out.println("* Please choose valid Sub category!");
		
		}while(!flag);
		
		
		return subCategory;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
