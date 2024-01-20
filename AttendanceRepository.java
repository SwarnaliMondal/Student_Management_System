package com.test.repository;

import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.test.entity.Attendance;

public class AttendanceRepository {
private final EntityManager em;
	
	public AttendanceRepository(final EntityManager em) {
		this.em=em;
	}
	public Attendance save(final Attendance attendance) {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			
			if(!tx.isActive()) {
				tx.begin();
			}
			
			em.persist(attendance);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return attendance;
	}
	
	
}