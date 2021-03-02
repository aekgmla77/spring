package com.company.yedam.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class JobDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ArrayList<JobVO> selectList(){
		ArrayList<JobVO> list = new ArrayList<JobVO>();
		JobVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "select job_id,"
					+ "job_title,"
					+ "min_salary,"
					+ "max_salary "
					+ "from jobs "
					+ "order by job_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new JobVO();
				vo.setJob_id(rs.getString("job_id"));
				vo.setJob_title(rs.getString("job_title"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.disconnect(conn);
		}
		return list;
	}
}
