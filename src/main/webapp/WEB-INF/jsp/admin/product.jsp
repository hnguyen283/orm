<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/admin/template/header.jsp"></jsp:include>

<jsp:include page="/WEB-INF/jsp/admin/template/navigation.jsp"></jsp:include>
	<div class="row">
		<div class="col s11 offset-s1">
			<h3 class="header">${title}</h3>
			<div class="row">
				<form id="form_tableItem">
					<table class="striped" id="itemTable">
						<thead>
							<tr>
								<td></td>
								<td>Product's owner</td>
								<td>Product Name</td>
								<td>Product description</td>
								<td>Product describe</td>
								<td>Type</td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							
						</tbody>
						<tfoot>
							<tr>
								<td colspan="7">
									<button class="btn wave-effect wave-light" id="btn_add">Add
										<i class="fa fa-plus right"></i>
									</button>
									<button class="btn wave-light wave-effect red darken-3"
										id="bt_Delete">
										Delete <i class="material-icons right">send</i>
									</button>
								</td>
							</tr>
						</tfoot>
					</table>
				</form>
			</div>
		</div>
		
	</div>
	
	
	<div id="modal_item" class="modal modal-fixed-footer fade">
		<form class="table-hover" id="form_item" accept-charset="UTF-8">
		    <div class="modal-content">
		      	<h4 id="h4_form" align="center"></h4>
		     	<div class="row">
		     		<div class="row hide">
						<div class="input-field col s6">
							<input id="item_id"
								type="text" class="validate" name="item_id"> 
						</div>
					</div>
		     		<div class="row">
					       <div class="input-field col s6">
					         <input placeholder="Product's owner" id="item_owner" name="item_owner" type="text" required="required">
					         <label for="item_owner">Product's owner</label>
					       </div>
					       <div class="input-field col s6">
					         <input placeholder="Product name" id="item_name" name="item_name" type="text" required="required">
					         <label for="item_name">Product name</label>
					       </div>
					</div>
					<div class="row">
					       <div class="input-field col s6">
					         <textarea placeholder="Product description" id="item_description" name="item_description" class="materialize-textarea validate">
					         </textarea>
					         <label for="item_description">Product description</label>
					       </div>
					       <div class="input-field col s6">
					         <textarea placeholder="Product describe" id="item_describe" name="item_describe" class="materialize-textarea validate">
					         </textarea>
					         <label for="item_describe">Product describe</label>
					       </div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<select name="tbl_type" id="tbl_type">
								<c:forEach items="${types}" var="type">
									<option value="${type.type_id}">${type.type_name}</option>
								</c:forEach>
							</select>
							<label>Type</label>
						</div>
					</div>
		     	</div>
		    </div>
	    <div class="modal-footer">
	    	<button class="btn wave-effect wave-light" type="submit">
				Submit
			</button>
	      	<button class="btn wave-effect wave-light yellow darken-4" type="reset">
				Reset
	      	</button>
	    </div>
	  </form>
  </div>
  
  <div class="row" align="center">
	  	<ul class="pagination">
		   
	 	</ul>
  </div>
  
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/AppCode/admin/ProductManagement.js">
</script>


<jsp:include page="/WEB-INF/jsp/admin/template/footer.jsp"></jsp:include>