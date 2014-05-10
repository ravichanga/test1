/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
 import java.sql.*;
import java.io.*;
public class myservlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		System.out.println("Driver loaded successfully");
		System.out.println("start the connection");
		Connection con=DriverManager.getConnection("jdbc:odbc:db");
		System.out.println("connection is successful");
     
    Statement s=con.createStatement();
		

   response.setContentType("text/html");
		PrintWriter out=response.getWriter();		
   String i=request.getParameter("id");
   String n=request.getParameter("name");
   out.println("id="+i+" name="+n);
   String s2="select * from student";
		s.execute(s2);
		ResultSet rs=s.getResultSet();
                int flag=0;
		while((rs!=null)&&(rs.next()))
		{
                        String u1=rs.getString(1);
			String u2=rs.getString(2);	
                if(i.equals(u1)&& n.equals(u2))
                {
                        flag=1;
                    out.println("valid");
                    break;
                    
                }
		}
                if(flag==0)
                {
                    out.println("invalid");
                }
                
		con.close();	
        }
        catch(Exception e){
            
        }
   
}
}
