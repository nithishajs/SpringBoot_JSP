package com.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.model.Library;
import com.jsp.repo.LibraryRepo;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	LibraryRepo lrepo;

	@Override
	public String addBook(Library l1) {
		boolean Status = lrepo.existsById(l1.getId());
				
		if(Status == false) {
			lrepo.save(l1);
			return "Book Added Successfully";
		}else {
			return "Book ALready Exist";
		}
		
	}

	@Override
	public Iterable<Library> listBooks() {
		
		return lrepo.findAll();
	}

	@Override
	public Library listById(int id) {
		Optional<Library> op = lrepo.findById(id);
		
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
		
	}

	@Override
	public String updateBook(Library l1) {
		// TODO Auto-generated method stub
		Optional<Library> op = lrepo.findById(l1.getId());
		
		if(op.isPresent()) {
			lrepo.save(l1);
			return "Book Updated SuccessFully";
		}else {
			return "Book Not Found";
		}
		
		
	}

	@Override
	public String deleteBook(int id) {
		// TODO Auto-generated method stub
		Optional<Library> op = lrepo.findById(id);
		
		if(op.isPresent()) {
			lrepo.deleteById(id);
			return "Book deleted";
		}else {
			return "Book Not Found";
		}
		
	}

}
