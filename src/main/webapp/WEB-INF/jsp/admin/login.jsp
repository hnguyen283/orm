<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/admin/template/header.jsp"></jsp:include>

<jsp:include page="/WEB-INF/jsp/admin/template/navigation.jsp"></jsp:include>
<div class="row">
	<div class="col m6 offset-m3">
		<h3 class="header">Log-in administrator</h3>
		<form id="form_login" method="post">
			<div class="row">
				<div class="input-field">
					<input placeholder="Account" id="txt_account" name="account">
					<label for="txt_account">Account</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field">
					<input placeholder="Password" id="txt_password" name="password" type="password">
				</div>
			</div>
			<div class="row">
				<button class="btn wave-effect wave-light blue darken-3"
					type="submit">Log-in</button>

				<button class="btn wave-effect wave-light red darken-4" type="reset">Reset</button>
			</div>
		</form>
	</div>
</div>

	
</script>
<jsp:include page="/WEB-INF/jsp/admin/template/footer.jsp"></jsp:include>