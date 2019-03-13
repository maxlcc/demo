package com.jxust.svsh.service;

import com.jxust.svsh.dao.JdbcSqlStudentDaoImpl;
import com.jxust.svsh.dao.StudentDao;
import com.jxust.svsh.model.Pager;
import com.jxust.svsh.model.Student;


public class JdbcSqlStudentServiceImpl implements StudentService {
	private StudentDao studentDao;
	
	public JdbcSqlStudentServiceImpl(){
		studentDao = new JdbcSqlStudentDaoImpl();
	}
	@Override
	public Pager<Student> findStudent(Student searchModel, int pageNum,
			int pageSize) {
		Pager<Student> result = studentDao.findStudent(searchModel, pageNum,
				pageSize);
		return result;
	}

}
