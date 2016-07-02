<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/admin/template/header.jsp"></jsp:include>

<jsp:include page="/WEB-INF/jsp/admin/template/navigation.jsp"></jsp:include>

<div class="row">
	<h3 class="header container"
		style="padding-top: 50px; padding-bottom: 50px">User Management</h3>
	<div id="message"></div>
	<form id="form_tableUser">
		<table class="highlight bordered responsive-table container "
			id="userTable">
			<thead>
				<tr>
					<th></th>
					<th>Id</th>
					<th>Name</th>
					<!-- 							<th>Pass</th> -->
					<th>Address</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Email 2</th>
					<th>Phone 2</th>
					<th>Status</th>
					<th>Role</th>
					<th></th>
				</tr>
			</thead>
			<tbody id="tbody_user">				
			</tbody>
			<tfoot>
				<tr>
					<td colspan="10"><a id="bt_addUser"
						class="waves-effect waves-light btn modal-trigger"
						href="#editUser">Add</a>
						<button class="btn wave-light wave-effect red darken-3"
							id="bt_Delete">
							Delete <i class="material-icons right">send</i>
						</button></td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>

<div class="row" align="center">
	<ul class="pagination">

	</ul>
</div>

<div id="editUser" class="modal">
	<form class="col s12" id="addUserForm">

		<div class="modal-content">
			<h4>Edit User Form</h4>
			<div class="row">
				<div class="row hide">
					<div class="input-field col s6">
						<input id="user_id" type="text" class="validate" name="user_id">
					</div>
				</div>
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

				<div class="row">
					<div class="input-field col s6">
						<select name="role_name_input" id="role_name_input"
							required="required">
							<c:forEach items="${roles}" var="role">
								<option value="${role.role_name}">${role.role_name}</option>
							</c:forEach>
						</select> <label for="role_name">Role</label>
					</div>
					<div class="input-field col s6">
						<select name="user_status_input" id="user_status_input"
							required="required">
							<option value="ACTIVE">ACTIVE</option>
							<option value="DEACTIVE">DEACTIVE</option>
						</select> <label for="role_name">Status</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input id="user_email" name="user_email" type="email"
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

			<div class="row">
				<span id='messageModal' class="red-text col s6"></span>
			</div>

		</div>
		<div class="modal-footer">
			<button class="btn wave-effect wave-light yellow darken-4"
				type="reset">
				Reset <i class="material-icons right">replay</i>
			</button>
			<button class="modal-action waves-effect waves-green btn"
				type="submit" name="action" id="bt_submitAddUser">
				Submit <i class="material-icons right">send</i>
			</button>

		</div>
	</form>

</div>


<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/AppCode/admin/UserManagerment.js">
</script>
<jsp:include page="/WEB-INF/jsp/admin/template/footer.jsp"></jsp:include>