package com.wg.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wg.crud.bean.Employee;
import com.wg.crud.service.EmployService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployService employService;
	
	@RequestMapping("/emps")
	public String getAllEmps(@RequestParam(name="pageNum",defaultValue="1") Integer pageNum ,
			Model model) {
		
		PageHelper.startPage(pageNum, 10);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Employee> allEmps = employService.getAllEmps();
		//传入连续显示的页数
		PageInfo<Employee> pageInfo = new PageInfo<Employee>(allEmps,5);
		model.addAttribute("pageInfo", pageInfo);
		
		return "list";
		
	}
}
