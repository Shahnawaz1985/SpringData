package com.bac.data.driver;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bac.data.bean.Contact;
import com.bac.data.config.ApplicationConfig;
import com.bac.data.config.JPAConfiguration;
import com.bac.data.service.ContactService;


public class TestDriver {
	
	public static void main(String[] args) {
		Logger LOGGER = Logger.getLogger(TestDriver.class);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
							new Class[]{ApplicationConfig.class, JPAConfiguration.class});
		System.out.println("Bean Name: "+Arrays.deepToString(ctx.getBeanDefinitionNames()));
		ContactService contactService = ctx.getBean("japContactService", ContactService.class);
		List<Contact> availableContacts = contactService.findAll();
		Long count = contactService.countAll();
		LOGGER.info("Available Contacts :"+availableContacts);
		System.out.println(availableContacts);
		LOGGER.info("Total Available Contacts :"+count);
		System.out.println("Total Contacts :"+count);
		
		Contact newContact = new Contact();
		newContact.setId(6l);
		newContact.setFirstName("Shahnawaz");
		newContact.setLastName("Akhtar1");
		newContact.setBirthDate(new Date());
		newContact.setVersion(1);
		
		newContact = contactService.save(newContact);
		System.out.println("New Contact saved with id:"+newContact.getId());
		
		String lastName = "Tiger";
		String firstName = "Scott";
		
		Contact searchedContact = contactService.search(lastName, firstName);
		System.out.println("Searched Contact :"+searchedContact);
		LOGGER.info("Searched Contact :"+searchedContact);
		
		List<Contact> searchedContacts = contactService.search("S");
		System.out.println("Searched Contact List :"+searchedContacts);
		LOGGER.info("Searched Contact List :"+searchedContacts);
		ctx.close();
	}
}
