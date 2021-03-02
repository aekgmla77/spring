package com.company.yedam.emp.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.yedam.emp.dao.EmpVO;
import com.company.yedam.emp.service.EmpService;

@Controller   //@Component�옉 媛숈쓬  1.而⑦뀒�씠�꼫�뿉 鍮덉쑝濡� �벑濡�, 而⑦듃濡ㅻ윭�솕 �떆耳쒖쨲
public class EmpController {
	
	Logger logger = LoggerFactory.getLogger(EmpController.class);

	@Autowired EmpService empService;
	//사원 목록
	@RequestMapping("/empList")
	public String empList(Model model) {
		model.addAttribute("list", empService.empList());
		return "emp/empList";
	}
	//사원 입력폼
	@RequestMapping("/empInsert")
	public String empInsert(Model medel) {
//		medel.setAttribute("jobList", jobDAO.selectList());
//		medel.setAttribute("deptList", deptDAO.selectList());
		return "emp/empInsert";
	}
	
	//입력
	@PostMapping("/empInsert")
	public String empInsertProc(EmpVO vo) {
		logger.debug(vo.toString());
		empService.empInsert(vo);
		return "redirect:empList";
	}
	
	//수정폼
	@RequestMapping("/empUpdate")
	public String empUpdate(EmpVO vo, Model model) {
		model.addAttribute("empVO", empService.selectOne(vo));
//		request.setAttribute("jobList", jobDAO.selectList());
//		request.setAttribute("deptList", deptDAO.selectList());
		return "emp/empInsert";
	}
	
	//수정
	@PostMapping("/empUpdate")
	public String empUpdateProc(EmpVO vo) {
		logger.debug(vo.toString());
		empService.empUpdate(vo);
		return "redirect:empList";
	}
	
	//이메일 확인
	@RequestMapping("/empEmail")
	@ResponseBody
	public String emailCheck(EmpVO vo, Model model) {
		StringBuffer stringBuffer = new StringBuffer();
		model.addAttribute("empVO", empService.selectOneByEmail(vo));
		if(empService.selectOneByEmail(vo) == null) {
			stringBuffer.append("<email>");
			stringBuffer.append("true");
			stringBuffer.append("</email>");
		} else {
			stringBuffer.append("<email>");
			stringBuffer.append("false");
			stringBuffer.append("</email>");
		}
		return stringBuffer.toString();
	}
	
	//매니저 검색
	@RequestMapping("/empSerch")
	public String empSearch(EmpVO vo, Model model) {
		model.addAttribute("list", empService.empSearch(vo));
		return "emp/empSearch";
	}
}
