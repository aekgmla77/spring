package com.company.yedam.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class DeptDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	public ArrayList<DeptVO> selectList() {
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		DeptVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT DEPARTMENT_ID,"
					+ "DEPARTMENT_NAME,"
					+ "MANAGER_ID,"
					+ "LOCATION_ID "
					+ "FROM DEPARTMENTS "
					+ "ORDER BY DEPARTMENT_ID";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new DeptVO();
				vo.setDepartment_id(rs.getString("department_id"));
				vo.setDepartment_name(rs.getString("department_name"));
				vo.setManager_id(rs.getString("manager_id"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.disconnect(conn);
		}
		return list;
	}
	
	public void insert(DeptVO vo) {
		try {
			conn = JdbcUtil.connect();
			String sql = "INSERT INTO DEPARTMENTS"
						+ "(DEPARTMENT_ID, "
						+ "DEPARTMENT_NAME, "
						+ "MANAGER_ID, "
						+ "LOCATION_ID) "
						+ "VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getDepartment_id());
			pstmt.setString(2, vo.getDepartment_name());
			pstmt.setString(3, vo.getManager_id());
			pstmt.setString(4, vo.getLocation_id());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 입력되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.disconnect(conn);
		}
	}
}
