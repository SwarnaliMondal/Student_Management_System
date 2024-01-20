package com.test.repository;

import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.test.entity.Teacher;

public class TeacherRepository {
private final EntityManager em;
	
	public TeacherRepository(final EntityManager em) {
		this.em=em;
	}
	public Teacher save(final Teacher teacher) {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			
			if(!tx.isActive()) {
				tx.begin();
			}
			
			em.persist(teacher);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return teacher;
	}
	
	

}
