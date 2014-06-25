package com.ninja_squad.geektic.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.GeekDao;
import com.ninja_squad.geektic.dao.LogDao;
import com.ninja_squad.geektic.entity.Geek;
import com.ninja_squad.geektic.entity.Log;

import static org.springframework.web.bind.annotation.RequestMethod.*;


/**
 * Log service 
 * @author VR
 */
@RestController
@Transactional
@RequestMapping("/api/log")
public class LogService {

	@Autowired
	public LogDao dao;	
	
	@Autowired
	public GeekDao daoGeek;	
	
	@RequestMapping(value="/add/{idGeek}", method = GET)
    public void addLog(@PathVariable("idGeek") Long idGeek) {
        Geek g = daoGeek.findById(idGeek);
        Log log = new Log(g);
        dao.persist(log);
    }	
	
}




