package com.ninja_squad.geektic.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.entity.Log;

@Repository
public class LogDao {
	
	@PersistenceContext
	private EntityManager em;

	public void persist(Log log) {
		em.persist(log);
	}	
	
}
