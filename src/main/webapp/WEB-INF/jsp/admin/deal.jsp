<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/admin/template/header.jsp"></jsp:include>

<jsp:include page="/WEB-INF/jsp/admin/template/navigation.jsp"></jsp:include>

<div class="row">
	<div class="container">
		<h3 class="header">${title}</h3>
		<div class="row">
			<form id="form_tableDeal">
				<table class="striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Owner</th>
							<th>Begin - End</th>
							<th>Item</th>
							<th>Price</th>
							<th>Status</th>
							<th>
								<button class="btn wave-effect wave-light" type="button"
									id="btn_reload">
									<i class="fa fa-refresh"></i>
								</button>
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listDeal}" var="deal">
							<tr>
								<td>
									<div class="input-field">
										<input type="checkbox" id="cb_${deal.deal_id}" name="listOrderId" value="${deal.deal_id}"> 
										<label for="cb_${deal.deal_id}"></label>
									</div>
								</td>
								<td>${deal.deal_owner}</td>
								<td>${deal.deal_begin}/${deal.deal_end}</td>
								<td>${deal.tbl_item.item_name}</td>
								<td>${deal.deal_price }</td>
								<td>${deal.deal_status}</td>
								<td>
									<button class="btn wave-effect wave-light btn_edit"
										value="${deal.deal_id}" type="button">
										Edit <i class="fa fa-pencil right"></i>
									</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="7">
								<button class="btn wave-effect wave-light" id="btn_add">Add 
									<i class="fa fa-plus right"></i>
								</button>
								<button class="btn wave-effect wave-light red darken-3" id="btn_delete"
									type="submit">
									Delete <i class="material-icons right">send</i>
								</button></td>
						</tr>
					</tfoot>
				</table>
			</form>
		</div>
	</div>

</div>

<div class="modal modal-fixed-footer" id="modal_deal">
	
		<div class="modal-content">
			<h4>Deal Form</h4>
			<div class="row">
				<form id="form_deal">
				<div class="row hide">
					<div class="input-field">
						<label for="txt_dealId">Deal ID</label> <input id="txt_dealId"
							name="deal_id" placeholder="deal_id" type="text"
							class="validated" disabled="disabled">
					</div>
				</div>
				<div class="row">
					<div class="input-field">
						<label for=""></label> <input placeholder="Owner"
							id="txt_dealOwner" type="text" name="deal_owner"
							class="validated">
					</div>
				</div>
				
				<div class="row">
					<div class="input-field">
						<label for=""></label> <input placeholder="deal begin date"
							id="txt_dealBegin" name="deal_begin" type="date"
							class="validated datepicker">
					</div>
				</div>
				<div class="row">
					<div class="input-field">
						<label for=""></label> <input placeholder="deal end date"
							id="txt_dealEnd" name="deal_end" type="date"
							class="validated datepicker">
					</div>
				</div>
				<div class="row">
					<div class="input-field">
						<label for=""></label> <input placeholder="Deal Price"
							id="txt_dealPrice" name="deal_price" type="number"
							class="validated">
					</div>
				</div>
				<div class="row">
					<div class="input-field">
						<label for=""></label> <input placeholder="deal discount"
							id="txt_dealDiscount" name="deal_discount" type="text"
							class="validated">
					</div>
				</div>
				<div class="row">
					<div class="input-field">
						<label for=""></label> <input placeholder="deal amount"
							id="txt_dealAmount" name="deal_amount" type="number"
							class="validated">
					</div>
				</div>
				<div class="row">
					<div class="input-field">
						<label for=""></label> <input placeholder="deal acceptable amount"
							id="txt_dealAcceptable" name="deal_acceptable" type="number"
							class="validated">
					</div>
				</div>
				<div class="row">
					<div class="input-field">
						<label for=""></label>
						<textarea class="materialize-textarea" cols="5"
							id="txt_dealDescription" name="deal_description"
							placeholder="deal detail description"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="input-field">
						<label></label> <select id="txt_dealStatus" name="deal_status">
							<option value="ACTIVE" selected="selected">Active</option>
							<option value="DEACTIVE">Deactive</option>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="input-field">
						<label></label> <select id="txt_itemId" name="item_id">
							<c:forEach items="${listItem}" var="item">
								<option value="${item.item_id}">${item.item_name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row">
					<button class="modal-close btn wave-effect wave-light" type="submit">Submit</button>
					<button class="btn wave-effect wave-light yellow darken-3"
						type="reset">Reset</button>
				</div>
				</form>
				<div class="row">
					<div class="input-field file-field">
						<div class="btn">
							<span>File</span> 
							<form id="form_files_upload" enctype="multipart/form-data" method="post">
								<input type="file" id="input_files_upload" name="file">
							</form>
						</div>
						<div class="file-path-wrapper">
							<input class="file-path validate" type="text">
						</div>
					</div>
				</div>
			</div>
		</div>		
	
</div>
<div class="row" align="center">
	<ul class="pagination">
		   
	</ul>
</div>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/AppCode/admin/DealManagement.js">
	
</script>
<jsp:include page="/WEB-INF/jsp/admin/template/footer.jsp"></jsp:include>