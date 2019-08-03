package com.hsc.jdbc_dao.test;

import com.hsc.jdbc_dao.StudentDao;
import com.hsc.jdbc_dao.impl.StudentDaoImpl;
import org.junit.Test;

public class TestStudentDaoImpl {
    @Test
    public void testFindAll() {

        StudentDao dao = new StudentDaoImpl();
        dao.findAll();
    }

    @Test
    public void testLoadin() {

        StudentDao dao = new StudentDaoImpl();
        dao.loadin("paul", "aa22121' or '1=1");
//		dao.loadin("paul", "22121");
    }

    @Test
    public void testInsert() {
        StudentDao dao = new StudentDaoImpl();
        dao.insert("bryant", 30, "22125");
    }

    @Test
    public void testDelete() {
        StudentDao dao = new StudentDaoImpl();
        dao.delete(8);
    }

    @Test
    public void testUpdate() {
        StudentDao dao = new StudentDaoImpl();
        dao.update(7, "10086");
    }
}
