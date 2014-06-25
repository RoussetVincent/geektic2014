package com.ninja_squad.geektic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.GeekDao;
import com.ninja_squad.geektic.entity.Geek;
import com.ninja_squad.geektic.entity.Interest;
import com.ninja_squad.geektic.entity.Sex;

import javax.transaction.Transactional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Geek service 
 * @author VR
 */
@RestController
@Transactional
@RequestMapping("/api/geek")
public class GeekService {

	@Autowired
	public GeekDao dao;
	
	@RequestMapping(method = GET)
    public List<Geek> findAll() {
        return dao.findAll();
    }
	
	@RequestMapping(value="/{id}", method = GET)
    public Geek findById(@PathVariable("id") Long id) {
        return dao.findById(id);
    }	
	
	@RequestMapping(value="/{id}/upCptview", method = PUT)
    public Long upCptview(@PathVariable("id") Long id) {
        Geek g = dao.findById(id);
        dao.upCptview(g);
        dao.persist(g);
        return g.getCptview();
    }	
	
	@RequestMapping(value="/sex/{val}", method = GET)
    public List<Geek> findBySex(@PathVariable("val") Sex val) {
        return dao.findBySex(val);
    }	
	
	@RequestMapping(value="/interest/{val}", method = GET)
    public List<Geek> findBySex(@PathVariable("val") Interest val) {
        return dao.findByInterests(val);
    }		
}





