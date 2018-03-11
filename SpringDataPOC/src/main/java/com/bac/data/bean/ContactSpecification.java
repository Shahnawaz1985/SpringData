package com.bac.data.bean;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class ContactSpecification {
	
	public static Specification<Contact> firstOrLastNameStartsWith(final String searchTerm){
		return new Specification<Contact>() {

			@Override
			public Predicate toPredicate(Root<Contact> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				String likePattern = getLikePattern(searchTerm);
				return cb.or(
						cb.like(cb.lower(root.<String>get(Contact_.firstName)), likePattern),
						cb.like(cb.lower(root.<String>get(Contact_.lastName)), likePattern));
				}
			
			private String getLikePattern(final String searchTerm) {
				return searchTerm.toLowerCase() + "%";
			}			
		};
	}
	
	

}
