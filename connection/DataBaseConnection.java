package com.StudentDAO.connection;

import java.sql.*;

public class DataBaseConnection{
    private final String DBDriver ="org.apache.derby.jdbc.ClientDriver";
    private final String DBURL ="jdbc:derby://localhost:3306/demo1";
    private final String DBUSER ="root";
    private final String DBPASSWORD ="1234";
    private Connection conn = null;
//������
    public DataBaseConnection(){
       try{
           Class.forName(DBDriver);
           conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
           }
        catch(Exception e){  }
    }

//�������
    public Connection getConnection(){
        return this.conn;
    }

    //�ر�����
    public void close() throws SQLException{
        this.conn.close();
    }
} 
