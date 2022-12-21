<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--jsp 주석 --%>
<%--
    지시어 (directive)
    <%@ page %> 기본설정
    <%@ include %> 다른 페이지를 포함하는 설정
    <%@ taglib %> jsp tag 사용 선언 문법
    
    자바코드
    <% %> scriptlet
    <%= %> 출력식
    
    jsp는 servlet으로 변환되어 처리된다. 지역 서버 하위 work/Catalina/localhost/web/org/apache/jsp/에서 변환
    
     --%>

<%
/*
자바영역 : 서버에서 돌아감. 그리고 html을 돌려줌. 브라우저는 자바코드 줘봐야 이해할 수 없어. 결과만 돌려줌.
이미 끝났어. 자바의 int num = 1; 자바 변수인 num에 자바스크립트가 접근하는 방법은 없다. 브라우저는 몰라. 자바를. 
자바스크립트 변수 #sum에 자바가 접근하는 방법도 없다. 처리 순서 적으로 말이 안돼.

처리 순서
 client >>>>>>>>server : 1 자바영역
        <<<<<<<		   : 2 아래 html영역
 2번에서 서버>>클라이언트 html로 55돌아오고 #sum에서 55 찍어줌.
*/
// 1~10 합 구하기
int sum = 0;
for (int i = 1; i <= 10; i++) {
	sum += i;
}
System.out.println("sum = " + sum);

int num=(int)(Math.random()*10)+1;


long time = System.currentTimeMillis();
System.out.println(time);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Basics</title>
<script>
window.onload = () => {
	let sum = 0;
	for(let i =1; i<=10; i++) {
		sum += i;
		document.querySelector("#sum").innerHTML = sum;
 	let time = Date.now();
	document.querySelector("#now").innerHTML = time;
	}
}
</script>
</head>
<body>
	<h1>JSP Basics</h1>
	<%-- jsp 주석 --%>
	<!-- html 주석은 결과를 가져오긴함. 아예 sum안찍히려면 jsp주석 써야함. -->
	<ul>
		<li>Server Side : <span> <%--<%=sum%>--%>
		</span></li>
		<!-- singular -->
		<li>Server Side : <span> <!-- <%=sum%> -->
		</span></li>
		<li>Server Side : <span><%=sum%></span></li>
		<li>Client Side : <span id="sum"></span></li>
	</ul>
	<ul>

		<li>Server Side : <span><%=time%></span></li>
		<li>Client Side : <span id="now"></span></li>
	</ul>

	<h2>분기처리</h2>
	<%
	if (num % 2 == 0) {
	%>
	<p><%=num%>은 짝수입니다.
	</p>
	<%
	} else {
	%>
	<p><%=num%>은 홀수입니다.
	</p>
	<%
	}
	%>
	<%-- mode=en | ko | num --%>
	<p>abcdefg</p>
	<p>가나다라마바</p>
	<p>1234567890</p>

	<%
	String mode = request.getParameter("mode");
	switch (mode) {
	case "en":
	%>
	<p>abcedfg</p>
	<%
	;
		break;
	case "ko":
	%>
	<p>가나다라마바</p>
	<%
	;
		break;
	case "num":
	%>
	<p>1234567890</p>
	<%
	;
		break;
	}
	%>

	<h2>반복처리</h2>
	<ul>
		<!-- multiple -->
		<%
		String[] names = { "홍길동", "신사임당", "이순신" };
		for (int i = 0; i < names.length; i++) {
		%>

		<li><%=names[i]%></li>
		<%
		}
		%>
	</ul>
	<%
List<String> webLangs = new ArrayList<>();
/* getParameterValues returns multiple values in only String[]type not List<> */
webLangs.add("html");
webLangs.add("css");
webLangs.add("javascript");
%>
	<ol>
		<%
		for (int i = 0; i < webLangs.size(); i++) {
		%>
		<li><%=webLangs.get(i)%></li>
		<%
		}
		%>
	</ol>

	<%-- 
	@실습문제 : no, prod, option값 테이블 태그로 표시
	no   | 1
	상품명 | 
	옵션1 | 
	옵션2 | 
<%-- no=2&prod=설렁탕&option=다대기많이&option=곱빼기&option=당면빼고 --%>

	<%
String no = request.getParameter("no");
String prod = request.getParameter("prod");
String option1 = request.getParameter("option1");
String[] option = request.getParameterValues("option");

%>
	<table>
		<tbody>
			<tr>
				<th>주문번호</th>
				<td><%=no%></td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><%=prod%></td>
			</tr>
			<tr>
				<%
				for (int i = 0; i < option.length; i++) {
				%>
				<th>옵션<%=i + 1%></th>
				<td><%=option[i]%></td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>


</body>
</html>