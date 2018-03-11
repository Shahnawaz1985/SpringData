package com.bac.data.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bac.data.bean.Contact;
import com.bac.data.bean.ContactSpecification;
import com.bac.data.repositories.ContactRepository;

@Service("japContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
	Logger logger = Logger.getLogger(ContactServiceImpl.class);
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		return (List<Contact>) contactRepository.findAll();
	}

	@Override
	public Contact findById(Long id) {
		return null;
	}

	@Override
	public Contact save(Contact contact) {
		logger.info("Inside save method");
		Contact cntct =  contactRepository.save(contact);
		logger.info("After save() call :"+cntct.getId());
		return cntct;
	}

	@Override
	@Transactional(propagation = Propagation.NEVER)
	public long countAll() {
		return contactRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Contact search(String lastName, String firstName) {
		return contactRepository.findByLastNameAndFirstName(lastName, firstName);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contact> search(String searchTerm) {
		Specification<Contact> contactSpec = ContactSpecification.firstOrLastNameStartsWith(searchTerm);
		return contactRepository.findAll(contactSpec);		
	}
}
