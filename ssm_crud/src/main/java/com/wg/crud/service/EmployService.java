package com.wg.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wg.crud.bean.Employee;
import com.wg.crud.dao.EmployeeMapper;

@Service
public class EmployService {

	@Autowired
	private EmployeeMapper employeeMapper;

	public  List<Employee> getAllEmps() {
		// TODO Auto-generated method stub
		return employeeMapper.selectByExampleWithDept(null);
	}
}
