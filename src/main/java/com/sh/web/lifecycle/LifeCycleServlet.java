package com.sh.web.lifecycle;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
// HttpServlet servlet = new LifeCycleServlet(); : 실제 만들어진 객체가 LifeCycleServlet의 오버라이드한 우리가 만든 doGet 호출됨. 원래라면 HttpServlet의 doGet호출돼야하는데.
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */

/**
 * @webServlet("/lifeCycle.do") -> we.xml에 url과 servlet class 매핑 처리
 * 
 * Servlet 생명주기 (tomcat은 각 servlet객체를 하나씩만 만들어서 운영한다. - singleton pattern)
 * (tomcat은 매 요청마다 새로운 스레드를 할당해서 처리한다. 응답성 향상 효과) 1. servlet 객체 생성 - 해당 url 요청이
 * 최초 발생한 경우. 2. @PostConstruct 메소드 호출 3. init메소드 호출
 * 
 * 4. service메소드 호출 : 실제 요청에 관한 처리. - 전송방식별 메소드 호출 (doGet, doPost, ...)
 * 
 * 5. destroy 메소드 호출 6. @PreDestroy 메소드 호출 : destroy 직전. 7. 메모리 반환
 *
 */
@WebServlet("/lifeCycle.do")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet() 생성
	 */
	public LifeCycleServlet() {
		System.out.println("[LifeCycleServlet 생성자 호출]");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("[LifeCycleServlet@PostConstruct 호출]");

	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("[LifeCycleServlet#init 호출]");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[LifeCycleServlet#doGet 호출]");

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("[LifeCycleServlet@preDestroy 호출]");

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("[LifeCycleServlet#destroy 호출]");
	}

}
