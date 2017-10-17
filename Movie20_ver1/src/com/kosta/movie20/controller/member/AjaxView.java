package com.kosta.movie20.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxView")
public class AjaxView extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Model2에서 Ajax방식으로 응답할 때 사용하는 서블릿
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(request.getAttribute("responseBody").toString());
		out.close();
	}

}
