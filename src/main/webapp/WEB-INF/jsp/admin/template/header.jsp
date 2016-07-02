<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--Import Google Icon Font-->
<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/materialize.min.css"
	media="screen,projection" />
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.min.css" />
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/AdminStyle.css" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="UTF-8" />
<title>${title}</title>
<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/Chart.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.fileupload.js"></script>
<script type="text/javascript">
		var base_URL = "<%=request.getContextPath()%>";
</script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/AppCode/admin/login.js"></script>

<%
	if (request.getSession().getAttribute("userName") == null
			/* && request.getSession().getAttribute("userRole").equals("ADMIN") */) {

		String uri = request.getRequestURI();
		String currentPage = uri.substring(uri.lastIndexOf("/") + 1);
		if (!"login.jsp".equalsIgnoreCase(currentPage)) {
			response.sendRedirect(request.getContextPath() + "/admin/login");
			return;
		}
	}
%>
</head>
<body>