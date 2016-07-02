<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul id="dropdown1" class="dropdown-content">
	<%
		if (request.getSession().getAttribute("userRole") != null) {
			String role = request.getSession().getAttribute("userRole").toString();
			if ("ADMIN".equalsIgnoreCase(role)) {
				%>
				<li><a href="<%=request.getContextPath()%>/admin/user">User-Role Management</a></li>
				<li><a href="<%=request.getContextPath()%>/admin/order">Order-Order Detail Management</a></li>
				<li><a href="<%=request.getContextPath()%>/admin/checkdeal">Deal Report</a></li>
				<li><a href="<%=request.getContextPath()%>/admin/deal">Deal Management</a></li>
				<li class="divider"></li>
				<li><a href="<%=request.getContextPath()%>/admin/product">item Management</a></li>
				<li><a href="<%=request.getContextPath()%>/admin/categories">Categories Management</a></li>
				<li><a href="<%=request.getContextPath()%>/admin/">DashBoard</a></li>
				<%
			} else if ("ASSISTANT".equalsIgnoreCase(role)) {
				%>
				<li><a href="<%=request.getContextPath()%>/admin/product">item Management</a></li>
				<li><a href="<%=request.getContextPath()%>/admin/categories">Categories Management</a></li>
				<%
			}
		} else {
			String uri = request.getRequestURI();
			String currentPage = uri.substring(uri.lastIndexOf("/") + 1);
			if (!"login.jsp".equalsIgnoreCase(currentPage)) {
				%>
				<script type="text/javascript">
					window.location = base_URL + "/admin/login";
				</script>
				<%
			}
		}
	%>
</ul>

<ul id="dropdown2" class="dropdown-content">
	<%
		if (request.getSession().getAttribute("userRole") != null) {
			String role = request.getSession().getAttribute("userRole").toString();
			if ("ADMIN".equalsIgnoreCase(role)) {
				%>
				<li><a href="<%=request.getContextPath()%>/admin/user">User-Role Management</a></li>
				<li><a href="<%=request.getContextPath()%>/admin/order">Order-Order Detail Management</a></li>
				<li><a href="<%=request.getContextPath()%>/admin/checkdeal">Deal Report</a></li>
				<li class="divider"></li>
				<li><a href="<%=request.getContextPath()%>/admin/product">Item Management</a></li>
				<li><a href="<%=request.getContextPath()%>/admin/categories">Categories Management</a></li>
				<%
			} else if ("ASSISTANT".equalsIgnoreCase(role)) {
				%>
				<li><a href="<%=request.getContextPath()%>/admin/product">item Management</a></li>
				<li><a href="<%=request.getContextPath()%>/admin/categories">Categories Management</a></li>
				<%
			}
		} else {
			String uri = request.getRequestURI();
			String currentPage = uri.substring(uri.lastIndexOf("/") + 1);
			if (!"login.jsp".equalsIgnoreCase(currentPage)) {
				%>
				<script type="text/javascript">
					window.location = base_URL + "/admin/login";
				</script>
				<%
			}
		}
	%>
</ul>

<nav class="grey darken-4">
	<ul class="left">
		<li><a href="<%=request.getContextPath()%>"> 
			<img style="margin-top: 7px !important; height: 50px !important; width: 90px !important;" class="col m12"
						src="<%=request.getContextPath()%>/resources/img-res/logo.png" />
			</a>
		</li>
	</ul>
	<ul class="right hide-on-med-and-down">
		<li><a class="dropdown-button" href="#!" data-beloworigin="true"
			data-activates="dropdown1" style="width: 350px !important;">Pages<i class="material-icons right">arrow_drop_down</i></a></li>


		<li><a href="#"> <i class="material-icons left">perm_identity</i>
				<%=request.getSession().getAttribute("userName")%></a></li>
		<li><a href="#" class="btn_logout"><i
				class="material-icons left">power_settings_new</i>Log-Out</a></li>
	</ul>
	
	<ul id="slide-out" class="side-nav">
		<li class="logo"><a href="#"><h3>ADMIN</h3></a></li>

		<li><a class="dropdown-button" href="#!" data-beloworigin="true"
			data-activates="dropdown2">Dropdown<i
				class="material-icons right">arrow_drop_down</i></a></li>

		<li><a href="#!"> <i class="material-icons left">perm_identity</i>
				<%=request.getSession().getAttribute("userName")%>
		</a></li>
		<li><a href="#!" class="btn_logout"><i
				class="material-icons left">power_settings_new</i>Log-Out</a></li>


	</ul>
	<a href="#" data-activates="slide-out" class="button-collapse"><i
		class="mdi-navigation-menu"></i></a>
</nav>