package com.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sms.dto.StudentDTO;
import com.sms.utility.JdbcConnection;

public class StudentDAO {
	// update
	// delete
	// retrive
	// retrive all
	// check login

	public static boolean studentIdCheck(int id) throws SQLException {
		boolean status = false;
		Connection con = JdbcConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("select from student where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {			
			status=true;
		}
		return status;
	}

	// insert
	public static boolean insertStudent(StudentDTO dto) throws SQLException {
		System.out.println("started");
		boolean status = false;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		// call connection
		// insert sql
		// return
		// if(insert)
		try {
		con = JdbcConnection.getConnection();
		ps = con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?)");
		ps.setInt(1, dto.getId());
	
		ps.setString(2, dto.getName());
		
		ps.setDate(3,new java.sql.Date(dto.getDob().getTime()));
		System.out.println("sql date : "+new java.sql.Date(dto.getDob().getTime()));
		// ps.setDate(3, new Date(s.getDate().getTime()));
		ps.setString(4, dto.getAddress());
		System.out.println(dto.getAddress());
		ps.setString(5, dto.getGender());
		ps.setString(6, dto.getLanguage());
		ps.setString(7, dto.getUserName());
		ps.setString(8, dto.getPassword());
		ps.setString(9, dto.getAccess());

		result = ps.executeUpdate();
		if (result > 0) {
			System.out.println("result=" + result);
			status = true;
		}else {
			System.out.println("not inserted");
		}
		}
		catch (Exception e) {
			System.out.println("Insert error");
			e.printStackTrace();
		}
		finally {
		ps.close();
		con.close();
		}
		return status;

	}

	public static boolean updateStudent(StudentDTO dto) throws SQLException {
		boolean status = false;
		PreparedStatement ps = null;
		Connection con = JdbcConnection.getConnection();
		try {
			ps = con.prepareStatement("update student set id=?,name=?,dob=?,address=?,gender=?,language=?,uname=?,password=?,access=? where id=?");
			
			System.out.println(dto.getId());
			ps.setInt(1, dto.getId());
			System.out.println(dto.getName());
			ps.setString(2, dto.getName());
			System.out.println(dto.getDob());
			ps.setDate(3,new java.sql.Date((dto.getDob()).getTime()));
			//pst.setDate(3, new java.sql.Date((u.getDob()).getTime()));
			System.out.println("sql date : "+new java.sql.Date(dto.getDob().getTime()));
			//-- error--- ps.setDate(3, (java.sql.Date) new Date(dto.getDob().getTime()));
			ps.setString(4, dto.getAddress());
			ps.setString(5, dto.getGender());
			ps.setString(6, dto.getLanguage());
			ps.setString(7, dto.getUserName());
			ps.setString(8, dto.getPassword());
			ps.setString(9, dto.getAccess());
			ps.setInt(10, dto.getId());

			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("total updates :" + result);
				status = true;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ps.close();
		con.close();
		return status;
	}

	public static StudentDTO view(int id) throws SQLException {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StudentDTO dto = new StudentDTO();
		ps = con.prepareStatement("select * from student where id=?");
		ps.setInt(1, id);
		rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setDob(rs.getDate(3));
				dto.setAddress(rs.getString(4));
				dto.setGender(rs.getString(5));
				dto.setLanguage(rs.getString(6));
				dto.setUserName(rs.getString(7));
				dto.setPassword(rs.getString(8));
				dto.setAccess(rs.getString(9));

			}
		}

		ps.close();
		con.close();
		return dto;

	}

	public static ArrayList<StudentDTO> viewall() throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = JdbcConnection.getConnection();
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		try {
			
			ps = con.prepareStatement("select * from student");
			rs = ps.executeQuery();
			
			if (rs != null) {
				System.out.println("rs :" + rs);
				while (rs.next()) {
					StudentDTO dto = new StudentDTO();
					dto.setId(rs.getInt(1));
					dto.setName(rs.getString(2));
					dto.setDob(rs.getDate(3));
					dto.setAddress(rs.getString(4));
					dto.setGender(rs.getString(5));
					dto.setLanguage(rs.getString(6));
					dto.setUserName(rs.getString(7));
					dto.setPassword(rs.getString(8));
					dto.setAccess(rs.getString(9));
					list.add(dto);
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ps.close();
			rs.close();
			con.close();
		
		}
		return list;
	}
	
	public static StudentDTO loginCheck(StudentDTO dto) {
		Connection con=null;
		PreparedStatement ps=null;
		//StudentDTO dto=new StudentDTO();
		ResultSet rs=null;
		try {
			con=JdbcConnection.getConnection();
			ps=con.prepareStatement("select * from student where uname=?");
			ps.setString(1,dto.getUserName());
			rs=ps.executeQuery();
			
				while(rs.next())
				{
					dto.setId(rs.getInt(1));
					dto.setName(rs.getString(2));
					dto.setDob(rs.getDate(3));
					dto.setAddress(rs.getString(4));
					dto.setGender(rs.getString(5));
					dto.setLanguage(rs.getString(6));
					dto.setUserName(rs.getString(7));
					dto.setPassword(rs.getString(8));
					dto.setAccess(rs.getString(9));
					
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return dto;
	}

	public static int delete(String list) throws SQLException {
		int status=0;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=JdbcConnection.getConnection();
			ps=con.prepareStatement(" delete from student where id=?");
			ps.setString(1, list);
			status=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ps.close();
			con.close();
		}
		// TODO Auto-generated method stub
		return status;
	}

	public static int deleteAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int status=0;
		con=JdbcConnection.getConnection();
		try {
			ps=con.prepareStatement("delete * from student");
			status=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ps.close();
			con.close();
		}
		// TODO Auto-generated method stub
		return status;
	}
	
	}
		