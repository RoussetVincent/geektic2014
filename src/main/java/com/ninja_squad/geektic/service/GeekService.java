package com.ninja_squad.geektic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.GeekDao;
import com.ninja_squad.geektic.entity.Geek;

import javax.transaction.Transactional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Geek service 
 * @author JB Nizet
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
	
}





