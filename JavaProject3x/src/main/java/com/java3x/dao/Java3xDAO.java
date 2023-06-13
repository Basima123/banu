package com.java3x.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java3x.dto.Java3xDTO;
import com.java3x.utility.JdbcConnection;

public class Java3xDAO {

	public static boolean insert(Java3xDTO dto) throws SQLException {
		boolean status = false;
		int i = 0, j = 0;
		String num_cstmr = "0003";
		Connection con = null;
		PreparedStatement ps1 = null, ps2 = null;

		con = JdbcConnection.getConnection();
		con.setAutoCommit(false);
		ps1 = con.prepareStatement("insert into idnty_no(idnty_no,idnty_type,num_cstmr) values(?,?,?)");

		ps1.setString(1, dto.getIdNo());
		ps1.setString(2, dto.getIdType());
		ps1.setString(3, num_cstmr);
		i = ps1.executeUpdate();
		ps1.close();
		// TODO Auto-generated method s
		if (i > 0) {
			ps2 = con.prepareStatement(
					"insert into persons (num_cstmr,name,dob,gender,relation,citizen,card,doi,expiry) values (?,?,?,?,?,?,?,?,?)");
			ps2.setString(1, num_cstmr);
			ps2.setString(2, dto.getName());
			ps2.setDate(3, new java.sql.Date(dto.getDob().getTime()));
			ps2.setString(4, dto.getGender());
			ps2.setString(5, dto.getRelation());
			ps2.setString(6, dto.getCitizen());
			ps2.setString(7, dto.getCard());
			if (dto.getDoi() != null) {
				ps2.setDate(8, new java.sql.Date(dto.getDoi().getTime()));
			} else
				ps2.setDate(8, null);
			if (dto.getExpiry() != null) {
				ps2.setDate(9, new java.sql.Date(dto.getExpiry().getTime()));
			} else
				ps2.setDate(9, null);
			j = ps2.executeUpdate();
			ps2.close();
			if (j > 0) {
				con.commit();
				status = true;
			} else
				con.rollback();
		}
		con.close();
		return status;
	}

	public static Java3xDTO view(Java3xDTO dto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=JdbcConnection.getConnection();
		try {
			System.out.println("before query");
			ps=con.prepareStatement("SELECT * FROM IDNTY_NO INNER JOIN PERSONS ON IDNTY_NO.num_cstmr=PERSONS.NUM_CSTMR WHERE idnty_no=? and idnty_type=?");
			System.out.println("after query");
			ps.setString(1, dto.getIdNo());
			ps.setString(2, dto.getIdType());
			rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("getting data from database");
				dto.setIdNo(rs.getString(1));//dto.setIdNo(rs.getString("cloumn name"));
				System.out.println(dto.getIdNo());
				dto.setIdType(rs.getString(2));
				System.out.println(dto.getIdType());
				dto.setName(rs.getString(3));
				System.out.println(dto.getName());
				dto.setRelation(rs.getString(4));
				dto.setGender(rs.getString(5));
				dto.setDob(rs.getDate(6));
				dto.setCitizen(rs.getString(7));
				dto.setCard(rs.getString(8));
				dto.setDoi(rs.getDate(9));
				dto.setExpiry(rs.getDate(10));		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ps.close();
			con.close();
		}
		
		return dto;
	}

}
