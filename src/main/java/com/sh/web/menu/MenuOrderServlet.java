package com.sh.web.menu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenuOrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.전송값에 한글이 있을 경우 인코딩처리해야함.
		req.setCharacterEncoding("utf-8");

		// 2.전송값 꺼내서 변수에 기록하기.
		String mainMenu = req.getParameter("mainMenu");
		String sideMenu = req.getParameter("sideMenu");
		String drinkMenu = req.getParameter("drinkMenu");
		System.out.println("mainMenu=" + mainMenu);
		System.out.println("sideMenu=" + sideMenu);
		System.out.println("drinkMenu=" + drinkMenu);

		// request객체의 RequestDispatcher에 view단 지정
		// RequestDispatcher는 인터페이스
//		RequestDispatcher reqDispatcher = req.getRequestDispatcher("/jsp/04_menuEnd.jsp");
		RequestDispatcher reqDispatcher = getServletContext().getRequestDispatcher("/menu/menuEnd.jsp");
		reqDispatcher.forward(req, resp);

	}

}
