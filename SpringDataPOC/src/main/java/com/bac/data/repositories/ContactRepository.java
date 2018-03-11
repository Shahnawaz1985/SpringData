package com.bac.data.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import com.bac.data.bean.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>,
							JpaSpecificationExecutor<Contact>{
	
	Contact findByLastNameAndFirstName(String lastName, String firstName);
	
}
