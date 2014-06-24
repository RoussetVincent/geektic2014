package com.ninja_squad.geektic.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.entity.Geek;

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
	
	public List<Geek> findByInterests(String chaine) {
		String jpql = "select g from Geek as g where g.interests like :a ";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		query.setParameter("a", chaine);
		List<Geek> listeGeeks = query.getResultList();
		return listeGeeks;
	}
	
	public void persist(Geek geek) {
		em.persist(geek);
	}	
	
}
