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
import java.sql.*;
import java.io.*;
/**
 * 
 * @author Administrator
 */
public class servapp extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		System.out.println("Driver loaded successfully");
		System.out.println("start the connection");
		Connection con=DriverManager.getConnection("jdbc:odbc:database2");
		System.out.println("connection is successful");
                Statement s=con.createStatement();
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
         /* String a=request.getParameter("st_name");
          int a1=Integer.parseInt(request.getParameter("ajava"));
          int a2=Integer.parseInt(request.getParameter("dbms"));
          int a3=Integer.parseInt(request.getParameter("pc"));
         int sum=(a1+a2+a3);
         double per=(double)((sum*100)/300);
         out.println("mark of ajava is"+a1+"dbms is"+a2+"pc is"+a3);
         out.println("percent is "+per);
         if(per<35)
         {
             out.println("you are failed!!:(");
         }
          else
         {
             out.println("you scored good!!");
             String n="insert into mytable(name,ajava,dbms,pc)values('"+a+"',"+a1+","+a2+","+a3+")";
                ResultSet executeQuery = s.executeQuery(n);
         }*/
         String s2="select * from mytable";
		s.execute(s2);
		ResultSet rs=s.getResultSet();
               String z=request.getParameter("r1");
               if(z.equals("50-70")){
                    out.println("values between 50-70 are: <br/>");
         while((rs!=null)&&(rs.next()))
		{
                        String u1=rs.getString(1);
			int u2=rs.getInt(5);
                        
                        if(u2>=50&&u2<=70){
                        out.print(u1+" ");
                        out.println(u2);
                        out.println("<br/>");
                      
                        }
         
                }
               }
                else{
                    out.println("values between 70-90 are: <br/>");
         while((rs!=null)&&(rs.next()))
		{
                        String u1=rs.getString(1);
                        
			int u2=rs.getInt(5);
                       
                        if(u2>70&&u2<90){
                       
                        out.print(u1+" ");
                        
                        out.println(u2);
                        out.println("<br/>");
                     
         
                }
                }
        }
        }
        
           catch(Exception e){
               
           }
    }
}
