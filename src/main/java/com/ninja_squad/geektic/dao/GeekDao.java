package com.ninja_squad.geektic.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.entity.Geek;
import com.ninja_squad.geektic.entity.Interest;
import com.ninja_squad.geektic.entity.Sex;

@Repository
public class GeekDao {
	
	@PersistenceContext 
	private EntityManager em;

	public GeekDao() {
	}	
	
	public List<Geek> findAll(){
		String jpql = "select g from Geek as g";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		List<Geek> listeGeeks = query.getResultList();
		return listeGeeks;
	}
	
	public Geek findById(Long id) {
		return em.find(Geek.class, id);
	}
	
	public List<Geek> findBySex(Sex sex) {
		String jpql = "select g from Geek as g where g.sex = :a ";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		query.setParameter("a", sex);
		List<Geek> listeGeeks = query.getResultList();
		return listeGeeks;
	}	

	public List<Geek> findByInterests(Interest inter) {
		String jpql = "select g from Geek as g where g.interests like :a ";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		query.setParameter("a", inter);
		List<Geek> listeGeeks = query.getResultList();
		return listeGeeks;
	}	
	
	public void persist(Geek geek) {
		em.persist(geek);
	}	
	
}
