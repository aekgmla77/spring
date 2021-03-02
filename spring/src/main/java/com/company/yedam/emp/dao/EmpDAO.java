package com.company.yedam.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

/*
 *  VO: Value Object (媛믪쓣 ���옣�븯�뒗 媛앹껜)  ==  EmpDTO, EmpDO, Emp
 *  DAO: Data Access Object
 */
@Repository    //@Component 상속
public class EmpDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	public EmpVO selectOne(String id) {
		EmpVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT    EMPLOYEE_ID,"
								+ " FIRST_NAME,"
								+ " LAST_NAME,"
								+ " EMAIL,"
								+ " PHONE_NUMBER,"
								+ " HIRE_DATE,"
								+ " JOB_ID,"
								+ " SALARY,"
								+ " COMMISSION_PCT,"
								+ " MANAGER_ID,"
								+ " DEPARTMENT_ID "
								+ " FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString("employee_id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone_number(rs.getString("phone_number"));
				vo.setHire_date(rs.getDate("hire_date"));
				vo.setJob_id(rs.getString("job_id"));
				vo.setSalary(rs.getString("salary"));
				vo.setCommission_pct(rs.getString("commission_pct"));
				vo.setManager_id(rs.getString("manager_id"));
				vo.setDepartment_id(rs.getString("department_id"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return vo;
	}
	
	public ArrayList<EmpVO> selectList() {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		EmpVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT EMPLOYEE_ID,"
								+ " FIRST_NAME,"
								+ " LAST_NAME,"
								+ " EMAIL,"
								+ " PHONE_NUMBER,"
//								+ " TO_CHAR(HIRE_DATE, 'yyyy-MM'),"
								+ " HIRE_DATE,"
								+ " JOB_ID,"
								+ " SALARY,"
								+ " COMMISSION_PCT,"
								+ " MANAGER_ID,"
								+ " DEPARTMENT_ID"
								+ " FROM EMPLOYEES "
								+ " ORDER BY EMPLOYEE_ID";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new EmpVO();
				vo.setEmployee_id(rs.getString("employee_id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone_number(rs.getString("phone_number"));
				vo.setHire_date(rs.getDate("hire_date"));
				vo.setJob_id(rs.getString("job_id"));
				vo.setSalary(rs.getString("salary"));
				vo.setCommission_pct(rs.getString("commission_pct"));
				vo.setManager_id(rs.getString("manager_id"));
				vo.setDepartment_id(rs.getString("department_id"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return list;
	}
	
	public void insert(EmpVO vo) {
		try {
			// 1. connect
			conn = JdbcUtil.connect();
			// 2. statement(SQL 援щЦ)
			String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID,"
									+ "FIRST_NAME, "
									+ "LAST_NAME,"
									+ "EMAIL,"
									+ "PHONE_NUMBER,"
									+ "HIRE_DATE,"
									+ "JOB_ID,"
									+ "DEPARTMENT_ID)"
								+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			// 3. execute(�떎�뻾)
			pstmt.setString(1, vo.getEmployee_id());
			pstmt.setString(2, vo.getFirst_name());
			pstmt.setString(3, vo.getLast_name());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone_number());
			pstmt.setDate(6, vo.getHire_date());
			pstmt.setString(7, vo.getJob_id());
			pstmt.setString(8, vo.getDepartment_id());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 입력되었습니다.");
			// 4. resultSet(select�씪硫� 議고쉶 寃곌낵)
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 5. close(�뿰寃� �빐�젣)
			JdbcUtil.disconnect(conn);
		}
	}
	
	public EmpVO selectOneByEmail(String email) {
		EmpVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT    EMPLOYEE_ID,"
								+ " FIRST_NAME,"
								+ " LAST_NAME,"
								+ " EMAIL,"
								+ " PHONE_NUMBER,"
								+ " HIRE_DATE,"
								+ " JOB_ID,"
								+ " SALARY,"
								+ " COMMISSION_PCT,"
								+ " MANAGER_ID,"
								+ " DEPARTMENT_ID "
								+ " FROM EMPLOYEES WHERE EMAIL = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new EmpVO();
				vo.setDepartment_id(rs.getString("employee_id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone_number(rs.getString("phone_number"));
				vo.setHire_date(rs.getDate("hire_date"));
				vo.setJob_id(rs.getString("job_id"));
				vo.setSalary(rs.getString("salary"));
				vo.setCommission_pct(rs.getString("commission_pct"));
				vo.setManager_id(rs.getString("manager_id"));
				vo.setDepartment_id(rs.getString("department_id"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return vo;
	}
	
	public void update(EmpVO vo) {
		try {
			// 1. connect
			conn = JdbcUtil.connect();
			// 2. statement(SQL 援щЦ)
			String sql = "UPDATE EMPLOYEES SET "
								+ "FIRST_NAME = ?, "
								+ "LAST_NAME = ?, "
								+ "EMAIL= ?, "
								+ "PHONE_NUMBER= ?, "
								+ "HIRE_DATE= ?, "
								+ "JOB_ID = ?, "
								+ "DEPARTMENT_ID= ? "
								+ "WHERE EMPLOYEE_ID = ?";
			pstmt = conn.prepareStatement(sql);
			// 3. execute(�떎�뻾)
			pstmt.setString(1, vo.getFirst_name());
			pstmt.setString(2, vo.getLast_name());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPhone_number());
			pstmt.setDate(5, vo.getHire_date());
			pstmt.setString(6, vo.getJob_id());
			pstmt.setString(7, vo.getDepartment_id());
			pstmt.setString(8, vo.getEmployee_id());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 수정되었습니다.");
			// 4. resultSet(select�씪硫� 議고쉶 寃곌낵)
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 5. close(�뿰寃� �빐�젣)
			JdbcUtil.disconnect(conn);
		}
	}
}
