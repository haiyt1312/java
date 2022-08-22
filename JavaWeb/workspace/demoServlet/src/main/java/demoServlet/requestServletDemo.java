package demoServlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/test-request"})
public class requestServletDemo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Phuong thuc cua request: " + req.getMethod());
		
		req.getContentType();
		req.getContextPath();
		System.out.println(req.getContentType());
		System.out.println(req.getContextPath());
		
		Enumeration<String> keys = req.getHeaderNames();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			System.out.println(key + " : " + req.getHeader(key));
		}
	}
}
