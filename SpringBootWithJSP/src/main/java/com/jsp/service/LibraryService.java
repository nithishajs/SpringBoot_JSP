package com.jsp.service;

import java.util.List;

import com.jsp.model.Library;

public interface LibraryService {
	
	public String addBook(Library l1);
	
	public Iterable<Library> listBooks();
	
	public Library listById(int id);
	
	public String updateBook(Library l1);
	
	public String deleteBook(int id);

}
