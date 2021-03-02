package com.company.yedam.dept.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.company.yedam.dept.service.DeptService;
import com.company.yedam.emp.dao.DeptVO;
import com.company.yedam.emp.dao.EmpVO;

@Controller
public class DeptController {
	Logger logger = LoggerFactory.getLogger(DeptController.class);

	@Autowired DeptService deptService;
	
	//목록
	@RequestMapping("/deptList")
	public String deptList(Model model) {
		model.addAttribute("deptList", deptService.deptList());
		return "dept/deptList";
	}
	
	//사원 입력폼
	@RequestMapping("/deptInsert")
	public String deptInsert(Model medel) {
	return "dept/deptInsert";
	}
		
	//입력
	@PostMapping("/deptInsert")
	public String deptInsertProc(DeptVO vo) {
	logger.debug(vo.toString());
	deptService.deptInsert(vo);
	return "redirect:deptList";
	}
	
}
