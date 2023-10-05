package com.jsp.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jsp.model.*;
public interface LibraryRepo extends CrudRepository<Library,Integer> {
	
	public List<Library> findByName(String name);

}
