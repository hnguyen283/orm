<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<a class="btn-floating btn-large waves-effect waves-light teal darken-2" id="go_top_page"
	style="position: fixed;  top: 50%; left: 95%" >
	<i class="material-icons">keyboard_arrow_up</i>
</a>

<div id="modal_login" class="modal modal-fixed-footer fade">
		<form class="table-hover" id="form_login_static" accept-charset="UTF-8">
			<div class="modal-content">
				<h4 align="center">Log-in</h4>
				<div class="row">
					<div class="input-field">
						<input placeholder="Account" id="txt_account" name="account" type="text">
						<label for="txt_account">Account</label>
					</div>
					<div class="input-field">
						<input placeholder="Password" id="txt_password" name="password" type="password">
						<label for="txt_password">Password</label>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn wave-effect wave-light" type="submit">
					Log-in
				</button>
		      	<button class="btn wave-effect wave-light yellow darken-4" type="reset">
					Reset
		      	</button>
		      	<button class="btn wave-effect wave-light modal-close" type="reset">
					Cancel
				</button>
			</div>
		</form>
</div>

<div id="modal_register" class="modal modal-fixed-footer fade">
		<form class="table-hover" id="form_register" accept-charset="UTF-8">
			<div class="modal-content">
				<h4 align="center">Register</h4>
				<div class="row">
					<div class="row">
						<div class="input-field col s6">
							<input placeholder="Your account name" id="user_name" type="text"
								name="user_name" required="required"> <label
								for="user_name" data-error="wrong" data-success="right">User
								name</label>
						</div>
						<div class="input-field col s6">
							<input placeholder="Your password" id="user_password"
								type="password" class="validate" name="user_password"
								required="required"> <label for="user_password">Password</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input placeholder="Your address" id="user_address"
								name="user_address" type="text" class="validate"
								required="required"> <label for="user_address">Address</label>
						</div>
					</div>

					<div class="row hide">
						<div class="input-field col s6">
							<input id="role_name_input" value="CUSTOMER"
									name="role_name_input" type="text" class="validate">
						</div>
						<div class="input-field col s6">
							<input id="user_status_input" value="OK"
									name="user_status_input" type="text" class="validate">
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input placeholder="Your email 1" id="user_email" name="user_email" type="email"
								class="validate" required="required"> <label
								for="user_email">Email 1</label>
						</div>
						<div class="input-field col s6">
							<input placeholder="Your phone" id="user_phone" name="user_phone"
								type="text" class="validate" required="required"> <label
								for="user_phone">Phone 1</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input placeholder="Your email 2" id="user_email2"
								name="user_email2" type="text" class="validate"> <label
								for="user_email2">Email 2</label>
						</div>
						<div class="input-field col s6">
							<input placeholder="Your phone 2" id="user_phone2"
								name="user_phone2" type="text" class="validate"> <label
								for="user_phone2">Phone 2</label>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn wave-effect wave-light" type="submit">
					Register
				</button>
		      	<button class="btn wave-effect wave-light yellow darken-4" type="reset">
					Reset
		      	</button>
			</div>
		</form>
</div>

<div class="row teal darken-2 footer">
    <div class="col m6 center logo">
        <img style="height: 100px;" alt="Logo" src="<%=request.getContextPath()%>/resources/img-res/logo.png">
    </div>
    <div class="col m6" style="color: white;">
        <h5>A Product Of These Awesome Guys</h5>
        <ul>
            <li>Nguyen Minh Nhat: nguyennhut401@gmail.com</li>
            <li>Nguyen Dong Hung: hungnguyendong@yahoo.com.vn</li>
        </ul>
    </div>
</div>


<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/materialize.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/AppCode/hor-nav.js">
<!--load Menu-->
</script>

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/AppCode/cart.js">
<!--Cart js-->
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/AppCode/login.js">
<!--Login Controller-->
</script>
<script type="text/javascript">
<!--collapse mobile navbar-->
	$(".button-collapse").sideNav();

	$('.modal-trigger').leanModal();
	$('select').material_select();
	$(".dropdown-button").dropdown({
		inDuration : 300,
		outDuration : 225,
		constrain_width : false, // Does not change width of dropdown to that of the activator
		hover : true, // Activate on hover
		//gutter : 0, // Spacing from edge
		belowOrigin : true, // Displays dropdown below the button
		alignment : 'left' // Displays dropdown with edge aligned to the left of button
	});

	$(document).ready(function() {
		$('.slider').slider({
		// 			full_width : true,
		});
	});

	function alertMessage(content) {
		Materialize.toast(content, 3000);
	}
</script>
</body>
</html>