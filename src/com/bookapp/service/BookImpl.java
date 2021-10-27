package com.bookapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public class BookImpl implements BookInter {

	List<Book> bookList=new ArrayList<>();

	public void addBook(Book book) {

		bookList.add(book);
		System.out.println(bookList.toString());
	}

	@Override
	public List<Book> getAllBooks() {
		Collections.sort(bookList, (book1, book2) -> {
			return book1.getTitle().compareTo(book2.getTitle());
		});
		System.out.println("Hi");
		System.out.println(bookList.toString());
		return bookList;

	}

	@Override
	public List<Book> getBookbyAuthor(String author ) throws AuthorNotFoundException {
		// TODO Auto-generated method stub

		List<Book> bookAuthor = new ArrayList<>();
		boolean isAuthorPresent = false;

		for (Book book : bookList) {

			if (author.toLowerCase().equals(book.getAuthor().toLowerCase())) {
				bookAuthor.add(book);
//				isAuthorPresent = true;
				System.out.println(book);
			}

		}

		if (!isAuthorPresent) {
			throw new AuthorNotFoundException("Author name not found");

		}

		return bookAuthor;
	}

	@Override
	public List<Book> getBookbycategory(String category) throws CategoryNotFoundException {
		
		List<Book> bookCategory = new ArrayList<>();

		boolean isCategoryPresent = false;

		
		for (Book book : bookList) {
			
			if ((category.toLowerCase()).equals((book.getCategory().toLowerCase()))) {
				bookCategory.add(book);
				isCategoryPresent = true;
				
				System.out.println(book);
			}

		}

		if (!isCategoryPresent)
			throw new CategoryNotFoundException("Category not found");

		return bookCategory;

	}

}
