package com.sh.web.person;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servet이란? 웹서비스를 처리하기 위한 자바클래스 -HttpServlet class를 상속해야한다.
 * 
 * Servlet Interface -GenericSevlet 추상클래스 -HttpServlet 추상클래스 -
 * TestPersonServlet1
 * 
 * GET /web/testPerson1.do -> TestPersonServlet1#doGet
 * 
 * @author yull
 *
 */

public class TestPersonServlet2 extends HttpServlet {
	/**
	 * HttpServletRequest 사용자 요청 관련 정보를 가진 객체 - 사용자입력값 - 요청방식 - cookies - 브라우저 - ...
	 *
	 * HttpServletResponse 사용자 요청 관련 정보를 가진 객체 - 응답 출력 스트림 - cookie - ...
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0. 요청데이터 인코딩 설정(POST만 하면됨. GET안해도됨)
		//get/post 데이터 전송 방식이 다른것뿐. 상황따라 get/post사용 구분됨.
		request.setCharacterEncoding("utf-8");
		// 1. 사용자 입력값 확인
		// name=홍길동&color=빨강&animal=강아지&food=짜장면&food=짬뽕
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] foods = request.getParameterValues("food");

		System.out.println("name=" + name);
		System.out.println("name=" + name);
		System.out.println("name=" + name);
		System.out.println("foods=" + (foods != null ? Arrays.toString(foods) : foods));

		// 2. 응답처리
		// 응답 메시지 메타정보
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>개인취향검사 결과 POST</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>개인취향검사 결과</h1>");
		out.println("<p>이름 : " + name + "</p>");
		out.println("<p>좋아하는 색깔 : " + color + "</p>");
		out.println("<p>좋아하는 동물 : " + animal + "</p>");
		out.println("<p>좋아하는 음식 : ");
		if (foods != null) {
			for (int i = 0; i < foods.length; i++) {
				out.print(foods[i]);
				if (i != foods.length - 1) {
					out.print(",");
				}
			}
		} else {
			out.print("없음");
		}
		out.println("</body>");
		out.println("</html>");

	}

}
