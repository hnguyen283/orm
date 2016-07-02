<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/admin/template/header.jsp"></jsp:include>

<jsp:include page="/WEB-INF/jsp/admin/template/navigation.jsp"></jsp:include>

<div class="row">

	<div class="col m10 s12 offset-m2">
		<h3 class="header">Product Categories Management</h3>
		<form id="form_type">
			<div class="row">
				<table id="table_type">
					<thead>
						<tr>
							<th></th>
							<th>Category Name</th>
							<th> Category Icon </th>
							<th> Category Description</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${type}" var="type">
							<tr>
							<td>
									<div class="input-field">
										<input type="checkbox" name="listTypeId"
											id="cb_${type.type_id}" value="${type.type_id}"> 
											<label for="cb_${type.type_id}"></label>
											</div>
							</td>
								<td>${type.type_name}</td>
								<td> ${type.type_icon}</td>
								<td> ${type.type_description} </td>
								<td>
									<button class="waves-effect waves-light btn"
										id="btn_edit" value="${type.type_id}">Edit
										<i class="fa fa-pencil right"></i>
									</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="3">
							<a id="bt_addType"
								class="waves-effect waves-light btn" href="#editType">Add
								<i class="fa fa-plus right"></i>
							</a>

								<button class="btn wave-light wave-effect  red darken-3"
									id="bt_submitDelete">
									Delete <i class="material-icons right">send</i>
								</button></td>
						</tr>
					</tfoot>
				</table>
			</div>
		</form>
	</div>
</div>


<div id="editType" class="modal modal-fixed-footer fade">
	<form id="addTypeForm" accept-charset="UTF-8">
		<div class="modal-content">
			<h4 id = "h4_form" align = "center">  </h4>

			<div class="row hide">
				<div class="input-field">
					<input name="type_id" id="type_id" type="text">
					<label for="type_id"></label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<input placeholder="Type name" id="type_name" type="text"
						name="type_name"> <label for="type_name">Type name</label>
				</div>
				<div class="input-field col s6">
   				 		<select id = "type_icon" name = "type_icon">
     					 <option value="fa fa_star" disabled selected>Choose your type icon</option>
      						<option value="fa fa-home">Home</option>
      						<option value="fa fa-star">Star</option>
      						<option value="fa fa-gift">Gift</option>
      						<option value="fa fa-child">Clothes</option>
      						<option value="fa fa-tv">TV</option>
      						<option value="fa fa-cutlery fa-lg">Food</option>
    					</select>
    					<label>Type Icon</label>
  				
				</div>
				
			</div>
			<div class = "row">
				<div class = "input-field col s6">
					<input placeholder="Type Description" id = "type_description" type= "text" name = "type_description" >
					<label for = "type_description"> Type Description</label>
				</div>
			</div>

		</div>

		<div class="modal-footer">
			<button
				class="modal-close btn wave-effect wave-light"
				type="submit" name="action" id="bt_submitAddType">
				Submit <i class="material-icons right">send</i>
			</button>
			<button
				class="modal-action waves-effect waves-green btn-flat yellow darken-4"
				id="bt_cancel" type="reset">
				Reset <i class="material-icons right">close </i>
			</button>
		</div>
		<div id="erroraddType" style="color: red; text-align: center"></div>

	</form>
</div>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/AppCode/admin/TypeManagement.js">
<!--Type  Management-->
	
</script>

<jsp:include page="/WEB-INF/jsp/admin/template/footer.jsp"></jsp:include>