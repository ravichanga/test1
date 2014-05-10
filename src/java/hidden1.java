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
public class hidden1 extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String n=request.getParameter("uname");
            
             out.println("<form action=\"hidden2\" method=\"get\">");
             out.println("<input type=\"hidden\" name=\"n\"/>");
             out.println("<input type=\"submit\" value=\"ok\"/></form>");
        }
        catch(Exception e){
            
        }
        
        }
}

        