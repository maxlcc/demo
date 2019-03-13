package com.jxust.svsh.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jxust.svsh.Constant;
import com.jxust.svsh.entity.Person;
import com.jxust.svsh.model.PageSize;
import com.jxust.svsh.util.JdbcUtil;

public class PersonDaoImpl extends PersonDAO{
	@Override
	public PageSize<Person> findPerson(Person searchModel , int pageNum,
			int pageSize) {
		PageSize<Person> result = null;
		// 存放查询参数
		List<Object> paramList = new ArrayList<Object>();
		
		String Name = searchModel.getName();
		int gender = searchModel.getId();
		
		StringBuilder sql = new StringBuilder(
				"select * from person where 1=1");
		StringBuilder countSql = new StringBuilder(
				"select count(id) as totalRecord from person where 1=1 ");

		if (Name != null && !Name.equals("")) {
			sql.append(" and name like ?");
			countSql.append(" and name like ?");
			paramList.add("%" + Name + "%");
		}

//		if (gender == Constant.GENDER_FEMALE || gender == Constant.GENDER_MALE) {
//			sql.append(" and gender = ?");
//			countSql.append(" and gender = ?");
//			paramList.add(gender);
//		}
		
		// 起始索引
		int fromIndex	= pageSize * (pageNum -1);
		
		// 使用limit关键字，实现分页
		sql.append(" limit " + fromIndex + ", " + pageSize );
		
		// 存放所有查询出的学生对象
		List<Person> personList = new ArrayList<Person>();
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection(); // 获取数据库链接
			
			// 获取总记录数
			List<Map<String, Object>> countResult = jdbcUtil.findResult(countSql.toString(), paramList);
			Map<String, Object> countMap = countResult.get(0);
			int totalRecord = ((Number)countMap.get("totalRecord")).intValue();
			
			// 获取查询的学生记录
			List<Map<String, Object>> personResult = jdbcUtil.findResult(sql.toString(), paramList);
			if (personResult != null) {
				for (Map<String, Object> map : personResult) {
					Person p = new Person(map);
					personList.add(p);
				}
			}
			
			//获取总页数
			int totalPage = totalRecord / pageSize;
			if(totalRecord % pageSize !=0){
				totalPage++;
			}
			
			// 组装pager对象
			result = new PageSize<Person>(pageSize, pageNum, 
							totalRecord, totalPage, personList);
			
		} catch (SQLException e) {
			throw new RuntimeException("查询所有数据异常！", e);
		} finally {
			if (jdbcUtil != null) {
				jdbcUtil.releaseConn(); // 一定要释放资源
			}
		}
		return result;
	}
	

}
