/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class rd extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String n=request.getParameter("uname");
               if(n.equals("priyanka"))
               {
                   RequestDispatcher rd=request.getRequestDispatcher("rd2");
                   rd.forward(request, response);
               }
               else{
                   response.sendRedirect("p2.html");
               }
               
               
        }
        catch(Exception e){
            
        }
        
        }
}
