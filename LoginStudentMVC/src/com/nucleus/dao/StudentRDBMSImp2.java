package com.nucleus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nucleus.connection.DBConnection;
import com.nucleus.model.StudentInfo;

public class StudentRDBMSImp2 implements StudentDao {

	@Override
	public void retreiveUser(StudentInfo studentInfo) throws Exception {
		DBConnection dbConnection=new DBConnection();
		Connection con=dbConnection.createDBConnection();
	
		
			PreparedStatement pstm=con.prepareStatement("insert into login_001 values (?,?)");
			pstm.setString(1, studentInfo.getId());
			pstm.setString(2, studentInfo.getPassword());
			pstm.executeQuery();
			System.out.println("Record Inserted");
		/*	ResultSet rs=pstm.executeQuery();
			boolean i=rs.next();
			return i;
			*/
			
	}
		
	}

