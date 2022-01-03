<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Web Catalog</title>
	<link type="text/css" href="${pageContext.request.contextPath}/styles/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page='./Templates/header.jsp'>
	    <jsp:param name="pageName" value="Acceuil"/>
	</jsp:include>
	<jsp:include page='./contents/contenuIndex.jsp'>
	    <jsp:param name="pageName" value="Acceuil"/>
	</jsp:include>
	<jsp:include page='./Templates/footer.jsp'>
	    <jsp:param name="articleId" value=""/>
	</jsp:include>
</body>
</html>