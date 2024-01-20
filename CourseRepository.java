package com.test.repository;

import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.test.entity.Course;

public class CourseRepository {
private final EntityManager em;
	
	public CourseRepository(final EntityManager em) {
		this.em=em;
	}
	public Course save(final Course course) {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			
			if(!tx.isActive()) {
				tx.begin();
			}
			
			em.persist(course);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return course;
	}
	
	
}