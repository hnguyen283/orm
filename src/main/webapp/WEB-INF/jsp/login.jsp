<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jsp/template/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/jsp/template/hor-navigation.jsp"></jsp:include>
<div class="container">
	<h3 class="header">User Login</h3>
	<form id="form_login">
		<div class="row">
			<div class="input-field">
				<input placeholder="User Name Or Email" id="txt_userName"
					name="account" type="text" class="validate"> <label
					for="txt_userName">Account</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field">
				<input placeholder="Password" id="txt_password" name="password"
					type="password" class="validate"> <label for="txt_password">Password</label>
			</div>
		</div>
		<div class="row">
			<button class="btn wave-effect wave-light" type="submit">
				Submit<i class="material-icons right">send</i>
			</button>
			
			<button class="btn wave-effect wave-light yellow darken-4" type="reset">Reset<i class="material-icons right">replay</i></button>
		</div>
	</form>
</div>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/AppCode/login.js">
<!--Login Controller-->
</script>
<jsp:include page="/WEB-INF/jsp/template/footer.jsp"></jsp:include>