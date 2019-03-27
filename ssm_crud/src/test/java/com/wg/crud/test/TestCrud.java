package com.wg.crud.test;

import static org.junit.Assert.*;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wg.crud.bean.Department;
import com.wg.crud.bean.Employee;
import com.wg.crud.dao.DepartmentMapper;
import com.wg.crud.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestCrud {

	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private SqlSession SqlSession;
	
	@Test
	public void testInsert() {
		
//		departmentMapper.insertSelective(new Department(null, "开发部"));
//		departmentMapper.insertSelective(new Department(null, "测试部"));
		
		//employeeMapper.insertSelective(new Employee(null, empName, gender, email, dId))
		
		EmployeeMapper mapper = SqlSession.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 500; i++) {
			String uidString = UUID.randomUUID().toString().substring(0,5)+""+i;
			mapper.insertSelective(new Employee(null, uidString, "M", uidString+"@xxx.com", 1));
		}
		
	}

}
