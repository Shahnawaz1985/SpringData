package com.bac.data.service;

import java.util.List;

import com.bac.data.bean.Contact;

public interface ContactService {
	List<Contact> findAll();

	Contact findById(Long id);

	Contact save(Contact contact);

	long countAll();
	
	Contact search(String lastName, String firstName);
	
	List<Contact> search(String searchTerm);
}
