package com.company.yedam.dept.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.yedam.dept.service.DeptService;
import com.company.yedam.emp.dao.DeptDAO;
import com.company.yedam.emp.dao.DeptVO;

@Service
public class DeptServiceImpl implements DeptService{

	@Autowired DeptDAO deptDAO;
	
	@Override
	public ArrayList<DeptVO> deptList() {
		return deptDAO.selectList();
	}

	@Override
	public void deptInsert(DeptVO vo) {
		deptDAO.insert(vo);
	}

}
