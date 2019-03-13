package com.jxust.svsh.service;

import com.jxust.svsh.dao.StudentDao;
import com.jxust.svsh.dao.SublistStudentDaoImpl;
import com.jxust.svsh.model.Pager;
import com.jxust.svsh.model.Student;


public class SublistStudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	public SublistStudentServiceImpl() {
		// 创建servivce实现类时，初始化dao对象。
		studentDao = new SublistStudentDaoImpl();
	}

	@Override
	public Pager<Student> findStudent(Student searchModel, int pageNum,
			int pageSize) {
		Pager<Student> result = studentDao.findStudent(searchModel, pageNum,
				pageSize);
		return result;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
}
