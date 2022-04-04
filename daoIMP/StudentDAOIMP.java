package com.StudentDAO.daoIMP;
import com.StudentDAO.bean.Student;
import com.StudentDAO.connection.DataBaseConnection;
import com.StudentDAO.dao.StudentDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOIMP implements StudentDAO{
	// 添加操作
	    public void insert(Student s){
	    	String sql = "INSERT INTO student (id, name) values (?,?)";
			PreparedStatement pstmt = null;
			DataBaseConnection conn = null;
			//针对数据库的具体操作
			try{
				conn = new DataBaseConnection();

				pstmt = conn.getConnection().prepareStatement(sql);
				pstmt.setLong(1,s.getID());
				//pstmt.setString(1,s.getID());
				pstmt.setString(2,s.getName());

				pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			}catch(Exception e){  }
	    }

	    public void update(Student s)
		{
			String sql = "INSERT INTO student (id, name) values (?,?)";
			PreparedStatement pstmt = null;
			DataBaseConnection conn = null;
			//针对数据库的具体操作
			try{
				conn = new DataBaseConnection();

				pstmt = conn.getConnection().prepareStatement(sql);
				pstmt.setLong(1,s.getID());
				//pstmt.setString(1,s.getID());
				pstmt.setString(2,s.getName());

				pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			}catch(Exception e){  }
		}

		public void delete(String iD)
		{
			String sql = "DELETE FROM student WHERE id = ?";
			PreparedStatement pstmt = null;
			DataBaseConnection conn = null;
			//针对数据库的具体操作
			try{
				conn = new DataBaseConnection();

				pstmt = conn.getConnection().prepareStatement(sql);
				//pstmt.setLong(1,s.getID());
				//pstmt.setString(1,s.getID());
				//pstmt.setString(2,s.getName());

				pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			}catch(Exception e){  }
		}
	    
	    public List findAll()
		{
			String sql = "select * from student";
			PreparedStatement pstmt = null;
			DataBaseConnection conn = null;
			Student stu=new Student();
			List<Student> studentList=new ArrayList<>();
			//针对数据库的具体操作
			try{
				conn = new DataBaseConnection();

				pstmt = conn.getConnection().prepareStatement(sql);
				//pstmt.setLong(1,s.getID());
				//pstmt.setString(1,s.getID());
				//pstmt.setString(2,s.getName());

				ResultSet rs=pstmt.executeQuery(sql);
				while(rs.next()){
					stu.setID(rs.getLong("id"));
					stu.setName(rs.getString("name"));
					studentList.add(stu);
				}
				rs.close();
				pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			}catch(Exception e){  }
			return studentList;
		}

		public Student findByID(long iD)
		{
			String sql = "select * from student where iD=?";
			PreparedStatement pstmt = null;
			DataBaseConnection conn = null;
			Student student=new Student();
			//针对数据库的具体操作
			try{
				conn = new DataBaseConnection();

				pstmt = conn.getConnection().prepareStatement(sql);
				//pstmt.setLong(1,s.getID());
				//pstmt.setString(1,s.getID());
				//pstmt.setString(2,s.getName());

				ResultSet rs=pstmt.executeQuery(sql);
				student.setID(rs.getLong("id"));
				student.setName(rs.getString("name"));
				rs.close();
				pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			}catch(Exception e){  }
			return student;
		}
}
