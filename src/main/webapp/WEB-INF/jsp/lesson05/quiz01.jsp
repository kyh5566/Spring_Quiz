<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>1. JSTL core 변수</h1>
	<c:set var="number1" value="36" />
	<c:set var="number2" value="3" />
	<h5>첫번째 숫자 : <c:out value="${number1}" /> </h5>
	<h5>두번째 숫자 : <c:out value="${number2}" /> </h5>
	
	<h1>2. JSTL core 연산</h1>
	<h5>더하기 : <c:out value="${number1 + number2}" /></h5>
	<h5>빼기 : <c:out value="${number1 - number2}" /></h5>
	<h5>곱하기 : <c:out value="${number1 * number2}" /></h5>
	<h5>나누기 : <c:out value="${number1 / number2}" /></h5>
	
	<h1>3. core out</h1>
	<c:out value="<title>core out</title>" />
	
	<h1>4. core if</h1>
	<c:set var="avg" value="${(number1 + number2) / 2}"></c:set>
	<c:if test="${avg >= 10}">
		<h1><c:out value="${avg}"></c:out></h1>
	</c:if>
	<c:if test="${avg < 10}">
		<h3><c:out value="${avg}"></c:out></h3>
	</c:if>
	
	<h1>5. core if</h1>
	<c:if test="${number1 * number2 > 100}">
		<c:out value="<script>alert('너무 큰 수입니다.')</script>" escapeXml="false" />
	</c:if>
		
</body>
</html>