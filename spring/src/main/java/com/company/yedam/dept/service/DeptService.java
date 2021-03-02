package com.company.yedam.dept.service;

import java.util.ArrayList;

import com.company.yedam.emp.dao.DeptVO;

public interface DeptService {

	ArrayList<DeptVO> deptList();
	void deptInsert(DeptVO vo); 
}
