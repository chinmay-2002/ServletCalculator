package sampleservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddServlett")
public class AddServlett extends HttpServlet {
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html");
	        response.setCharacterEncoding("UTF-8");
	        
	        String num1Str = request.getParameter("num1");
	        String num2Str = request.getParameter("num2");
	        String operation = request.getParameter("operation");
	        
	        if (num1Str == null || num1Str.isEmpty() || num2Str == null || num2Str.isEmpty() || operation == null) {
	            response.getWriter().write("<html><body style=\"background-color: lightblue\">");
	            response.getWriter().write("<h1>Please provide valid input, Don't give extraa white spaces!</h1>");
	            response.getWriter().write("</body></html>");
	            return;
	        }
	        
	        try {
	            int num1 = Integer.parseInt(num1Str);
	            int num2 = Integer.parseInt(num2Str);
	            double result = 0;

	            
	            if ("addition".equals(operation)) {
	                    result = num1 + num2;
	                    
	            }
	            else if ("subtraction".equals(operation)) {
	                    result = num1 - num2;
	                   
	            }
	            else if ("multiplication".equals(operation)) {
	                    result = num1 * num2;
	        }
	            else if ("division".equals(operation)) {
	                    if (num2 != 0) {
	                        result = num1 / num2;
	                    } else {
	                        response.getWriter().write("<html><body style=\"background-color: lightblue\">");
	                        response.getWriter().write("<h1>Division by zero is not allowed</h1>");
	                        response.getWriter().write("</body></html>");
	                        return;
	                    }
	            }
	            else if ("modulo".equals(operation)) {
	                    if (num2 != 0) {
	                        result = num1 % num2;
	                    } else {
	                        response.getWriter().write("<html><body style=\"background-color: lightblue\">");
	                        response.getWriter().write("<h1>Modulo by zero is not allowed</h1>");
	                        response.getWriter().write("</body></html>");
	                        return;
	                    }
	            }
	            else {
	                    response.getWriter().write("<html><body style=\"background-color: lightblue\">");
	                    response.getWriter().write("<h1>Invalid operation</h1>");
	                    response.getWriter().write("</body></html>");
	                    return;
	            }
	            
	            response.getWriter().write("<html><body style=\"background-color: lightblue\">");
	            response.getWriter().write("<h1>Result of " + num1 + " " + operation + " " + num2 + " is: " + result + "</h1>");
	            response.getWriter().write("</body></html>");
	        } catch (NumberFormatException e) {
	            response.getWriter().write("<html><body style=\"background-color: lightblue\">");
	            response.getWriter().write("<h1>Please provide valid numbers, Don't Give Extra Spaces!</h1>");
	            response.getWriter().write("</body></html>");
	        }
	    }
}
