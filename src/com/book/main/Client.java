package com.book.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;
import com.bookapp.service.BookImpl;
import com.bookapp.service.BookInter;
import java.util.Scanner;

public class Client {
	

	@SuppressWarnings("null")
	public static void main(String[] args) {
		BookInter bookInter = new BookImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome.... to read your favourite book");
		
	   
		 List<Book> bookList = new ArrayList<>(); 
		 
		while (true) {
			System.out.println();
			System.out.println("Choose which Author(a) / Category(c) /  books you want to read");
			System.out.println("Choose (e) to exit");
			System.out.println("Choose (g) to get all the books available ");
			System.out.println("Choose(add) to add a book into list");
			String choice = sc.next();

			switch (choice) {
			case ("g"):
				
				System.out.println(bookList);
				
				break;
			case ("add"):
				for (int i = 1; i < 2; i++) {
					System.out.println("Enter book title");
					String bookTitle = sc.next();
					System.out.println("Enter book author");
					String authorName = sc.next();
					System.out.println("Enter book category");
					String bookCategory = sc.next();
					System.out.println("Enter book price");
					int price = sc.nextInt();
					int id=bookList.size();
					Book book = new Book(bookTitle, authorName, bookCategory, price, id);
					bookList.add(book);
					bookInter.addBook(book);
					
				}
				break;
			case "a":
				
				System.out.println("Enter Auther Name");
				String authorName = sc.next();
				try {
					List<Book> bookList1=(List<Book>) bookList;
					bookInter.getBookbyAuthor(authorName);

				} catch (AuthorNotFoundException e) {
					System.out.println(e.getMessage());

				}
				break;
			case "c":
				
				System.out.println("Enter Book Category");
				String bookCategory = sc.next();
				try {
					List<Book> bookList2=(List<Book>) bookList;
					bookInter.getBookbycategory(bookCategory);

				} catch (CategoryNotFoundException e) {
					System.out.println(e.getMessage());

				}
				break;
			case "e":
				System.out.println("Thank you please visit again");
				System.exit(10);

			default  :
				System.out.println("Exited");
				System.exit(10);
				System.out.println("Thank you please visit again");
				
				

			}
		}
		
		 

	}

}
