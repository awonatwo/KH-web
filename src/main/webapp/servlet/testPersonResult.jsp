<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 윗부분은 자바임. 자바로 바뀌게 됨. -->
<%@ page import="java.util.Arrays, java.util.List"%>
<% 
// 자바영역
String name = request.getParameter("name");
String color = request.getParameter("color");
String animal = request.getParameter("animal");
String[] foods = request.getParameterValues("food");
String recommendation = (String)request.getAttribute("recommendation"); // object 타입이라서 String. downcasting. Parent p = new child(); 자식객체를 부모타입으로(업) >>다시 꺼내려면 명시적으로 Child c = (Child) p;로 다운캐스팅 해줘야한다.

System.out.println("name@jsp = " + name);
System.out.println("color@jsp = " + color);
System.out.println("animal@jsp = " + animal);
System.out.println("food@jsp = " + (foods!= null? Arrays.toString(foods) : "없음"));
System.out.println("recommendation@jsp = " + recommendation);

/* String name = "ㅋㅋ";
String color = "노랑";
String animal = "강아지";
String[] foods = {"짜장", "짬뽕"};
 */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>개인취향검사 결과 servlet/jsp</title>
</head>
<body>
	<h1>개인취향검사 결과 servlet/jsp</h1>
	<p>이름 : <%= name %></p>
	<p>좋아하는 색깔 : <%= color %></p>
	<p>좋아하는 동물 : <%= animal %></p>
	<p>좋아하는 음식 : <%= foods!= null? Arrays.toString(foods) : "없음" %></p>
	<hr/>
	<p>오늘은 <mark>???</mark> 어떠세요? </p>
</body>
</html>