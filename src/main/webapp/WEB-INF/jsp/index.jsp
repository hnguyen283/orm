<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jsp/template/header.jsp"></jsp:include>

<jsp:include page="/WEB-INF/jsp/template/hor-navigation.jsp"></jsp:include>
<div class="container">

	<!-- 	<div class="row"> -->
	<!-- 		<h3 class="header">Home / Index</h3> -->
	<!-- 	</div> -->
	<link type="text/css" rel="stylesheet"
		href="<%=request.getContextPath()%>/resources/style.css" />
	<div id="preloading">
		<div id="loader-wrapper">
			<div id="loader"></div>
			<div class="loader-section section-left"></div>
			<div class="loader-section section-right"></div>
		</div>
		<div class="row">
			<div class="col s12">
				<ul class="tabs">

					<li class="tab col s3"><a class="active" id="tabIndexNew"
						href="#new">Mới nhất</a></li>
					<li class="tab col s3"><a href="#nearDeadLine"
						id="tabIndexNearDeadline">Gần hết hạn</a></li>
				</ul>
			</div>
			<div id="new" class="col s12">
				<div class='row'>
					<p id="bt_changeSortNew" class="btn waves-effect waves-light">
						Ngược lại <i class="small material-icons">swap_vert</i>
					</p>
				</div>
				<div class='row showDealsBody' id="bodyNew"></div>
			</div>
			<div id="nearDeadLine" class="col s12">
				<div class='row'>
					<p id="bt_changeSortNearDeadLine"
						class="btn waves-effect waves-light">
						Ngược lại <i class="small material-icons">swap_vert</i>
					</p>
				</div>
				<div class='row showDealsBody' id="bodyNearDeadline"></div>
			</div>
		</div>



		<div id="modal_item" class="modal modal-fixed-footer fade">
			<form class="table-hover" id="form_login" accept-charset="UTF-8">
				<div class="modal-content">
					<h4 align="center">Log-in</h4>
					<div class="row">
						<div class="input-field">
							<input placeholder="Account" id="txt_account" name="account"
								type="text"> <label for="txt_account">Account</label>
						</div>
						<div class="input-field">
							<input placeholder="Password" id="txt_password" name="password"
								type="password"> <label for="txt_password">Password</label>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn wave-effect wave-light" type="submit">
						Log-in</button>
					<button class="btn wave-effect wave-light yellow darken-4"
						type="reset">Reset</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/AppCode/index.js">
	
</script>
<jsp:include page="/WEB-INF/jsp/template/footer.jsp"></jsp:include>