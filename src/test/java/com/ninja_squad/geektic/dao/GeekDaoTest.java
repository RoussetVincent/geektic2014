package com.ninja_squad.geektic.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.entity.Geek;
import com.ninja_squad.geektic.entity.Sex;
import com.ninja_squad.geektic.entity.Interest;

import java.util.List;

/**
 * Test class for GeekDao 
 * @author VR
 */
public class GeekDaoTest extends BaseDaoTest {
    
    @Autowired
    private GeekDao geekDao;

    @Before
    public void populateDatabase() {
        Operation operation = Operations.sequenceOf(); // TODO define your operations here.
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }

    @Test
    public void testFindAll() {
    	List<Geek> geeks = geekDao.findAll();
    	assertTrue(geeks.size() > 0);
    }
 
    @Test
    public void testFindById() {
    	Geek geek = geekDao.findById(2L);
    	assertTrue(geek.getId() == 2L);
    }

    @Test
    public void testFindBySex() {
    	List<Geek> geeks = geekDao.findBySex(Sex.FEMININ);
    	for (Geek geek : geeks) {
    		assertTrue(geek.getSex() == Sex.FEMININ);
		}
    }    
    
    @Test
    public void testfindByInterests() {
    	List<Geek> geeks = geekDao.findByInterests(Interest.CSHARP);
    	for (Geek geek : geeks) {
    		assertTrue(geek.getInterests() == Interest.CSHARP);
		}
    }        
    
}






