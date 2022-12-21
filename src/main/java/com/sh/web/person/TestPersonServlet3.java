package com.sh.web.person;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
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

public class TestPersonServlet3 extends HttpServlet {
	/**
	 * HttpServletRequest 사용자 요청 관련 정보를 가진 객체 - 사용자입력값 - 요청방식 - cookies - 브라우저 - ...
	 *
	 * HttpServletResponse 사용자 요청 관련 정보를 가진 객체 - 응답 출력 스트림 - cookie - ...
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0. 요청데이터 인코딩 설정(POST만 하면됨. GET안해도됨)
		// get/post 데이터 전송 방식이 다른것뿐. 상황따라 get/post사용 구분됨.
		request.setCharacterEncoding("utf-8");
		// 1. 사용자 입력값 확인
		// name=홍길동&color=빨강&animal=강아지&food=짜장면&food=짬뽕
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] foods = request.getParameterValues("food");

		System.out.println("name=" + name);
		System.out.println("color=" + color);
		System.out.println("animal=" + animal);
		System.out.println("foods=" + (foods != null ? Arrays.toString(foods) : foods));

		// 2. 업무로직
		String recommendation = "";
		switch (color) {
		case "빨강":
			recommendation = "빨간 고추가 들어간 화끈한 우동";
			break;
		case "노랑":
			recommendation = "노랑 단무지랑 따뜻한 우동";
			break;
		case "파랑":
			recommendation = "따뜻한 우동 드시고, 시원한 파워에이드한잔";
			break;
		}
		System.out.println("recommendation = " + recommendation);
		// jsp에 값 전달 - 직접 전달할 수 없으므로 request 속성으로 저장하고, Jsp에서 가져다 사용한다.
		request.setAttribute("recommendation", recommendation);// key, value

		// 2. 응답처리
		// 응답 메시지 메타정보
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/servlet/testPersonResult.jsp");
		reqDispatcher.forward(request, response);

	}

}
